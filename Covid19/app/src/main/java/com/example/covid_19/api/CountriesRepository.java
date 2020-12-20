package com.example.covid_19.api;

import androidx.lifecycle.MutableLiveData;

import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.utilities.Totals;

import java.util.ArrayList;

public class CountriesRepository {
    private ApiProvider apiProvider;
   public CountriesRepository(){apiProvider=new ApiProvider();}



    public  MutableLiveData<ArrayList<CountriesDetails>> getAllCountries(String host,String key,String format){


        return  apiProvider.getAllCountries(host, key, format);

    }
  public   MutableLiveData<ArrayList<Totals>> getTotals(String host, String key, String format){

       return apiProvider.getTotals(host, key, format);
    }



}
