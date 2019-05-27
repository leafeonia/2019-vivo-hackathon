package advertisingspaceforrent.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import advertisingspaceforrent.com.myapplication.util.APIUtil;
import advertisingspaceforrent.com.myapplication.util.ToastUtil;
import advertisingspaceforrent.com.myapplication.vo.CategoryVO;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import advertisingspaceforrent.com.myapplication.vo.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class PuzzleActivity extends AppCompatActivity {

    private static class IntegerWrapped{
        Integer integer;

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }
    }
    private List<IntegerWrapped> puzzleList = new ArrayList<>();
    private List<Integer> intPuzzleList = new ArrayList<>();
    ImageView p1,p2,p3,p4,p5,p6,p7,p8,p9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        APIService apiService = APIUtil.getAPIService();
        Call<ResponseVO> call = apiService.getPuzzle(MainActivity.USER_ID);
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
                    /*json = json.substring(1,json.length()-1);
                    String[] tempList = json.split(",");
                    for (String s: tempList){
                        Log.i("string",s);
                        Double d = Double.valueOf(s);
                        Integer i = new Integer(d.intValue());
                        puzzleList.add(i);
                        Log.i("Int",i.toString());
                    }*/
                    puzzleList = gson.fromJson(json, new TypeToken<List<IntegerWrapped>>() {}.getType());
                    for (IntegerWrapped integerWrapped: puzzleList){
                        Integer i = integerWrapped.getInteger();
                        intPuzzleList.add(i);
                    }
//                    Log.i("value",puzzleList.get(0).getInteger().toString());
//                    Log.i("*******puzzle******",json);
                    p1 = findViewById(R.id.puzzle1);
                    p2 = findViewById(R.id.puzzle2);
                    p3 = findViewById(R.id.puzzle3);
                    p4 = findViewById(R.id.puzzle4);
                    p5 = findViewById(R.id.puzzle5);
                    p6 = findViewById(R.id.puzzle6);
                    p7 = findViewById(R.id.puzzle7);
                    p8 = findViewById(R.id.puzzle8);
                    p9 = findViewById(R.id.puzzle9);
                    if (intPuzzleList.indexOf(1) != -1){
                        p1.setImageResource(R.drawable.award_0);
                    }
                    if (intPuzzleList.indexOf(2) != -1){
                        p2.setImageResource(R.drawable.award_1);
                    }
                    if (intPuzzleList.indexOf(3) != -1){
                        p3.setImageResource(R.drawable.award_2);
                    }
                    if (intPuzzleList.indexOf(4) != -1){
                        p4.setImageResource(R.drawable.award_3);
                    }
                    if (intPuzzleList.indexOf(5) != -1){
                        p5.setImageResource(R.drawable.award_4);
                    }
                    if (intPuzzleList.indexOf(6) != -1){
                        p6.setImageResource(R.drawable.award_5);
                    }
                    if (intPuzzleList.indexOf(7) != -1){
                        p7.setImageResource(R.drawable.award_6);
                    }
                    if (intPuzzleList.indexOf(8) != -1){
                        p8.setImageResource(R.drawable.award_7);
                    }
                    if (intPuzzleList.indexOf(9) != -1){
                        p9.setImageResource(R.drawable.award_8);
                    }
                } else {
                    ToastUtil.showToast(PuzzleActivity.this,response.body().getMessage(), LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ResponseVO> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast(PuzzleActivity.this,"失败!",Toast.LENGTH_LONG);
            }
        });
//        puzzleList.add(5);
//        puzzleList.add(1);
//        puzzleList.add(7);

    }
}
