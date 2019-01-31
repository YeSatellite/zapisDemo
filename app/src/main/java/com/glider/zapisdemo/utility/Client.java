package com.glider.zapisdemo.utility;

import android.support.annotation.DrawableRes;
import android.util.Log;
import android.widget.ImageView;

import com.glider.zapisdemo.model.Salon;
import com.glider.zapisdemo.model.SalonDetail;
import com.glider.zapisdemo.model.SalonObject;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Client {
    private final static String BASE_URL = "http://zp.jgroup.kz";

    private final Retrofit retrofit;

    public final SalonService salonService;

    private Client() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL+"/rest/v1/")
                .addConverterFactory((GsonConverterFactory.create(new GsonBuilder().serializeNulls().create())))
                .build();
        salonService = retrofit.create(SalonService.class);
    }


    public interface SalonService {
        String path = "salon";

        @GET(path+"/getPopular") Call<SalonObject> popular();
        @GET(path+"/getRecommended") Call<SalonObject> recommended();
        @GET(path+"/getRecentlyAdded") Call<SalonObject> recentlyAdded();
        @GET(path+"/page") Call<SalonDetail> salonDetail(@Query("id") int id);

    }

    public void setImage(ImageView view, String url,@DrawableRes int placeholderResId){
        Picasso.get()
                .load(BASE_URL+url)
                .placeholder(placeholderResId)
                .into(view);
        Log.d("yesat",BASE_URL+url);
    }





    //Singleton
    private static volatile Client instance;
    public static Client getInstance() {
        Client localInstance = instance;
        if (localInstance == null) {
            synchronized (Client.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Client();
                }
            }
        }
        return localInstance;
    }
}
