package com.uinsk.mobileppkapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Pendamping;

import java.util.ArrayList;

public class PendampingAdapter extends RecyclerView.Adapter<PendampingAdapter.ViewHolder> {
    ArrayList<Pendamping> listPendamping;

    public PendampingAdapter(ArrayList<Pendamping> listPendamping){
        this.listPendamping = listPendamping;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_pendamping, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pendamping pendamping = listPendamping.get(position);

        holder.tvNama.setText(pendamping.getNama());
        holder.tvNim.setText(pendamping.getNim());
        holder.tvKelompok.setText(pendamping.getKelompok_id());
        holder.tvProdi.setText(pendamping.getProdi());

    }

    @Override
    public int getItemCount() {
        return listPendamping.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNim, tvProdi, tvKelompok;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_pendamping);
            tvNim = itemView.findViewById(R.id.tv_nim_pendamping);
            tvProdi = itemView.findViewById(R.id.tv_prodi);
            tvKelompok = itemView.findViewById(R.id.tv_kelompok);
        }
    }
}
