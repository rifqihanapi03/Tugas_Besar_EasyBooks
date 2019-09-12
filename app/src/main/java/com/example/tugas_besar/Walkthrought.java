package com.example.tugas_besar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Walkthrought extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter ;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0 ;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this activity full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (restorePrefData()) {

            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }


        setContentView(R.layout.activity_walkthrought);

        // ini untuk view
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_starterd);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        // list screen

        final List<ScreenItem> mLis = new ArrayList<>();
        mLis.add(new ScreenItem("Easy Read", "aaaaaaaaaaaaaaaaaaaa", R.drawable.img1));
        mLis.add(new ScreenItem("Portability", "aaaaaaaaaaaaaaaaaaaaaa", R.drawable.img2));
        mLis.add(new ScreenItem("Simple", "aaaaaaaaaaaaaaaaaaaaaaaaaa", R.drawable.img3));


        // proses viewpager

        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mLis);
        screenPager.setAdapter(introViewPagerAdapter);


        // setup tablayout dan viewpager

        tabIndicator.setupWithViewPager(screenPager);

        // next button click

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position = screenPager.getCurrentItem();
                if(position<mLis.size()){

                    position++;
                    screenPager.setCurrentItem(position);


                }

                if (position == mLis.size()-1){

                    // TODO : untuk menampilkan mulai button dan menutup indikator  dan next button

                    loaddLastScreen();
                }




            }
        });

        // tablayout add change listener

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == mLis.size()-1){

                    loaddLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // btn get started button click listener

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // open activity
                Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);


                savePrefsData();
                finish();
            }
        });

    }

    private boolean restorePrefData(){


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("IsIntroOpnend", false);
        return  isIntroActivityOpnendBefore;


    }

    private void savePrefsData(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("IsIntroOpnend",true);
        editor.commit();


    }

    private void loaddLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        //setup animation
        btnGetStarted.setAnimation(btnAnim);

    }
}
