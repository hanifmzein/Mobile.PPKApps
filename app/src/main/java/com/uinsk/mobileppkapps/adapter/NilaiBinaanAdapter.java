package com.uinsk.mobileppkapps.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.model.Nilai;
import com.uinsk.mobileppkapps.ui.binaan.nilai.NilaiSheet;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

import static com.uinsk.mobileppkapps.ui.binaan.nilai.NilaiSheet.NILAI;

public class NilaiBinaanAdapter extends RecyclerView.Adapter<NilaiBinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    String indexNilai;
    Context context;
    BottomSheetDialogFragment bottomSheetNilai;

    public NilaiBinaanAdapter(ArrayList<Mahasiswa> listMahasiswa, String indexNilai) {
        this.listMahasiswa = listMahasiswa;
        this.indexNilai = indexNilai;
    }

    @NonNull
    @Override
    public NilaiBinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_nilai, parent, false);

        this.context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NilaiBinaanAdapter.ViewHolder holder, final int position) {
        final Mahasiswa mahasiswa = listMahasiswa.get(position);

        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvProdi.setText(mahasiswa.getIdProdi());
        holder.tvKelompok.setText(mahasiswa.getIdKelompok());

        try {
            holder.tvNilai.setText(mahasiswa.getNilai().getString(this.indexNilai));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        holder.tvNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetNilai = new NilaiSheet();
                Nilai nilai = new Nilai(mahasiswa.getNim(), indexNilai, holder.tvNilai.getText().toString(), mahasiswa, holder.tvNilai);
                Bundle bundle = new Bundle();
                bundle.putParcelable(NILAI, nilai);
                bottomSheetNilai.setArguments(bundle);
                bottomSheetNilai.show(((AppCompatActivity)context).getSupportFragmentManager(), "text");

            }
        });

    }

    @Override
    public int getItemCount() {

        return listMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNim, tvNama, tvProdi, tvKelompok, tvNilai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNim = itemView.findViewById(R.id.tv_nim_mahasiswa);
            tvNama = itemView.findViewById(R.id.tv_nama_mahasiswa);
            tvProdi = itemView.findViewById(R.id.tv_id_prodi);
            tvKelompok = itemView.findViewById(R.id.tv_id_kelompok);
            tvNilai = itemView.findViewById(R.id.tv_nilai);

        }
    }
}