package com.app.gadfixuser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.CartViewBinding;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    Context context;
    private LayoutInflater layoutInflater;
    private Onclick onclick;

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartViewBinding binding;
        if(layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        binding= DataBindingUtil.inflate(layoutInflater, R.layout.cart_view,parent,false);
        return new CartAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CartAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public interface Onclick {
        void getPosition(int position);
    }

    public CartAdapter(Context context,Onclick onclick){
        this.context=context;
        this.onclick=onclick;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CartViewBinding binding;
        public MyViewHolder(@NonNull CartViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
