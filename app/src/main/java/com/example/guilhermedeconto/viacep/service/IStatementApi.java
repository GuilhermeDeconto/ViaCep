package com.example.guilhermedeconto.viacep.service;

import com.example.guilhermedeconto.viacep.model.Detail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public interface IStatementApi {
    // {cep} passa uma variável por parâmetro, no caso o cep que o usuário digitar
    @GET("{cep}/json/")
    Call<Detail> getCep(@Path("cep") String cep);

}

