package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import advertisingspaceforrent.com.myapplication.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {
    private boolean allCorrect; //这次全对
    private boolean hasBeenCompleted; // 以前做完过
    TextView tv_result,tv_addMoney,tv_addPuzzle;
    Button button4Quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result = findViewById(R.id.tv_result);
        tv_addMoney = findViewById(R.id.tv_addMoney);
        tv_addPuzzle = findViewById(R.id.tv_addPuzzle);
        allCorrect = getIntent().getBooleanExtra("finish",false);
        hasBeenCompleted = getIntent().getBooleanExtra("hasFinished",false);
        button4Quit = (Button) findViewById(R.id.quitToList);
        button4Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, HomepageActivity.class));
            }
        });
        if (!allCorrect){
            tv_result.setText("Keep trying !");
            tv_result.setTextColor(android.graphics.Color.RED);
            tv_addPuzzle.setText("+0");
            tv_addMoney.setText("+0");
        }
        else if(hasBeenCompleted){
            tv_addPuzzle.setText("+0");
            tv_addMoney.setText("+0");
        }
        else{
            APIService apiService1 = APIUtil.getAPIService();
            Map<String,String> map1 = new LinkedHashMap<>();
            Integer userid = MainActivity.USER_ID;
            map1.put("userId",userid.toString());
            map1.put("categoryId",getIntent().getIntExtra("categoryId",1)+"");
            Call<ResponseVO> call1 = apiService1.finishcat(map1);
            call1.enqueue(new Callback<ResponseVO>() {
                @Override
                public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                    if (response.body().getSuccess()) {

                    } else {
                        ToastUtil.showToast(ResultActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                    }
                }

                @Override
                public void onFailure(Call<ResponseVO> call, Throwable t) {
                    t.printStackTrace();
                    ToastUtil.showToast(ResultActivity.this,"失败!",Toast.LENGTH_LONG);
                }
            });
            APIService apiService = APIUtil.getAPIService();
            Map<String,String> map = new LinkedHashMap<>();
            Integer one = 1;
            map.put("userid",userid.toString());
            map.put("money",one.toString());
            Call<ResponseVO> call = apiService.updateMoney(map);
            call.enqueue(new Callback<ResponseVO>() {
                @Override
                public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                    if (response.body().getSuccess()) {

                    } else {
                        ToastUtil.showToast(ResultActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                    }
                }

                @Override
                public void onFailure(Call<ResponseVO> call, Throwable t) {
                    t.printStackTrace();
                    ToastUtil.showToast(ResultActivity.this,"失败!",Toast.LENGTH_LONG);
                }
            });
            APIService apiService2 = APIUtil.getAPIService();
            Call<ResponseVO> call2 = apiService2.addPuzzle(userid);
            call2.enqueue(new Callback<ResponseVO>() {
                @Override
                public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                    if (response.body().getSuccess()) {
                        ToastUtil.showToast(ResultActivity.this,"获得了一张随机图鉴!",Toast.LENGTH_SHORT);
                    } else {
                        ToastUtil.showToast(ResultActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                    }
                }

                @Override
                public void onFailure(Call<ResponseVO> call, Throwable t) {
                    t.printStackTrace();
                    ToastUtil.showToast(ResultActivity.this,"失败!",Toast.LENGTH_LONG);
                }
            });
        }
    }
}
