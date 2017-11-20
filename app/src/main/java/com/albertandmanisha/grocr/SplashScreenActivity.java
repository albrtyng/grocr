package com.albertandmanisha.grocr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreenActivity extends AppCompatActivity {
    LinearLayout l2, l3;
    Intent intent;
    ImageView logo, apple, banana, pear, melon;
    Animation uptodown, downtoup, appledrop, bananadrop, melondrop, peardrop, splashfade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.splashpagelogo);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        logo.setAnimation(uptodown);

        apple = findViewById(R.id.apple);
        appledrop = AnimationUtils.loadAnimation(this, R.anim.appledrop);
        apple.setAnimation(appledrop);

        banana = findViewById(R.id.banana);
        bananadrop = AnimationUtils.loadAnimation(this, R.anim.bananadrop);
        banana.setAnimation(bananadrop);

        melon = findViewById(R.id.melon);
        melondrop = AnimationUtils.loadAnimation(this, R.anim.melondrop);
        melon.setAnimation(melondrop);

        pear = findViewById(R.id.pear);
        peardrop = AnimationUtils.loadAnimation(this, R.anim.peardrop);
        pear.setAnimation(peardrop);


        l2 = findViewById(R.id.splashpage_bottom);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l2.setAnimation(downtoup);

        l3 = findViewById(R.id.splashpage);
        splashfade = AnimationUtils.loadAnimation(this, R.anim.splashfade);
        l3.setAnimation(splashfade);

        splashfade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashfade.setFillAfter(true);
                intent = new Intent(SplashScreenActivity.this, WalkThroughActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
