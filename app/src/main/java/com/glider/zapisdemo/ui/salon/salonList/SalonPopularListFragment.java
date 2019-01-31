package com.glider.zapisdemo.ui.salon.salonList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.model.Salon;
import com.glider.zapisdemo.model.SalonObject;
import com.glider.zapisdemo.ui.salon.SalonDetailActivity;
import com.glider.zapisdemo.ui.salon.SalonListFragment;
import com.glider.zapisdemo.ui.salon.SalonRecyclerViewAdapter;
import com.glider.zapisdemo.utility.Client;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SalonPopularListFragment extends SalonListFragment {

    @Override
    protected Call<SalonObject> getCall() {
        return Client.getInstance().salonService.popular();
    }
}
