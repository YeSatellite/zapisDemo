package com.glider.zapisdemo.ui.salon.servises;

import com.glider.zapisdemo.model.Service;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class CategoryGroup extends ExpandableGroup<Service> {

    public CategoryGroup(String title, List<Service> items) {
        super(title, items);
    }
}