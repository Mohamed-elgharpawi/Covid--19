package com.example.covid_19.CountriesViewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.utilities.Totals;
import com.example.covid_19.api.CountriesRepository;

import java.util.ArrayList;

public class CountriesViewModel extends ViewModel {
    private CountriesRepository countriesRepository=new CountriesRepository();
    public MutableLiveData<ArrayList<CountriesDetails>> getAllCountries(String host,String key,String format){
    return  countriesRepository.getAllCountries(host, key,format);

    }

    public  MutableLiveData<ArrayList<Totals>> getTotals(String host, String key, String format){

        return countriesRepository.getTotals(host, key, format);

    }
}
