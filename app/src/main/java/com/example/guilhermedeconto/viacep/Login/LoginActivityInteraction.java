package com.example.guilhermedeconto.viacep.Login;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 21/12/2018
 **/
interface LoginActivityInteraction {
    void login();

    void onError(String error);
}
