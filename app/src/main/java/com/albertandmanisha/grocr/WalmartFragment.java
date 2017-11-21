package com.albertandmanisha.grocr;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class WalmartFragment extends Fragment implements GalleryStyle9ClickListener{



    public WalmartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_walmart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<ItemModel> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);


        RecyclerView rView = getView().findViewById(R.id.recyclerViewWalmart);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ItemAdapter rcAdapter = new ItemAdapter(this.getContext(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<ItemModel> getAllItemList(){
        ArrayList<ItemModel> allItems = new ArrayList<>();
        ItemModel dt;
        dt = new ItemModel("Annie's Homegrown Mac & Cheese","Gluten Free","superstore.png", 2.22);
        allItems.add(dt);
        dt = new ItemModel("Catelli Spaghetti","Gluten Free","freshco_logo.png", 1.47);
        allItems.add(dt);
        dt = new ItemModel("Clubhouse Brown Gravy","Gluten Free","freshco_logo.png", 1.37);
        allItems.add(dt);
        dt = new ItemModel("Dare Breton Original with Flax Crackers","Gluten Free","freshco_logo.png", 1.88);
        allItems.add(dt);
        dt = new ItemModel("Altayib Brand Beef Bouillon Cubes","Halal","freshco_logo.png", 1.97);
        allItems.add(dt);
        dt = new ItemModel("Altayib Canned Chicken Meat","Halal","freshco_logo.png", 2.67);
        allItems.add(dt);
        dt = new ItemModel("Grace Corned Beef","Halal","freshco_logo.png", 3.97);
        allItems.add(dt);
        dt = new ItemModel("Knorr Chicken Bouillon Flavoured Cubes","Halal","freshco_logo.png", 1.17);
        allItems.add(dt);
        dt = new ItemModel("Amy's Kitchen Medium Chili","Organic", "freshco_logo.png", 4.47);
        allItems.add(dt);
        dt = new ItemModel("Breton Dare Roasted Garlic Crackers","Organic", "freshco_logo.png", 1.88);
        allItems.add(dt);
        dt = new ItemModel("Great Value Quinoa","Organic", "freshco_logo.png", 3.97);
        allItems.add(dt);
        dt = new ItemModel("Hellmann's Mayonnaise","Organic", "freshco_logo.png", 4.97);
        allItems.add(dt);
        dt = new ItemModel("Breton Dare Artisanal Cranberry and Ancient grains Crackers", "Peanut Free", "freshco_logo.png", 1.88);
        allItems.add(dt);
        dt = new ItemModel("Breton Dare Artisanal Sweet Potato and Ancient grains Crackers", "Peanut Free", "freshco_logo.png", 1.88);
        allItems.add(dt);
        dt = new ItemModel("Mars Candy Bar (10 Pack)", "Peanut Free", "freshco_logo.png", 2.00);
        allItems.add(dt);
        dt = new ItemModel("Quaker Chewy Chocolate Chip Granola Bars", "Peanut Free", "freshco_logo.png", 1.97);
        allItems.add(dt);
        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(this.getContext(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
