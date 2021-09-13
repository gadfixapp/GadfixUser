package com.app.gadfixuser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gadfixuser.R;
import com.app.gadfixuser.databinding.HistoryViewBinding;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context context;
    private LayoutInflater layoutInflater;
    private Onclick onclick;

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HistoryViewBinding binding;
        if(layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        binding=DataBindingUtil.inflate(layoutInflater, R.layout.history_view,parent,false);
        return new HistoryAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public interface Onclick {
        void getPosition(int position);
    }

    public HistoryAdapter(Context context,Onclick onclick){
        this.context=context;
        this.onclick=onclick;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        HistoryViewBinding binding;
        public MyViewHolder(@NonNull HistoryViewBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
