package com.example.covid_19.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.covid_19.CountriesViewmodel.CountriesViewModel;
import com.example.covid_19.utilities.HelperClass;
import com.example.covid_19.R;
import com.example.covid_19.utilities.Totals;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private CountriesViewModel countriesViewModel;
   // PieChart pieChart;
   BarChart chart;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
      //pieChart = root.findViewById(R.id.pie_chart);
         chart = root.findViewById(R.id.bar_chart);

        countriesViewModel= ViewModelProviders.of(this).get(CountriesViewModel.class);

        countriesViewModel.getTotals(HelperClass.host,HelperClass.key,"json").observe(getViewLifecycleOwner(), new Observer<ArrayList<Totals>>() {
            @Override
            public void onChanged(ArrayList<Totals> totals) {
                ArrayList<BarEntry> detail = new ArrayList<>();

                detail.add(new BarEntry(totals.get(0).getConfirmed(), 0));
                detail.add(new BarEntry(totals.get(0).getCritical(), 1));
                detail.add(new BarEntry(totals.get(0).getDeaths(), 2));
                detail.add(new BarEntry(totals.get(0).getRecovered(), 3));
               // PieDataSet dataSet = new PieDataSet(detail,"Corona Numbers");

                ArrayList<String> year = new ArrayList<String>();

                year.add("Confirmed");
                year.add("Critical");
                year.add("death");
                year.add("Recovered");
                BarDataSet bardataset = new BarDataSet(detail, "Corona Numbers");
                chart.animateY(5000);
                BarData data = new BarData(year, bardataset);
                 int[] colors = {
                         Color.rgb(0, 0, 0),
                     Color.rgb(243, 235, 7), Color.rgb(203, 24, 24),
                         Color.rgb(14, 255, 42)
                };
                bardataset.setColors(ColorTemplate.createColors(colors));

                chart.setDrawBarShadow(true);

                data.setValueTextSize(20f);




                chart.setData(data);
//                PieData data = new PieData(year, dataSet);
//                pieChart.setData(data);
//                pieChart.getCenterText();
//                pieChart.setCenterText("Corona Numbers");
//                pieChart.setCenterTextColor(R.color.black);
//                pieChart.setCenterTextSizePixels(50);
//                pieChart.setDrawSliceText(true);
//                pieChart.setDescriptionTextSize(122);
//                pieChart.setDrawCenterText(true);
//                pieChart.setActivated(true);
//                pieChart.
//                dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
//
//                pieChart.animateXY(5000, 5000);



            }
        });


        return root;
    }
}
