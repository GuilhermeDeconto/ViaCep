package com.example.guilhermedeconto.viacep.activity;

import com.example.guilhermedeconto.viacep.model.Detail;
import com.example.guilhermedeconto.viacep.service.StatementService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public class MainActivityViewModel {
    private MainActivityInteraction interaction;

    public MainActivityViewModel(MainActivityInteraction interaction) {
        this.interaction = interaction;
    }


    public void initService(String cep) {

        StatementService kotlin = new StatementService();
        kotlin.getCep(cep, new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                if (response.isSuccessful() && response.body() != null)
                    interaction.onSuccess(response.body());
                else interaction.onError("cep inválido");
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {
                interaction.onError(t.getMessage());
            }
        });
    }


}
