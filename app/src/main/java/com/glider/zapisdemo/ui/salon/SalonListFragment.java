package com.glider.zapisdemo.ui.salon;

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

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class SalonListFragment extends Fragment {

    public SalonListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_salon_list, container, false);
        RecyclerView list = v.findViewById(R.id.list);
        final SwipeRefreshLayout refreshLayout = v.findViewById(R.id.refresh);

        final SalonRecyclerViewAdapter adapter = new SalonRecyclerViewAdapter(new SalonRecyclerViewAdapter.SalonClickListener() {
            @Override
            public void onClick(Salon salon) {
                SalonDetailActivity.start(getActivity(),salon.getId());
            }
        });
        list.setAdapter(adapter);

        final SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCall().enqueue(new Callback<SalonObject>() {
                    @Override
                    public void onResponse(@NonNull Call<SalonObject> call, @NonNull Response<SalonObject> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapter.salons = response.body().getSalons();
                            adapter.notifyDataSetChanged();
                            refreshLayout.setRefreshing(false);
                        } else {
                            try {
                                Log.e("yesat", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.d("yesat", "asdasdas");
                    }

                    @Override
                    public void onFailure(@NonNull Call<SalonObject> call, @NonNull Throwable t) {
                        t.printStackTrace();
                        refreshLayout.setRefreshing(false);
                    }
                });
            }
        };

        refreshLayout.setOnRefreshListener(refreshListener);
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                refreshListener.onRefresh();
            }
        });
        return v;
    }

    protected abstract Call<SalonObject> getCall();
}
