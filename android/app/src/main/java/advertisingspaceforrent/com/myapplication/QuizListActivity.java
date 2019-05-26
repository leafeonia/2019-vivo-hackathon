package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import advertisingspaceforrent.com.myapplication.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizListActivity extends AppCompatActivity {

    private ListView mquizList;
    private Integer mLanguageId;
    List<Category> cateList;
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
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {

        Intent intent = getIntent();
        mLanguageId = intent.getIntExtra("languageId",1);
//        Toast.makeText(QuizListActivity.this,"lan ID" + Integer.toString(languageId),Toast.LENGTH_SHORT).show();
        APIService apiService = APIUtil.getAPIService();
//        Map<String,String> map = new LinkedHashMap<>();
//        map.put("languageId",mLanguageId.toString());
        Call<ResponseVO> call = apiService.getQuizList(mLanguageId);
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                    String json = gson.toJson(response.body().getContent());
                    cateList = gson.fromJson(json, new TypeToken<List<Category>>() {}.getType());
                } else {
                    ToastUtil.showToast(QuizListActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(QuizListActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });
        Map quizs = new HashMap();
        for (Category c : cateList){
            String temp;
            if(c.getFinished() == 0) temp = "completed*26";
            else temp = "not completed*26";
            quizs.put(c.getName(),temp);
        }
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
