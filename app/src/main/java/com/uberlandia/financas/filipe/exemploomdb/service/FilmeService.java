package com.uberlandia.financas.filipe.exemploomdb.service;

import com.uberlandia.financas.filipe.exemploomdb.Filme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Filipe on 20/08/2018.
 */

public interface FilmeService {
    @GET("?")
    Call<Filme> buscarFilme(@Query("s") String filme, @Query("apikey") String apikey);

}
