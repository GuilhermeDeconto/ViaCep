package com.example.guilhermedeconto.viacep.activity;

import com.example.guilhermedeconto.viacep.model.Detail;
import com.example.guilhermedeconto.viacep.model.Numbers;
import com.example.guilhermedeconto.viacep.model.ResponseWrapper;
import com.example.guilhermedeconto.viacep.service.StatementService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel {
    private MainActivityInteraction interaction;

    public MainActivityViewModel(MainActivityInteraction interaction) {
        this.interaction = interaction;
    }

    public void getSum(int num1, int num2) {
        Numbers num3 = new Numbers(num1, num2);

        StatementService kotlin2 = new StatementService();
        kotlin2.getSum(num3, new Callback<ResponseWrapper<Integer>>() {
            @Override
            public void onResponse(Call<ResponseWrapper<Integer>> call, Response<ResponseWrapper<Integer>> response) {
                if (response.body() == null)
                    interaction.onError(response.message());
                else {
                    if (response.body().isSuccess())
                        interaction.onSucesso(response.body().getData());
                    else
                        interaction.onError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseWrapper<Integer>> call, Throwable t) {
                interaction.onError(t.getMessage());
            }
        });

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
