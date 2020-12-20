package com.example.covid_19.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_19.utilities.CountriesDetails;
import com.example.covid_19.R;


import java.util.ArrayList;

public class HomeRecyclarViewAdapter extends RecyclerView.Adapter<HomeRecyclarViewAdapter.MyViewHolder> {


    ArrayList<CountriesDetails> countriesDetailsArrayList = new ArrayList<>();
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public HomeRecyclarViewAdapter(ArrayList<CountriesDetails> countriesDetailsArrayList, Context context) {

        this.countriesDetailsArrayList = countriesDetailsArrayList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HomeRecyclarViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.country_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.confirmed.setText(String.valueOf(countriesDetailsArrayList.get(position).getConfirmed()));
        holder.recovered.setText(String.valueOf(countriesDetailsArrayList.get(position).getRecovered()));
        Glide.with(context).load("https://www.countryflags.io/"+countriesDetailsArrayList.get(position).getCode()+"/shiny/64.png").into(holder.countryImage);



//           holder.groupCardView.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   Intent goToGroup = new Intent(context, GroupViewPager.class);
//                   goToGroup.putExtra("group",userGroups.get(position));
//                   context.startActivity(goToGroup);
//               }
//           });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return countriesDetailsArrayList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView confirmed;
        public TextView recovered;
        public ImageView countryImage;
       // public FrameLayout groupCardView;
        public View layout;

        public MyViewHolder(View v) {
            super(v);
            layout = v;
            countryImage = v.findViewById(R.id.country_image);
            confirmed = v.findViewById(R.id.confirmed_tv);
            recovered = v.findViewById(R.id.recovered_tv);
           // groupCardView =v.findViewById(R.id.group_card);
        }
    }

}
