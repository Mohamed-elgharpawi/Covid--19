package com.example.covid_19.api;

import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.utilities.Totals;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("country/all")
    Call<ArrayList<CountriesDetails>> getAllCountries(
            @Header("x-rapidapi-host") String host,
            @Header("x-rapidapi-key") String key,
            @Query("format") String format

    );


    @GET("totals")
    Call<ArrayList<Totals>> getTotals(
            @Header("x-rapidapi-host") String host,
            @Header("x-rapidapi-key") String key,
            @Query("format") String format

    );
}
