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
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.CategoryVO;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizListActivity extends AppCompatActivity {

    private ListView mquizList;
    private Integer mLanguageId;
    List<CategoryVO> cateList;
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
                i.putExtra("categoryId",cateList.get(arg2).getId());
                i.putExtra("hasFinished",cateList.get(arg2).getFinish() == 1 ? true : false);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        mLanguageId = intent.getIntExtra("languageId",1);
        APIService apiService = APIUtil.getAPIService();
        Call<ResponseVO> call = apiService.getQuizList(mLanguageId,MainActivity.USER_ID);
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
                        public JsonElement serialize(Double src, Type typeOfSrc,
                                                     JsonSerializationContext context) {
                            Integer value = (int)Math.round(src);
                            return new JsonPrimitive(value);
                        }
                    });
                    Gson gson = gsonBuilder.create();
                    String json = gson.toJson(response.body().getContent());
                    Log.i("***TEST***",json);
                    cateList = gson.fromJson(json, new TypeToken<List<CategoryVO>>() {}.getType());
                    Log.i("***TEST***",cateList.get(0).getFinish()==1 ? "true" : "false");
                    mquizList.setAdapter(new QuizAdapter(cateList,QuizListActivity.this));
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

    }

//    @Override
//    protected void onResume() {
//        List<CategoryVO> cat; // = getfromserver
//        Map quizs = new HashMap();
//        for (CategoryVO c : cateList){
//            String temp;
//            if(!c.isFinish()) temp = "completed*26";
//            else temp = "not completed*26";
//            quizs.put(c.getName(),temp);
//        }
//        Set<Map.Entry<String,String>> entrys = quizs.entrySet();
//        List<Map.Entry<String,String>> quizList = new ArrayList<>(entrys);
//        mquizList.setAdapter(new QuizAdapter(quizList,QuizListActivity.this));
//        super.onResume();
//    }

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
