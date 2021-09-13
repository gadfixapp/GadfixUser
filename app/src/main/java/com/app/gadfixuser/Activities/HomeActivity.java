package com.app.gadfixuser.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.app.gadfixuser.Adapter.AutoSliderAdapter;
import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomeActivity extends  BaseActivity<ActivityHomeBinding> {

    private View view;
    private static int presentPage=0;
    private static int numPages=0;
    private static final Integer[] imgs={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private ArrayList<Integer> imgsarray = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBanner();
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.user_home;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }


    //autoslider
    private void getBanner(){

        for(int i=0;i<imgs.length;i++){
            imgsarray.add(imgs[i]);
        }

        binding.contents.imageAutoSlider.setAdapter(new AutoSliderAdapter(HomeActivity.this,imgsarray));
        binding.contents.imageAutoSlider.setClipToPadding(false);
        binding.contents.imageAutoSlider.setClipChildren(false);
        binding.contents.imageAutoSlider.setOffscreenPageLimit(3);

        CircleIndicator indicator=(CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(binding.contents.imageAutoSlider);

        final float density=getResources().getDisplayMetrics().density;
        indicator.setViewPager(binding.contents.imageAutoSlider);

        numPages=imgs.length;

        final Handler handler=new Handler();
        final Runnable Update=new Runnable() {
            @Override
            public void run() {
                if(presentPage==numPages){
                    presentPage=0;
                }
                binding.contents.imageAutoSlider.setCurrentItem(presentPage++,true);

            }
        };

        Timer swipTimer=new Timer();
        swipTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);


        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                presentPage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}