package com.uberlandia.financas.filipe.exemploomdb;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        final EditText filme = findViewById(R.id.edt_nome);
        filme.setText("Batman");
        final TextView resposta = findViewById(R.id.tv_resposta);
        Button btnBuscarCep = findViewById(R.id.btn_buscar_filme);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Filme> call = new RetrofitConfig().getFilmeService().buscarFilme(filme.getText().toString(), "45023bb7");
                call.enqueue(new Callback<Filme>() {
                    @Override
                    public void onResponse(Call<Filme> call, Response<Filme> response) {
                        Filme f = response.body();
                        System.out.println(call);
                        resposta.setText(f.toString());
                    }

                    @Override
                    public void onFailure(Call<Filme> call, Throwable t) {
                        Log.e("FilmeService   ", "Erro ao buscar o filme:" + t.getMessage());
                    }
                });
            }
        });
    }

}
