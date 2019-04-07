package com.kristiyan.weatheroid.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kristiyan.weatheroid.R;
import com.kristiyan.weatheroid.databinding.RecyclerItemBinding;
import com.kristiyan.weatheroid.model.location.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private final List<Location> locationList = new ArrayList<>();
    private RecyclerItemBinding binding;

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder viewHolder, int i) {
        viewHolder.binding.setLocation(locationList.get(i));
    }

    public void setLocationList(List<Location> locationList){
        this.locationList.clear();
        this.locationList.addAll(locationList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerItemBinding binding;

        public ViewHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
