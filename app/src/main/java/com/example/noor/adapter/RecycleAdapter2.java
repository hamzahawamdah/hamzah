package com.example.noor.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noor.R;
import com.example.noor.model.BannerModel;
import com.example.noor.model.CatModel;

import java.util.List;

public class RecycleAdapter2 extends RecyclerView.Adapter<RecycleAdapter2.viewItem>{

    Context d;
    List<CatModel> items;

    public RecycleAdapter2(Context d, List<CatModel> item) {
        items = item;
        this.d = d;
    }

    public class viewItem extends RecyclerView.ViewHolder {
        Button btn;
        public viewItem(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.catbtn);
        }
    }

    @NonNull
    @Override
    public RecycleAdapter2.viewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_review2, parent, false);
        return new viewItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter2.viewItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
