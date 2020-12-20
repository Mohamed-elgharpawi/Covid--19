package com.example.covid_19.ui.instructions;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid_19.CountriesViewmodel.CountriesViewModel;
import com.example.covid_19.R;
import com.example.covid_19.utilities.SliderAdapterExample;
import com.example.covid_19.utilities.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class InstructionsFragment extends Fragment {

    private CountriesViewModel countriesViewModel;
    private SliderView sliderView;
    ArrayList<SliderItem> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        countriesViewModel =
                ViewModelProviders.of(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        sliderView=root.findViewById(R.id.imageSlider);
        list=new ArrayList<>();
        list.add(new SliderItem("https://scx2.b-cdn.net/gfx/news/2020/vitamindlink.jpg","What to do ?"));
        list.add(new SliderItem("https://image.freepik.com/free-vector/stay-home-stay-safe-concept-poster-design_1017-24657.jpg","Stay Home "));
        list.add(new SliderItem("https://i.ytimg.com/vi/S_Bqdn_W0z8/maxresdefault.jpg","Wash your hands"));
        list.add(new SliderItem("https://eph.org/wp-content/uploads/2020/04/facemask-instructions-01.png","Wear a Mask"));
        list.add(new SliderItem("https://www.cdc.gov/coronavirus/2019-ncov/images/COVIDweb_avoidCloseContact_masks_rect-01.png","Social distances "));

        sliderView.setSliderAdapter(new SliderAdapterExample(getContext(),list));

        countriesViewModel= ViewModelProviders.of(this).get(CountriesViewModel.class);



        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.BLACK);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }
}
