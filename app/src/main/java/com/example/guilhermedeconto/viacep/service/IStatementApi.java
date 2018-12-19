package com.example.guilhermedeconto.viacep.service;

import com.example.guilhermedeconto.viacep.model.Detail;
import com.example.guilhermedeconto.viacep.model.Numbers;
import com.example.guilhermedeconto.viacep.model.ResponseWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IStatementApi {
    // {cep} passa uma variável por parâmetro, no caso o cep que o usuário digitar
    @GET("{cep}/json/")
    Call<Detail> getCep(@Path("cep") String cep);

    @POST("index.php")
    Call<ResponseWrapper<Integer>> getSum(@Body Numbers numbers);
}

