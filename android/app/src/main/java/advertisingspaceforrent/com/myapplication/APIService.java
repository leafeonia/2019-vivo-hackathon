package advertisingspaceforrent.com.myapplication;

import java.util.Map;

import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {

    @GET("account/login")
    Call<ResponseVO> login(@QueryMap Map<String,String> map);
}
