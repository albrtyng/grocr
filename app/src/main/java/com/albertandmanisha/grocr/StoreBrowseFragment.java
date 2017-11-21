package com.albertandmanisha.grocr;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class StoreBrowseFragment extends Fragment implements GalleryStyle9ClickListener{
    Fragment walmart;


    public StoreBrowseFragment() {
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
        return inflater.inflate(R.layout.fragment_store_browse, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<GalleryStyle9Model> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = getView().findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        GalleryStyle9Adapter rcAdapter = new GalleryStyle9Adapter(this.getContext(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
    }

    private ArrayList<GalleryStyle9Model> getAllItemList(){
        ArrayList<GalleryStyle9Model> allItems = new ArrayList<>();
        GalleryStyle9Model dt;

        dt = new GalleryStyle9Model("Freshco","1151 Dundas St W, Mississauga","freshco_logo.png");
        allItems.add(dt);
        dt = new GalleryStyle9Model("Real Canadian Superstore","3045 Mavis Rd, Mississauga","superstore.png");
        allItems.add(dt);
        dt = new GalleryStyle9Model("Sobeys","5602 Tenth Line W, Mississauga","Sobeys_logo.png");
        allItems.add(dt);
        dt = new GalleryStyle9Model("walmart","2160 Burnhamthorpe Rd W, Mississauga","Walmart_logo.png");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        switch (num){
            case 4:
                ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
                walmart = new WalmartFragment();
                if (walmart.getActivity() == null){
                    actionBar.setTitle("All Walmart Items");
                    getFragmentManager().beginTransaction().add(R.id.framelayout_menu, walmart).commit();
                }
                break;
        }
        Toast.makeText(this.getContext(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
