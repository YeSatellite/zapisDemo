package com.glider.zapisdemo.ui.salon.servises;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.model.Category;
import com.glider.zapisdemo.model.Service;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ServiceAdapter extends ExpandableRecyclerViewAdapter<CategoryViewHolder, ServiceViewHolder> {
    public ServiceAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public CategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(v);
    }

    @Override
    public ServiceViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service,parent,false);
        return new ServiceViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ServiceViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Service service = (Service) group.getItems().get(childIndex);
        holder.bind(service);
    }

    @Override
    public void onBindGroupViewHolder(CategoryViewHolder holder, int flatPosition, ExpandableGroup group) {
        final CategoryGroup category = (CategoryGroup) group;
        holder.bind(category);
    }
}
