package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.gadfixuser.Adapter.CartAdapter;
import com.app.gadfixuser.Adapter.HistoryAdapter;
import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity<ActivityCartBinding> implements CartAdapter.Onclick{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.userCart.cartRecyclerView.setHasFixedSize(true);
        binding.userCart.cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.userCart.cartRecyclerView.setAdapter(new CartAdapter(this,CartActivity.this));
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.user_cart;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_cart;
    }

    @Override
    public void getPosition(int position) {

    }
}