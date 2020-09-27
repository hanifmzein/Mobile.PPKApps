package com.uinsk.mobileppkapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaPresensiAdapter extends RecyclerView.Adapter<MahasiswaPresensiAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;

    public MahasiswaPresensiAdapter(ArrayList<Mahasiswa> listMahasiswa){
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public MahasiswaPresensiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_mahasiswa_presensi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaPresensiAdapter.ViewHolder holder, int position) {

        Mahasiswa mahasiswa = listMahasiswa.get(position);

        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvProdi.setText(mahasiswa.getIdProdi());
        holder.tvKelompok.setText(mahasiswa.getIdKelompok());

    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvNim, tvProdi, tvKelompok;
        ListView lvPresensi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNim = itemView.findViewById(R.id.tv_nim_mahasiswa);
            tvNama = itemView.findViewById(R.id.tv_nama_mahasiswa);
            tvProdi = itemView.findViewById(R.id.tv_id_prodi);
            tvKelompok = itemView.findViewById(R.id.tv_id_kelompok);

        }
    }
}
