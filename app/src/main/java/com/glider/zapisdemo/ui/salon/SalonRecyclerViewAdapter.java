package com.glider.zapisdemo.ui.salon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.model.Salon;
import com.glider.zapisdemo.utility.Client;

import java.util.ArrayList;
import java.util.List;

public class SalonRecyclerViewAdapter extends RecyclerView.Adapter<SalonRecyclerViewAdapter.ViewHolder> {

    List<Salon> salons = new ArrayList<>();
    private SalonClickListener listener;

    public SalonRecyclerViewAdapter(SalonClickListener listener) {
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_salon, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Salon item = salons.get(position);

        holder.name.setText(item.getName());
        holder.type.setText(item.getType());
        Client.getInstance().setImage(holder.avatar,item.getPictureUrl(),R.drawable.place_holder);

        if (salons.size() == position+1){
            holder.line.setVisibility(View.GONE);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return salons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final TextView name;
        final TextView type;
        final ImageView avatar;
        final View line;

        ViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.name);
            type = v.findViewById(R.id.type);
            avatar = v.findViewById(R.id.avatar);
            line = v.findViewById(R.id.line);
        }
    }

    public interface SalonClickListener{
        void onClick(Salon salon);
    }
}
