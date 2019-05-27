package advertisingspaceforrent.com.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.Question;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import advertisingspaceforrent.com.myapplication.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayingActivity extends AppCompatActivity {

    private Topbar topBar;
    Button buttona;
    Button buttonb;
    Button buttonc;
    Button buttond;
    TextView quesionContext;
    TextView topBarTitle;

    int categoryId;
    boolean hasFinished;
    List<Question> questions;
    int flag;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        buttona = (Button) findViewById(R.id.ButtonA);
        buttonb = (Button) findViewById(R.id.ButtonB);
        buttonc = (Button) findViewById(R.id.ButtonC);
        buttond = (Button) findViewById(R.id.ButtonD);
        quesionContext = findViewById(R.id.textView2);
        topBarTitle = findViewById(R.id.topbar_title);
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge(1);
            }
        });
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge(2);
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge(3);
            }
        });
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge(4);
            }
        });
        topBar = (Topbar) findViewById(R.id.topbar);

        categoryId = getIntent().getIntExtra("categoryId",0);
        hasFinished = getIntent().getBooleanExtra("hasFinished",false);

        APIService apiService = APIUtil.getAPIService();
        Call<ResponseVO> call = apiService.getQuestion(getIntent().getIntExtra("categoryId",0));
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                    String json = gson.toJson(response.body().getContent());
                    questions = gson.fromJson(json,new TypeToken<List<Question>>(){}.getType());
                    Log.i("***TEST***",questions.get(0).getContext());
                    flag = 0;
                    renderQuestion();
                } else {
                    ToastUtil.showToast(PlayingActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(PlayingActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });

    }

    private void showRightDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder rightDialog = new AlertDialog.Builder(PlayingActivity.this);
        rightDialog.setIcon(R.drawable.check);
        rightDialog.setTitle("恭喜你！");
        rightDialog.setMessage("你做对了！");
        rightDialog.setPositiveButton("Next",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toNextQuestion();
                    }
                });
        rightDialog.setNegativeButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do

                    }
                });
        // 显示
        rightDialog.show();
    }

    private void showWrongDialog() {
        APIService apiService = APIUtil.getAPIService();
        Map<String,String> map = new LinkedHashMap<>();
        map.put("userId",MainActivity.USER_ID.toString());
        map.put("questionId",""+questions.get(flag).getId());
        Call<ResponseVO> call = apiService.addRecord(map);
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    ToastUtil.showToast(PlayingActivity.this,"已自动添加到错题集",Toast.LENGTH_SHORT);
                } else {
                    ToastUtil.showToast(PlayingActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(PlayingActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });

        final AlertDialog.Builder wrongDialog = new AlertDialog.Builder(PlayingActivity.this);
        wrongDialog.setCancelable(false);
        wrongDialog.setIcon(R.drawable.wrong);
        wrongDialog.setTitle("很遗憾～");
        wrongDialog.setMessage(getRightAnwser(questions.get(flag).getCorrect()));
        wrongDialog.setPositiveButton("Next",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toNextQuestion();
                    }
                });

        wrongDialog.show();
    }

    private void renderQuestion() {
        Question defaultQ = questions.get(this.flag);
        quesionContext.setText(defaultQ.getContext());
        buttona.setText(defaultQ.getChoiceA());
        buttonb.setText(defaultQ.getChoiceB());
        buttonc.setText(defaultQ.getChoiceC());
        buttond.setText(defaultQ.getChoiceD());
        topBarTitle.setText((flag+1)+"/"+questions.size());
    }

    private void judge(int pos) {
        if (pos == questions.get(flag).getCorrect()) {
            score++;
            showRightDialog();
        } else {
            showWrongDialog();
        }
    }

    private void toNextQuestion() {
        if (flag == questions.size()-1) {
            boolean finish = false;
            if (score == questions.size()) {
                finish = true;
            }
            Intent intent = new Intent(PlayingActivity.this,ResultActivity.class);
            intent.putExtra("finish",finish);
            intent.putExtra("categoryId",categoryId);
            intent.putExtra("hasFinished",hasFinished);
            startActivity(intent);
        } else {
            flag++;
            renderQuestion();
        }
    }

    private String getRightAnwser(int pos){
        String rightanwser = "";
        if (pos == 1){
            rightanwser+="正确答案是A:"+questions.get(this.flag).getChoiceA();
        } else if (pos == 2){
            rightanwser+="正确答案是B:"+questions.get(this.flag).getChoiceB();
        } else if (pos == 3){
            rightanwser+="正确答案是C:"+questions.get(this.flag).getChoiceC();
        } else if (pos == 4){
            rightanwser+="正确答案是D:"+questions.get(this.flag).getChoiceD();
        }

        return rightanwser;
    }
}
