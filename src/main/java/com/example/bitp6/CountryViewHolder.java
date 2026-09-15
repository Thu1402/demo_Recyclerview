package com.example.bitp6;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
private MyAdapter myadapter;
public TextView tid;
public TextView tcountry;
    public CountryViewHolder(@NonNull View item, MyAdapter adpater) {
        super(item);
        this.myadapter = adpater;
        this.tid = item.findViewById(R.id.tid);
        this.tcountry = item.findViewById(R.id.tcountry);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String mgs = tid.getText() + " | "+ tcountry.getText();
        Toast.makeText(v.getContext(),mgs, Toast.LENGTH_SHORT);
    }
}
