package com.example.guilhermedeconto.viacep.activity;

import com.example.guilhermedeconto.viacep.model.Detail;

public interface MainActivityInteraction {

    void onSuccess(Detail detail);

    void onError(String error);

    void onSucesso(Integer data);
}

