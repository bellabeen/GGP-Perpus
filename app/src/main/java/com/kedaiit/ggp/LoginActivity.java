package com.kedaiit.ggp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kedaiit.ggp.api.ApiClient;
import com.kedaiit.ggp.api.ApiInterface;
import com.kedaiit.ggp.model.login.Login;
import com.kedaiit.ggp.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_Indeks, edt_KataSandi;
    Button btn_Login;
    String Indeks, KataSandi;
    TextView tvRegister;
    ApiInterface apiInterface;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_Indeks = findViewById(R.id.edt_indeks);
        edt_KataSandi = findViewById(R.id.edt_kataSandi);

        btn_Login = findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(this);

        tvRegister = findViewById(R.id.tvCreateAccount);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Indeks = edt_Indeks.getText().toString();
                KataSandi = edt_KataSandi.getText().toString();
                login(Indeks,KataSandi);
                break;
            case R.id.tvCreateAccount:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void login(String indeks, String kataSandi) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(indeks,kataSandi);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    // Ini untuk menyimpan sesi
                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);

                    //Ini untuk pindah
                    Toast.makeText(LoginActivity.this, response.body().getLoginData().getIndeks(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    EditText edt_Indeks, edt_KataSandi;
//    Button btn_login;
//    String indeks, kata_sandi;
//    TextView tvRegister;
//    ApiInterface apiInterface;
//    SessionManager sessionManager;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        edt_Indeks = findViewById(R.id.edt_indeks);
//        edt_KataSandi = findViewById(R.id.edt_kataSandi);
//
//        btn_login = findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(this);
//
//        tvRegister = findViewById(R.id.tvCreateAccount);
//        tvRegister.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_login:
//                indeks = edt_Indeks.getText().toString();
//                kata_sandi = edt_KataSandi.getText().toString();
//                login(indeks,kata_sandi);
//                break;
//            case R.id.tvCreateAccount:
//                Intent intent = new Intent(this, RegisterActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }
//
//    private void login(String indeks, String kata_sandi) {
//
//        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        Login login = new Login("indeks", "kata_sandi", "email", "hp", "tanggal_daftar", "foto", "status", "id_sesi", "last_login", "host" );
//
//        Call<Login> loginCall = apiInterface.loginResponse(login);
//
//        loginCall.enqueue(new Callback<Login>() {
//            @Override
//            public void onResponse(Call<Login> call, Response<Login> response) {
//                if(response.body() == null && response.isSuccessful() && response.body().isStatus()){
//
//                    // Ini untuk menyimpan sesi
//                    sessionManager = new SessionManager(LoginActivity.this);
//                    LoginData loginData = response.body().getLoginData();
//                    sessionManager.createLoginSession(loginData);
//
//                    //Ini untuk pindah
//                    Toast.makeText(LoginActivity.this, response.body().getLoginData().getIndeks(), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Login> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}