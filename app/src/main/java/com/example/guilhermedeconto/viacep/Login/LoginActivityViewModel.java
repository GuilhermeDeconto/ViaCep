package com.example.guilhermedeconto.viacep.Login;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 21/12/2018
 **/
class LoginActivityViewModel {
    private LoginActivityInteraction interaction;

    public LoginActivityViewModel(LoginActivityInteraction interaction) {
        this.interaction = interaction;
    }

    public void doLogin(String name, String password) {
        if (!name.isEmpty() && !password.isEmpty() && name.equals(password))
            interaction.login();
        else interaction.onError("Campos inválidos, tente novamente");
    }
}
