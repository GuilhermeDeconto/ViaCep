package com.example.guilhermedeconto.viacep.service;

import com.example.guilhermedeconto.viacep.model.Detail;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public class StatementService {
    private IStatementApi api;
    private final String baseUrl = "https://viacep.com.br/ws/";

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
     *
     * @param cep      cep pesquisado
     * @param callback oq ele deve fazer depois de receber informacao do servidor
     */
    public void getCep(String cep, Callback<Detail> callback) {
        api.getCep(cep).enqueue(callback);
    }
}
