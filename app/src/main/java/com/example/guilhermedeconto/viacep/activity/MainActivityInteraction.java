package com.example.guilhermedeconto.viacep.activity;

import com.example.guilhermedeconto.viacep.model.Detail;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public interface MainActivityInteraction {

    void onSuccess(Detail detail);

    void onError(String error);

}

