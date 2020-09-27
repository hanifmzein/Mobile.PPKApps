package com.uinsk.mobileppkapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Dosen;

import java.util.ArrayList;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.ViewHolder> {
    ArrayList<Dosen> listDosen;

    public DosenAdapter(ArrayList<Dosen> listDosen){
        this.listDosen = listDosen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_dosen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Dosen dosen = listDosen.get(position);

        holder.tvNama.setText(dosen.getNama());
        holder.tvNip.setText(dosen.getNip());
        holder.tvProdi.setText(dosen.getProdi_nama());

    }

    @Override
    public int getItemCount() {
        return listDosen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNip, tvProdi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_dosen);
            tvNip = itemView.findViewById(R.id.tv_nip_dosen);
            tvProdi = itemView.findViewById(R.id.tv_prodi);
        }
    }
}
