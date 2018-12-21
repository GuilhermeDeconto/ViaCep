package com.example.guilhermedeconto.viacep.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guilhermedeconto.viacep.R;
import com.example.guilhermedeconto.viacep.activity.MainActivity;

/**
 * @author Guilherme Dall'Agnol Deconto
 * @author guilherme.deconto@operacao.rcadigital.com.br
 * @since 14/12/2018
 */
public class LoginActivity extends AppCompatActivity implements LoginActivityInteraction {
    private Button btnButton;
    private View vHeader;
    private TextView tvLogin;
    private TextView tvfacalogin;
    private EditText etEmail;
    private EditText etPassword;
    private View vdivider;
    private ImageView icoded;

    private LoginActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        viewModel = new LoginActivityViewModel(this);
        //cria a funçao do botao login e redireciona o usuario para a proxima tela
        btnButton = findViewById(R.id.btnButton);
        vHeader = findViewById(R.id.vHeader);
        tvLogin = findViewById(R.id.tvLogin);
        tvfacalogin = findViewById(R.id.tvfacalogin);
        vdivider = findViewById(R.id.vdivider);
        icoded = findViewById(R.id.ivIcoded);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnButton.setOnClickListener(v -> {
            viewModel.doLogin(etEmail.getText().toString(), etPassword.getText().toString());
        });
    }

    @Override
    public void login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT);
    }

}
