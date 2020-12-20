package com.example.covid_19.api;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.utilities.Totals;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    ApiInterface apiInterface;
  String  TAG="retrofit";
   public ApiProvider() {
        Log.i(TAG, "ApiProvider -- cons() ");
        // logs request and response information.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-19-data.p.rapidapi.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }
   public MutableLiveData<ArrayList<CountriesDetails>> getAllCountries(String host,String key,String format){
         final MutableLiveData<ArrayList<CountriesDetails>> countriesList=new MutableLiveData<>();
       Call<ArrayList<CountriesDetails>> getAllCountriesCall=apiInterface.getAllCountries(
               host,key,format);

   getAllCountriesCall.enqueue(new Callback<ArrayList<CountriesDetails>>() {
       @Override
       public void onResponse(Call<ArrayList<CountriesDetails>> call, Response<ArrayList<CountriesDetails>> response) {
           Log.i(TAG, "ApiProvider -- signUp() enqueue()  body >> " +
                   response.body());
         countriesList.setValue(response.body());
       }

       @Override
       public void onFailure(Call<ArrayList<CountriesDetails>> call, Throwable t) {

           Log.i("call",t.getMessage());

       }
   });
   return countriesList;


    }

    MutableLiveData<ArrayList<Totals>> getTotals(String host,String key,String format){

        final MutableLiveData<ArrayList<Totals>> totalsMutableLiveData=new MutableLiveData<>();
       Call<ArrayList<Totals>> getTotalsCall =apiInterface.getTotals(host, key, format);
       getTotalsCall.enqueue(new Callback<ArrayList<Totals>>() {
           @Override
           public void onResponse(Call<ArrayList<Totals>> call, Response<ArrayList<Totals>> response) {

               totalsMutableLiveData.setValue(response.body());
           }

           @Override
           public void onFailure(Call<ArrayList<Totals>> call, Throwable t) {
               Log.i("call",t.getMessage());

           }
       });
       return  totalsMutableLiveData;
    }
}
