package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button button4signup;
    Button button4signin;
    EditText usnInput;
    EditText pwdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        button4signup = (Button)findViewById(R.id.signUp);
        button4signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainSignUpActivity.class);
                startActivity(i);
            }
        });

        button4signin = (Button)findViewById(R.id.logIn);
        button4signin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String usn = usnInput.getText().toString();
                String pwd = pwdInput.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://94.191.110.118:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                APIService apiService = retrofit.create(APIService.class);
                Map<String,String> map = new HashMap<>();
                map.put("username",usn);
                map.put("password",pwd);
                LoginForm loginForm = new LoginForm();
                loginForm.setUsername(usn);
                loginForm.setPassword(pwd);
                Call<ResponseVO> call = apiService.login(loginForm);
                call.enqueue(new Callback<ResponseVO>() {
                    @Override
                    public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                        if (response.body().getSuccess()) {
                            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                            String json = gson.toJson(response.body().getObj());
                            User user = gson.fromJson(json,User.class);
                            Toast.makeText(MainActivity.this,user.getUsername()+":"+user.getPassword(),Toast.LENGTH_LONG).show();
                        } else {
                            System.out.println(response.body().getMsg());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseVO> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"失败!",Toast.LENGTH_LONG).show();
                    }
                });
                Intent i = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
