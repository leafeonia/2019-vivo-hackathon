package advertisingspaceforrent.com.myapplication;

import java.util.Map;

import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIService {

    @GET("user/login")
    Call<ResponseVO> login(@QueryMap Map<String,String> map);

    @GET("user/signup")
    Call<ResponseVO> signUp(@QueryMap Map<String,String> map);

    @GET("category/get")
    Call<ResponseVO> getQuizList(@QueryMap Map<String,String> map);

    @GET("user/updatemoney")
    Call<ResponseVO> updateMoney(@QueryMap Map<String,String> map);

    @GET("question/get")
    Call<ResponseVO> getQuestion(@Query("categoryId") Integer categoryId);
}
