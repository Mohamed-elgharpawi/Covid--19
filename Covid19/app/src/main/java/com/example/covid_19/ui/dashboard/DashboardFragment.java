package com.example.covid_19.ui.dashboard;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.covid_19.Adapter.HomeRecyclarViewAdapter;
import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.CountriesViewmodel.CountriesViewModel;
import com.example.covid_19.utilities.HelperClass;
import com.example.covid_19.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class DashboardFragment extends Fragment {
    private CountriesViewModel countriesViewModel;
    RecyclerView countriesRecyclerView;
    HomeRecyclarViewAdapter adapter;
    ArrayList<CountriesDetails> countriesDetailsList;
    EditText search;
    ShimmerFrameLayout shimmer;
    ArrayList<CountriesDetails> tempList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel= ViewModelProviders.of(this).get(CountriesViewModel.class);
        countriesDetailsList=new ArrayList<CountriesDetails>();

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        countriesRecyclerView=root.findViewById(R.id.countries_recycler);
        search=root.findViewById(R.id.search);

        shimmer=root.findViewById(R.id.shimmer);
        tempList=new ArrayList<>();
        //searchBtn=root.findViewById(R.id.btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(countriesRecyclerView.VERTICAL);
        countriesRecyclerView.setLayoutManager(layoutManager);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Stream<CountriesDetails> countriesDetailsStream = countriesDetailsList.stream()
                        .filter(countriesDetail -> countriesDetail.getCountry()
                                .contains(s.toString().trim()));

                tempList= (ArrayList<CountriesDetails>) countriesDetailsStream.collect(Collectors.toList());
                adapter= new HomeRecyclarViewAdapter(tempList, getContext());
                adapter.notifyDataSetChanged();
                countriesRecyclerView.setAdapter(adapter);


            }


            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().equalsIgnoreCase("")){
                    getData();


                }
                else {




                }
                }


        });


        getData();

        return root;
    }

    private void getData(){

        countriesViewModel.getAllCountries(HelperClass.host,HelperClass.key,"undefined").observe(getViewLifecycleOwner(), new Observer<ArrayList<CountriesDetails>>() {
            @Override
            public void onChanged(ArrayList<CountriesDetails> countriesDetails) {
                countriesDetailsList=countriesDetails;
                tempList=countriesDetails;
                Collections.sort(countriesDetailsList);
                adapter= new HomeRecyclarViewAdapter(countriesDetailsList, getContext());
                countriesRecyclerView.setAdapter(adapter);
                shimmer.setVisibility(View.GONE);
                shimmer.stopShimmer();


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        shimmer.setVisibility(View.VISIBLE);
        shimmer.startShimmer();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}
