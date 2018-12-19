package com.example.guilhermedeconto.viacep.activity;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guilhermedeconto.viacep.R;
import com.example.guilhermedeconto.viacep.model.Detail;

public class MainActivity extends AppCompatActivity implements MainActivityInteraction {
    private TextView tvDetail;
    private Button btnSearch;
    private EditText etCep;
    private  EditText etNum2;
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new MainActivityViewModel(this);

       // tvDetail = findViewById(R.id.tvDetail);
        btnSearch = findViewById(R.id.button);
        etCep = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnSearch.setOnClickListener(v -> {
            viewModel.getSum(Integer.parseInt(etCep.getText().toString()),Integer.parseInt(etNum2.getText().toString()));

        });

    }

    @Override
    public void onSuccess(Detail detail) {
        tvDetail.setText(detail.toString());
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSucesso(Integer data) {
        Toast.makeText(this, String.valueOf(data), Toast.LENGTH_SHORT).show();
    }
}
