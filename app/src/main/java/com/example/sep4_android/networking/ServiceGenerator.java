package com.example.sep4_android.networking;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .client(new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).build())
            .baseUrl("http://sep4datagroup2-env.eba-mctqt7mi.us-east-2.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static PlantApi plantApi = retrofit.create(PlantApi.class);
    private static GardenApi gardenApi = retrofit.create(GardenApi.class);

    public static PlantApi getPlantApi() {
        return plantApi;
    }

    public static GardenApi getGardenApi() {
        return gardenApi;
    }
}
