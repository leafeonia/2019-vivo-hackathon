package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class MainSignUpActivity extends AppCompatActivity {

    Button buttonbacktosignin;
    EditText usnInput;
    EditText pwdInput;
    EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        usnInput = findViewById(R.id.name);
        pwdInput = findViewById(R.id.password);
        emailInput = findViewById(R.id.email);
        buttonbacktosignin = (Button)findViewById(R.id.signUp);
        buttonbacktosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = usnInput.getText().toString();
                String pwd = pwdInput.getText().toString();
                String email = emailInput.getText().toString();
                APIService apiService = APIUtil.getAPIService();
                Map<String,String> map = new LinkedHashMap<>();
                map.put("username",usn);
                map.put("password",pwd);
                map.put("email",email);
                Call<ResponseVO> call = apiService.signUp(map);
                call.enqueue(new Callback<ResponseVO>() {
                    @Override
                    public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                        if (response.body().getSuccess()) {
                            Toast.makeText(MainSignUpActivity.this,"注册成功!",Toast.LENGTH_SHORT);
                            Intent i = new Intent(MainSignUpActivity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            ToastUtil.showToast(MainSignUpActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseVO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(MainSignUpActivity.this,"失败!",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    //Used to show the help by triggering a toast
    public void showHelp(View view) {

        Toast toast_help = new Toast(getApplicationContext());
        toast_help.setGravity(Gravity.CENTER, 0, 0);
        toast_help.setDuration(Toast.LENGTH_LONG);
        LayoutInflater inflater = getLayoutInflater();
        //View appear = inflater.inflate(R.layout.toast_help, (ViewGroup) findViewById(R.id.linear));
        //toast_help.setView(appear);
        toast_help.show();

    }
}
