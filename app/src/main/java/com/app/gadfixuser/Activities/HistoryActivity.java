package com.app.gadfixuser.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.gadfixuser.Adapter.HistoryAdapter;
import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.ActivityHistoryBinding;

public class HistoryActivity extends BaseActivity<ActivityHistoryBinding> implements HistoryAdapter.Onclick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.historyContent.historyRecyclerView.setHasFixedSize(true);
        binding.historyContent.historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.historyContent.historyRecyclerView.setAdapter(new HistoryAdapter(this,HistoryActivity.this));
    }

    @Override
    protected int getNavigationMenuItemId() {
        return R.id.user_history;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_history;
    }

    @Override
    public void getPosition(int position) {

    }
}