package com.app.gadfixuser.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.app.gadfixuser.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class AutoSliderAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public AutoSliderAdapter(Context context, ArrayList<Integer> images){
        this.context=context;
        this.images=images;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int posotion, Object object){
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position){
        View imageLayout=inflater.inflate(R.layout.dashboard,view,false);
        assert imageLayout!=null;
        final ImageView imageView=(ImageView)imageLayout.findViewById(R.id.images);

        Glide.with(context).load(images.get(position)).into(imageView);
        view.addView(imageLayout,0);

        return  imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
