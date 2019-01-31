package com.glider.zapisdemo.ui.salon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.utility.Client;

import java.util.List;

public class SlidingAdapter extends PagerAdapter {


    private List<String> images;
    private LayoutInflater inflater;


    public SlidingAdapter(Context context, List<String> images) {
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = inflater.inflate(R.layout.item_slider, container, false);

        ImageView imageView = v.findViewById(R.id.image);
        Client.getInstance().setImage(imageView,images.get(position),R.drawable.place_holder);
        container.addView(v);

        return v;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}