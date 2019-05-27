package advertisingspaceforrent.com.myapplication.util;

import java.util.Map;

import advertisingspaceforrent.com.myapplication.APIService;
import advertisingspaceforrent.com.myapplication.vo.ResponseVO;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUtil {

    public static APIService getAPIService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://94.191.110.118:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
