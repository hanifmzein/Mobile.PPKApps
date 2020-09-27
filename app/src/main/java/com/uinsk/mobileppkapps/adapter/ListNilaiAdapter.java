package com.uinsk.mobileppkapps.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;

import java.util.Arrays;

public class ListNilaiAdapter extends RecyclerView.Adapter<ListNilaiAdapter.ViewHolder> {
    String[] listNilai;

    public ListNilaiAdapter(String[] listNilai){
        this.listNilai = listNilai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_nilai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //tv Nilai
        holder.tvNilai.setText(listNilai[position]);
    }

    @Override
    public int getItemCount() {
        return listNilai.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNilai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNilai = itemView.findViewById(R.id.tv_nilai);

        }
    }
}
