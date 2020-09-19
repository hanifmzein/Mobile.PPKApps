package com.uinsk.mobileppkapps.adapter;

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

public class IndexBinaanAdapter extends RecyclerView.Adapter<IndexBinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    String[] indexs;
    View root;
    int indexActive;

    public IndexBinaanAdapter(ArrayList<Mahasiswa> listMahasiswa, String[] indexs, int indexActive, View root){
        this.listMahasiswa = listMahasiswa;
        this.indexs = indexs;
        this.root = root;
        this.indexActive = indexActive;
    }

    void updateData(ArrayList<Mahasiswa> listMahasiswa){
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public IndexBinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_presensi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final IndexBinaanAdapter.ViewHolder holder, final int position) {

        if (indexActive != position) holder.tvIndexPresensi.setTypeface(null, Typeface.NORMAL);
        else holder.tvIndexPresensi.setTypeface(null, Typeface.BOLD);

        holder.tvIndexPresensi.setText(indexs[position]);
        holder.cvIndexPresensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView rvMahasiswa = root.findViewById(R.id.rv_binaan);
                BinaanAdapter binaanAdapter;

                holder.tvIndexPresensi.setTypeface(null, Typeface.BOLD);
                indexActive = position;
                notifyDataSetChanged();

                rvMahasiswa.setLayoutManager(new LinearLayoutManager(root.getContext()));
                binaanAdapter = new BinaanAdapter(listMahasiswa, position);
                rvMahasiswa.setAdapter(binaanAdapter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return indexs.length;
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
}
