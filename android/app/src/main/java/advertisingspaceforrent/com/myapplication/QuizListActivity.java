package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuizListActivity extends AppCompatActivity {

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
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        List<Category> cat; // = getfromserver
        Intent intent = getIntent();
        Integer languageId = intent.getIntExtra("languageId",1);
        Toast.makeText(QuizListActivity.this,"lan ID" + Integer.toString(languageId),Toast.LENGTH_SHORT).show();
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
