package com.uinsk.mobileppkapps.adapter;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import java.util.ArrayList;

public class PresensiIndexBinaanAdapter extends RecyclerView.Adapter<PresensiIndexBinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    View root;
    int indexActive;

    public PresensiIndexBinaanAdapter(ArrayList<Mahasiswa> listMahasiswa, int indexActive, View root){
        this.listMahasiswa = listMahasiswa;
        this.root = root;
        this.indexActive = indexActive;
    }

    @NonNull
    @Override
    public PresensiIndexBinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_presensi, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final PresensiIndexBinaanAdapter.ViewHolder holder, final int position) {

        if (indexActive != position) holder.tvIndexPresensi.setTypeface(null, Typeface.NORMAL);
        else {
            holder.tvIndexPresensi.setTypeface(null, Typeface.BOLD);
        }

        holder.tvIndexPresensi.setText(Integer.toString(position+1));
        holder.cvIndexPresensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(holder, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMahasiswa.get(0).getPresensi().length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvIndexPresensi;
        TextView tvIndexPresensi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvIndexPresensi = itemView.findViewById(R.id.cv_index_presensi);
            tvIndexPresensi = itemView.findViewById(R.id.tv_index_presensi);
        }
    }

    public void click(PresensiIndexBinaanAdapter.ViewHolder holder, int position){
        RecyclerView rvMahasiswa = root.findViewById(R.id.rv_binaan);
        PresensiBinaanAdapter presensiBinaanAdapter;

        holder.tvIndexPresensi.setTypeface(null, Typeface.BOLD);
        indexActive = position;
        notifyDataSetChanged();

        rvMahasiswa.setLayoutManager(new LinearLayoutManager(root.getContext()));
        presensiBinaanAdapter = new PresensiBinaanAdapter(listMahasiswa, position);
        rvMahasiswa.setAdapter(presensiBinaanAdapter);
    }
}
