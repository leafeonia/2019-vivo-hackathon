package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result = findViewById(R.id.tv_result);
        tv_addMoney = findViewById(R.id.tv_addMoney);
        tv_addPuzzle = findViewById(R.id.tv_addPuzzle);
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
            APIService apiService = APIUtil.getAPIService();
            Map<String,String> map = new LinkedHashMap<>();
            Integer one = 1;
            Integer userid = MainActivity.USER_ID;
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

            call = apiService.updatePuzzle(userid);
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

        }
    }
}
