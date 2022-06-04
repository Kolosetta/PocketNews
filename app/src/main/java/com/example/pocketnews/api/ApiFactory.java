package com.example.pocketnews.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiFactory {
    private static ApiFactory apiFactory;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://lenta.ru/";


    private ApiFactory(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }


    public static ApiFactory getInstance(){
        if(apiFactory == null){
            apiFactory = new ApiFactory();
        }
        return apiFactory;
    }

    //Ретрофит сам реализует этот интерфейс
    public LentaRuApiService getApiService(){
        return retrofit.create(LentaRuApiService.class);
    }
}
