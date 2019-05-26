package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

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
    }

    @Override
    protected void onResume() {
        Map quizs = new HashMap();
        quizs.put("Usage of string","completed");
        quizs.put("Object oriented", "not completed");
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
