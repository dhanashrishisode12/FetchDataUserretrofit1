package com.example.fetchdatauserretrofit1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Servicepojo extends RecyclerView.Adapter<Servicepojo.ViewHolder> {



    Context mContext;
    List<ServiceData> mArray;


    public Servicepojo(Context cxt, List<ServiceData> mArray) {
        this.mContext = cxt;
        this.mArray = mArray;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public ViewHolder(View v) {
            super(v);

            text = (TextView) v.findViewById(R.id.text);

        }
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(mArray.get(position).getServicesName());
        //holder.bind(items.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_servicepojo, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }



    }
