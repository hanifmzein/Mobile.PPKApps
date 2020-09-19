package com.uinsk.mobileppkapps.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class BinaanAdapter extends RecyclerView.Adapter<BinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    int indexPresensi;

    BinaanAdapter(ArrayList<Mahasiswa> listMahasiswa, int indexPresensi) {
        this.listMahasiswa = listMahasiswa;
        this.indexPresensi = indexPresensi;
    }

    @NonNull
    @Override
    public BinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_presensi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BinaanAdapter.ViewHolder holder, final int position) {
        final Mahasiswa mahasiswa = listMahasiswa.get(position);

        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvProdi.setText(mahasiswa.getIdProdi());
        holder.tvKelompok.setText(mahasiswa.getIdKelompok());

        String hadir = null;
        try {
            hadir = mahasiswa.getListPresensi().get(indexPresensi).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (hadir.equals("h")) hadir(holder);
        else if (hadir.equals("i")) izin(holder);
        else if (hadir.equals("a")) alpa(holder);

        holder.imgHadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList(mahasiswa, position, holder, "hadir");
            }
        });

        holder.imgIzin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList(mahasiswa, position, holder, "izin");
            }
        });

        holder.imgAlpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList(mahasiswa, position, holder, "alpa");
            }
        });

    }

    @Override
    public int getItemCount() {

        return listMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNim, tvNama, tvProdi, tvKelompok;
        ImageView imgAlpa, imgIzin, imgHadir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNim = itemView.findViewById(R.id.tv_nim_mahasiswa);
            tvNama = itemView.findViewById(R.id.tv_nama_mahasiswa);
            tvProdi = itemView.findViewById(R.id.tv_id_prodi);
            tvKelompok = itemView.findViewById(R.id.tv_id_kelompok);

            imgAlpa = itemView.findViewById(R.id.img_alpa);
            imgIzin = itemView.findViewById(R.id.img_izin);
            imgHadir = itemView.findViewById(R.id.img_hadir);

        }
    }

    void updateList(Mahasiswa mahasiswa, final int position, final BinaanAdapter.ViewHolder holder, final String presensi){

        String status = presensi.substring(0,1);

        String url = "http://10.0.2.2:8000/presensi/"+mahasiswa.getNim()+"/"+ indexPresensi +"/"+status;
        System.out.println("URL : "+url);

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    Mahasiswa mhs = new Mahasiswa(new JSONArray(new String(responseBody)).getJSONObject(0));
                    System.out.println();
                    listMahasiswa.set(position, mhs);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (presensi == "hadir") hadir(holder);
                else if (presensi == "izin") izin(holder);
                else if (presensi == "alpa") alpa(holder);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    void hadir(BinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgHadir.setColorFilter(Color.parseColor("#005739"));
    }

    void izin(BinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgIzin.setColorFilter(Color.parseColor("#FFEE00"));
    }

    void alpa(BinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgAlpa.setColorFilter(Color.parseColor("#E80000"));
    }

    void netral(BinaanAdapter.ViewHolder holder){
        holder.imgHadir.setColorFilter(Color.parseColor("#DCDCDC"));
        holder.imgIzin.setColorFilter(Color.parseColor("#DCDCDC"));
        holder.imgAlpa.setColorFilter(Color.parseColor("#DCDCDC"));

    }

}