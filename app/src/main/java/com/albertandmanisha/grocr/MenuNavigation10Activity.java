package com.albertandmanisha.grocr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuNavigation10Activity extends AppCompatActivity {
    SlidingPaneLayout mSlidingPanel;
    ListView menuList;
    ArrayList<MenuNavigation10Model> menuData;
    MenuNavigation10Adapter adapter;
    Fragment storeFragment, categoryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menunavigation10_layout);

        mSlidingPanel = (SlidingPaneLayout) findViewById(R.id.SlidingPanel);
        mSlidingPanel.setPanelSlideListener(panelListener);
        mSlidingPanel.setParallaxDistance(100);
        mSlidingPanel.setSliderFadeColor(ContextCompat.getColor(this, android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Browse By Store");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
        }

        storeFragment = new StoreBrowseFragment();

        if (storeFragment.getActivity() == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.framelayout_menu, new StoreBrowseFragment()).commit();
        }

        final String[] menus = {"Browse by Store", "Browse by Category", "Shopping List", "Settings", "Account"};
        menuData = new ArrayList<>();

        for (int i=0; i< menus.length; i++){
            MenuNavigation10Model menu = new MenuNavigation10Model();
            menu.setMenuName(menus[i]);
            if(i == 0){
                menu.setMenuNotificationCount(4);
            }
            menuData.add(menu);
        }

        menuList = (ListView) findViewById(R.id.menuList);
        adapter = new MenuNavigation10Adapter(this, menuData);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    //TODO case 3 and 4
                    case 0:
                        if (storeFragment.getActivity() == null) {
                            ActionBar actionBar = getSupportActionBar();
                            if (actionBar != null) {
                                actionBar.setDisplayShowTitleEnabled(true);
                                actionBar.setTitle("Browse By Store");
                            }
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.framelayout_menu, new StoreBrowseFragment()).commit();
                        }
                        break;
                    case 1:
                        //TODO
                        ActionBar actionBar = getSupportActionBar();
                        if (actionBar != null) {
                            actionBar.setDisplayShowTitleEnabled(true);
                            actionBar.setTitle("Browse By Category");
                        }
                        break;
                    case 2:
                        //TODO
                        ActionBar actionBar1 = getSupportActionBar();
                        if (actionBar1 != null) {
                            actionBar1.setDisplayShowTitleEnabled(true);
                            actionBar1.setTitle("Shopping List");
                        }
                        break;
                    default:
                        break;
                }
                Toast.makeText(MenuNavigation10Activity.this, "menu "+menus[i]+" clicked!", Toast.LENGTH_SHORT).show();
                mSlidingPanel.closePane();

                menuData.clear();
                for (int j=0; j< menus.length; j++) {
                    MenuNavigation10Model menu = new MenuNavigation10Model();
                    menu.setMenuName(menus[j]);
                    if (j == 0) {
                        menu.setMenuNotificationCount(4);
                    }
                    if(j == i) {
                        menu.setSelected(true);
                    }
                    menuData.add(menu);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    SlidingPaneLayout.PanelSlideListener panelListener = new SlidingPaneLayout.PanelSlideListener(){

        @Override
        public void onPanelClosed(View arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPanelOpened(View arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPanelSlide(View arg0, float arg1) {
            // TODO Auto-generated method stub

        }

    };

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(mSlidingPanel.isOpen()){
                    mSlidingPanel.closePane();
                }else{
                    mSlidingPanel.openPane();
                }
                break;
            case R.id.action_search:
                Toast.makeText(this, "action search clicked!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

//    private ArrayList<GalleryStyle9Model> getAllItemList(){
//        ArrayList<GalleryStyle9Model> allItems = new ArrayList<>();
//        GalleryStyle9Model dt;
//
//        dt = new GalleryStyle9Model("Freshco","1151 Dundas St W, Mississauga","freshco_logo.png");
//        allItems.add(dt);
//        dt = new GalleryStyle9Model("Real Canadian Superstore","3045 Mavis Rd, Mississauga","superstore.png");
//        allItems.add(dt);
//        dt = new GalleryStyle9Model("Sobeys","5602 Tenth Line W, Mississauga","Sobeys_logo.png");
//        allItems.add(dt);
//        dt = new GalleryStyle9Model("walmart","2160 Burnhamthorpe Rd W, Mississauga","Walmart_logo.png");
//        allItems.add(dt);
//
//        return  allItems;
//    }
//
//    @Override
//    public void itemClicked(View view, int position) {
//        int num = position + 1;
//        Toast.makeText(this, "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
//    }

}
