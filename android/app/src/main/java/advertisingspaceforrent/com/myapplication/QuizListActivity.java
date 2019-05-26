package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.Category;
import advertisingspaceforrent.com.myapplication.vo.Question;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizListActivity extends AppCompatActivity {

    List<Category> cat;
    private ListView mquizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mquizList = (ListView)findViewById(R.id.lv_quizList);
        mquizList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent i = new Intent(QuizListActivity.this, PlayingActivity.class);
                i.putExtra("categoryId",1);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        Intent intent = getIntent();
        Integer languageId = intent.getIntExtra("languageId",1);
        APIService apiService = APIUtil.getAPIService();
        Call<ResponseVO> call = apiService.getQuizList(languageId);
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                    String json = gson.toJson(response.body().getContent());
                    cat = gson.fromJson(json,new TypeToken<List<Category>>(){}.getType());
                    Log.i("***TEST***",cat.get(0).getName());
                } else {
                    ToastUtil.showToast(QuizListActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(QuizListActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });
//        Toast.makeText(QuizListActivity.this,"lan ID" + Integer.toString(languageId),Toast.LENGTH_SHORT).show();
        //TODO: "/category/get" languageId =  languageId  ,
        Map quizs = new HashMap();
//        for (Category c : cat)
        quizs.put("string的使用","completed*28");
        quizs.put("面向对象的概念", "not completed*16");
        Set<Map.Entry<String,String>> entrys = quizs.entrySet();
        List<Map.Entry<String,String>> quizList = new ArrayList<>(entrys);
        mquizList.setAdapter(new QuizAdapter(quizList,QuizListActivity.this));
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            Intent i = new Intent(QuizListActivity.this,HomepageActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
