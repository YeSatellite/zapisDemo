package com.glider.zapisdemo.ui.salon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.glider.zapisdemo.R;
import com.glider.zapisdemo.model.Category;
import com.glider.zapisdemo.model.SalonDetail;
import com.glider.zapisdemo.model.Service;
import com.glider.zapisdemo.ui.salon.servises.CategoryGroup;
import com.glider.zapisdemo.ui.salon.servises.ServiceAdapter;
import com.glider.zapisdemo.utility.Client;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalonDetailActivity extends AppCompatActivity {
    public static String ID = "id";

    SalonDetail salonDetail;
    private ArrayList<CategoryGroup> categoryGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_detail);

        if (salonDetail != null){
            create();
            return;
        }

        int id = getIntent().getIntExtra(ID,0);
        Client.getInstance().salonService.salonDetail(id).enqueue(new Callback<SalonDetail>() {
            @Override
            public void onResponse(@NonNull Call<SalonDetail> call, @NonNull Response<SalonDetail> response) {
                if (response.isSuccessful()) {
                    salonDetail = response.body();
                    ArrayList<ArrayList<Service>> categories = new ArrayList<>(100);
                    for (int i = 0; i < 100; i++) {
                        categories.add(new ArrayList<Service>());
                    }

                    for (Service service : salonDetail.getServices()){
                        categories.get(service.getCategoryId()+50).add(service);
                    }

                    categoryGroups = new ArrayList<>();
                    for (Category category : salonDetail.getCategories()){
                        if (categories.get(category.getId()+50).size()>0){
                            categoryGroups.add(new CategoryGroup(category.getName(),categories.get(category.getId()+50)));
                        }
                    }
                    create();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SalonDetail> call, @NonNull Throwable t) {

            }
        });

    }

    private void create() {
        CollapsingToolbarLayout collapse = findViewById(R.id.collapse);
        collapse.setTitleEnabled(true);
        collapse.setTitle(salonDetail.getSalon().getName());
        collapse.setExpandedTitleColor(Color.TRANSPARENT);

        ViewPager pager = findViewById(R.id.slider);
        SlidingAdapter slidingAdapter = new SlidingAdapter(this, salonDetail.getSalon().getPictures());
        pager.setAdapter(slidingAdapter);

        CirclePageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        indicator.setRadius(5 * getResources().getDisplayMetrics().density);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ((TextView)findViewById(R.id.name)).setText(salonDetail.getSalon().getName());
        ((TextView)findViewById(R.id.type)).setText(salonDetail.getSalon().getType());
        textViewHtml((TextView)findViewById(R.id.address),salonDetail.getSalon().getAddress());


        RecyclerView servicesView = findViewById(R.id.services);
        servicesView.setLayoutManager(new LinearLayoutManager(this));

        ServiceAdapter adapter = new ServiceAdapter(categoryGroups);
        servicesView.setAdapter(adapter);

    }

    private void textViewHtml(TextView textView, String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(text));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public static void start(Activity activity, int id){
        Intent intent = new Intent(activity, SalonDetailActivity.class);
        intent.putExtra(ID, id);
        activity.startActivity(intent);
    }
}
