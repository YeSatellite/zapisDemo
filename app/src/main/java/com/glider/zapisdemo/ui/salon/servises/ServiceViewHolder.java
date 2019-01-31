package com.glider.zapisdemo.ui.salon.servises;

import android.view.View;
import android.widget.TextView;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.model.Service;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ServiceViewHolder extends ChildViewHolder {
    private TextView name;
    private TextView price;

    public ServiceViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
    }

    public void bind(Service service){
        name.setText(service.getName());

        int minutes = service.getDuration();
        int h = minutes / 60;
        int m = minutes % 60;
        StringBuilder time = new StringBuilder();
        time.append(service.getPriceStr()).append(" ~ ");
        if (h>0) time.append(h).append(" ч. ");
        if (m>0) time.append(m).append(" мин. ");

        price.setText(time);
    }
}
