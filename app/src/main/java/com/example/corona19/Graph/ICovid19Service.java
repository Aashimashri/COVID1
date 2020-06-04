package com.example.corona19.Graph;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ICovid19Service {
    @GET("v1/country/IND")
    Call<ResponseBody> getHistoryDataForIndia();
}
