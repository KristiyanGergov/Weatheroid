package com.kristiyan.weatheroid;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kristiyan.weatheroid.adapter.LocationAdapter;
import com.kristiyan.weatheroid.databinding.FragmentMainBinding;

import com.kristiyan.weatheroid.model.location.LocationGetResult;
import com.kristiyan.weatheroid.viewmodel.LocationViewModel;

public class MainFragment extends Fragment {

    LocationViewModel locationViewModel;

    private FragmentMainBinding binding;
    private LocationAdapter adapter;

    public static Fragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);

        adapter = new LocationAdapter();
        binding.recyclerView.setAdapter(adapter);

        locationViewModel.getLocationLiveData().observe(this, new Observer<LocationGetResult>() {
            @Override
            public void onChanged(@Nullable LocationGetResult locationGetResult) {
                if (locationGetResult.success()) {
                    adapter.setLocationList(locationGetResult.getLocations());
                }
            }
        });

        binding.getLocationsOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationViewModel.getLocationsOnline();
            }
        });

        binding.getLocationsLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationViewModel.getLocationsLocal();
            }
        });
    }
}