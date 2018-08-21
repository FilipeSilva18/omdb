package com.uberlandia.financas.filipe.exemploomdb;

import java.util.List;

/**
 * Created by Filipe on 21/08/2018.
 */

public class Result {
    public List<Filme> Search;
    public String totalResults;
    public Boolean Response;

    public List<Filme> getSearch() {
        return Search;
    }

    public void setSearch(List<Filme> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public Boolean getResponse() {
        return Response;
    }

    public void setResponse(Boolean response) {
        Response = response;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Search=" + Search +
                ", totalResults='" + totalResults + '\'' +
                ", Response='" + Response + '\'' +
                '}';
    }
}
