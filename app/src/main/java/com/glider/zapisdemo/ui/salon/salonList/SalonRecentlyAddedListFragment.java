package com.glider.zapisdemo.ui.salon.salonList;

import com.glider.zapisdemo.model.SalonObject;
import com.glider.zapisdemo.ui.salon.SalonListFragment;
import com.glider.zapisdemo.utility.Client;

import retrofit2.Call;


public class SalonRecentlyAddedListFragment extends SalonListFragment {

    @Override
    protected Call<SalonObject> getCall() {
        return Client.getInstance().salonService.recentlyAdded();
    }
}
