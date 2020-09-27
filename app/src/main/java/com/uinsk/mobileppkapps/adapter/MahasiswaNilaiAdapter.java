package com.uinsk.mobileppkapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Iterator;

public class MahasiswaNilaiAdapter extends RecyclerView.Adapter<MahasiswaNilaiAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;

    public MahasiswaNilaiAdapter(ArrayList<Mahasiswa> listMahasiswa){
        this.listMahasiswa = listMahasiswa;
    }

    @NonNull
    @Override
    public MahasiswaNilaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_mahasiswa_nilai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaNilaiAdapter.ViewHolder holder, int position) {

        Mahasiswa mahasiswa = listMahasiswa.get(position);

        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvProdi.setText(mahasiswa.getIdProdi());
        holder.tvKelompok.setText(mahasiswa.getIdKelompok());

        int len = mahasiswa.getNilai().length();
        String[] indexNilai = new String[len];
        Iterator x = listMahasiswa.get(0).getNilai().keys();
        for (int i=0; i<len; i++) {
            try {
                indexNilai[i] = mahasiswa.getNilai().getString(x.next().toString()) ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ListNilaiAdapter listNilaiAdapter = new ListNilaiAdapter(indexNilai);
        holder.rvNilai.setHasFixedSize(true);
        holder.rvNilai.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        holder.rvNilai.setAdapter(listNilaiAdapter);
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvNim, tvProdi, tvKelompok;
        RecyclerView rvNilai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNim = itemView.findViewById(R.id.tv_nim_mahasiswa);
            tvNama = itemView.findViewById(R.id.tv_nama_mahasiswa);
            tvProdi = itemView.findViewById(R.id.tv_id_prodi);
            tvKelompok = itemView.findViewById(R.id.tv_id_kelompok);

            rvNilai = itemView.findViewById(R.id.rv_nilai);
        }
    }
}
