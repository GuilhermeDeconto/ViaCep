package com.example.guilhermedeconto.viacep.service;

import com.example.guilhermedeconto.viacep.model.Detail;
import com.example.guilhermedeconto.viacep.model.Numbers;
import com.example.guilhermedeconto.viacep.model.ResponseWrapper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StatementService {
    private IStatementApi api;
    private final String baseUrl = "http://172.18.100.244:8888/treinamento/";

    public StatementService() {
        // Faz o logcat
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                //converte o objeto em gson e vice versa
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //contem todas as rotas
        api = retrofit.create(IStatementApi.class);
    }

    /**
     * Pega o cep e pede a descrição dos parametros
     * @param cep cep pesquisado
     * @param callback oq ele deve fazer depois de receber informacao do servidor
     */
    public void getCep(String cep, Callback<Detail> callback){
        api.getCep(cep).enqueue(callback);
    }
    public void getSum(Numbers numbers, Callback<ResponseWrapper<Integer>> callback){
        api.getSum(numbers).enqueue(callback);
    }
}
