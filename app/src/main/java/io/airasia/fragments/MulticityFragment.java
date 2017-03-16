package io.airasia.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.airasia.R;
import io.airasia.adapters.TabPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MulticityFragment extends Fragment implements View.OnClickListener {

    TabLayout tabLayout;
    TabPagerAdapter adapter;
    ViewPager viewPager;
    ImageView timelineIcon;
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
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FlightFragment());
        fragments.add(new FlightFragment());
        fragments.add(new FlightFragment());
        List<String> titles = new ArrayList<>();
        titles.add("Flight");
        titles.add("Train");
        titles.add("Bus");
        setupViewPager(viewPager, fragments, titles);
        tabLayout.setupWithViewPager(viewPager);
        CardView timelineFab = (CardView) getView().findViewById(R.id.timeline_fab);
        timelineFab.setOnClickListener(this);
        timelineIcon = (ImageView) getView().findViewById(R.id.timeline_icon);
    }

    private void setupViewPager(ViewPager viewPager, List<Fragment> fragments, List<String> titles) {
        adapter = new TabPagerAdapter(getChildFragmentManager());
        // Add fragments as well as titles to be added as tabs
        for (int i = 0; i < fragments.size(); i++) {
            adapter.addFrag(fragments.get(i), titles.get(i));
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int index = view.getId();
        if (index == R.id.timeline_fab) {
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(new PriceFragment());
            fragments.add(new FlightFragment());
            fragments.add(new FlightFragment());
            List<String> titles = new ArrayList<>();
            titles.add("Price");
            titles.add("Duration");
            titles.add("Stop");
            setupViewPager(viewPager, fragments, titles);
            tabLayout.setupWithViewPager(viewPager);
            timelineIcon.setImageResource(R.drawable.ic_check);
        }
    }
}
