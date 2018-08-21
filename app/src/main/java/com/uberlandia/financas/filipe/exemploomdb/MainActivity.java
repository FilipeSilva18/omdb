package com.uberlandia.financas.filipe.exemploomdb;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ArrayAdapter<Filme> adapter;
    private RecyclerView listMovies;
    private RecyclerViewAdapter mMovieAdapter;

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

        listMovies = (RecyclerView) findViewById(R.id.list_movies);
        adapter = new ArrayAdapter<Filme>(this, android.R.layout.simple_list_item_1);
        listMovies.setAdapter(adapter);

        final EditText filme = findViewById(R.id.edt_nome);
        filme.setText("Batman");

        Button btnBuscarCep = findViewById(R.id.btn_buscar_filme);
        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.clear();

                Call<Result> call = new RetrofitConfig().getFilmeService().buscarFilme(filme.getText().toString(), "45023bb7");
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        Result f = response.body();
                        if(f.getResponse()) adapter.addAll(f.getSearch());
                        else adapter.add(new Filme(filme.getText().toString(), "", "", "", ""));
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        Log.e("FilmeService   ", "Erro ao buscar o filme:" + t.getMessage());
                    }
                });
            }
        });
    }

}
