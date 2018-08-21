package com.uberlandia.financas.filipe.exemploomdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Filipe on 20/08/2018.
 */

@JsonIgnoreProperties({"Search/","totalResults", "Response"})
public class Filme {

    private String Search;
    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;

    public Filme() {}

    public Filme(String title, String year, String imdbID, String type, String poster, String search) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Type = type;
        Poster = poster;
        Search = search;
    }

    public String getTitle() {
        return Title;
    }

    public void setSearch(String search) {
        Search = search;
    }

    public String getSearch() {
        return Search;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                "Search" + Search+
                '}';
    }
}
