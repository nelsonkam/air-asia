package io.airasia.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.airasia.R;
import io.airasia.adapters.TabPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MulticityFragment extends Fragment {

    TabLayout tabLayout;
    TabPagerAdapter adapter;
    ViewPager viewPager;

    public MulticityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multicity, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout = (TabLayout) getView().findViewById(R.id.tab_layout);
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new TabPagerAdapter(getChildFragmentManager());
        // Add fragments as well as titles to be added as tabs
        adapter.addFrag(new FlightFragment(), "Flight");
        adapter.addFrag(new FlightFragment(), "Train");
        adapter.addFrag(new FlightFragment(), "Bus");
        viewPager.setAdapter(adapter);
    }
}
