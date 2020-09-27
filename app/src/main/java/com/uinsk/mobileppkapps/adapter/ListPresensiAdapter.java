package com.uinsk.mobileppkapps.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;

public class ListPresensiAdapter extends RecyclerView.Adapter<ListPresensiAdapter.ViewHolder> {
    String[] listPresensi;

    public ListPresensiAdapter(String[] listPresensi){
        this.listPresensi = listPresensi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_presensi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if (listPresensi[position].equals("h")){
            holder.imgPresensi.setImageResource(R.drawable.ic_presensi_hadir);
            holder.imgPresensi.setColorFilter(Color.parseColor("#005739"));
        } else if (listPresensi[position].equals("i")){
            holder.imgPresensi.setImageResource(R.drawable.ic_presensi_izin);
            holder.imgPresensi.setColorFilter(Color.parseColor("#FFEE00"));
        } else if (listPresensi[position].equals("a")){
            holder.imgPresensi.setImageResource(R.drawable.ic_presensi_alpa);
            holder.imgPresensi.setColorFilter(Color.parseColor("#E80000"));
        }
    }

    @Override
    public int getItemCount() {
        return listPresensi.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPresensi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPresensi = itemView.findViewById(R.id.img_presensi);

        }
    }
}
