package advertisingspaceforrent.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.Question;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WrongListActivity extends AppCompatActivity {

    Button button4quit;

    private ListView lv;

    List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_list);

        button4quit = (Button) findViewById(R.id.topbar_leftText);
        button4quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        APIService apiService = APIUtil.getAPIService();
        Call<ResponseVO> call = apiService.getRecordByUserId(getIntent().getIntExtra("userId",0));
        call.enqueue(new Callback<ResponseVO>() {
            @Override
            public void onResponse(Call<ResponseVO> call, Response<ResponseVO> response) {
                if (response.body().getSuccess()) {
                    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                    String json = gson.toJson(response.body().getContent());
                    questions = gson.fromJson(json,new TypeToken<List<Question>>(){}.getType());
//                    Log.i("***TEST***",questions.get(0).getContext());
                    Log.i("wrong context",questions.get(0).getContext());
                    lv = (ListView) findViewById(R.id.lv_wrong);//得到ListView对象的引用
                    /*为ListView设置Adapter来绑定数据*/
                    lv.setAdapter(new WrongAdapter(WrongListActivity.this,questions));

                } else {
                    ToastUtil.showToast(WrongListActivity.this,response.body().getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(WrongListActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });

    }
}
