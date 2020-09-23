package com.uinsk.mobileppkapps.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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

public class NilaiIndexBinaanAdapter extends RecyclerView.Adapter<NilaiIndexBinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    View root;
    int indexActive;
    String[] indexNilai;
    Context activity;

    public NilaiIndexBinaanAdapter(Context context, String[] indexNilai, ArrayList<Mahasiswa> listMahasiswa, int indexActive, View root){
        this.indexNilai = indexNilai;
        this.listMahasiswa = listMahasiswa;
        this.root = root;
        this.indexActive = indexActive;
    }

    @NonNull
    @Override
    public NilaiIndexBinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index_nilai, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final NilaiIndexBinaanAdapter.ViewHolder holder, final int position) {

        if (indexActive != position) holder.tvIndexNilai.setTypeface(null, Typeface.NORMAL);
        else {
            holder.tvIndexNilai.setTypeface(null, Typeface.BOLD);
//            click(holder, position);
        }

        holder.tvIndexNilai.setText(indexNilai[position]);
        holder.cvIndexNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(holder, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMahasiswa.get(0).getNilai().length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvIndexNilai;
        TextView tvIndexNilai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvIndexNilai = itemView.findViewById(R.id.cv_index_nilai);
            tvIndexNilai = itemView.findViewById(R.id.tv_index_nilai);
        }
    }

    public void click(NilaiIndexBinaanAdapter.ViewHolder holder, int position){
        RecyclerView rvMahasiswa = root.findViewById(R.id.rv_binaan);
        NilaiBinaanAdapter nilaiBinaanAdapter;

        holder.tvIndexNilai.setTypeface(null, Typeface.BOLD);
        indexActive = position;
        notifyDataSetChanged();

        rvMahasiswa.setLayoutManager(new LinearLayoutManager(root.getContext()));
        nilaiBinaanAdapter = new NilaiBinaanAdapter(listMahasiswa, indexNilai[position]);
        rvMahasiswa.setAdapter(nilaiBinaanAdapter);
    }
}
