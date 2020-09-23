package com.uinsk.mobileppkapps.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class PresensiBinaanAdapter extends RecyclerView.Adapter<PresensiBinaanAdapter.ViewHolder> {

    ArrayList<Mahasiswa> listMahasiswa;
    int indexPresensi;
    Context context;

    public PresensiBinaanAdapter(ArrayList<Mahasiswa> listMahasiswa, int indexPresensi) {
        this.listMahasiswa = listMahasiswa;
        this.indexPresensi = indexPresensi+1;
    }

    @NonNull
    @Override
    public PresensiBinaanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_presensi, parent, false);

        this.context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PresensiBinaanAdapter.ViewHolder holder, final int position) {
        final Mahasiswa mahasiswa = listMahasiswa.get(position);

        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvProdi.setText(mahasiswa.getIdProdi());
        holder.tvKelompok.setText(mahasiswa.getIdKelompok());

        String hadir = null;
        try {
            hadir = mahasiswa.getPresensi().get("hari_"+indexPresensi).toString();
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

    void updateList(final Mahasiswa mahasiswa, final int position, final PresensiBinaanAdapter.ViewHolder holder, final String presensi){

        final String status = presensi.substring(0,1);

        String url = "mahasiswa/presensi/"+mahasiswa.getNim();
        System.out.println("URL : "+url);

        RequestParams params = new RequestParams();
        params.put("_method", "PATCH");
        params.put("index", indexPresensi);
        params.put("status", status);
        StringEntity entity=null;
        try {
            entity = new StringEntity(params.toString());
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        PropClient.post(this.context, url, entity, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
//                    Mahasiswa mhs = new Mahasiswa(new JSONArray(new String(responseBody)).getJSONObject(0));

                    mahasiswa.setPresensi(mahasiswa.getPresensi().put("hari_"+indexPresensi, status));
//                    listMahasiswa.set(position, mahasiswa);

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

    void hadir(PresensiBinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgHadir.setColorFilter(Color.parseColor("#005739"));
    }

    void izin(PresensiBinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgIzin.setColorFilter(Color.parseColor("#FFEE00"));
    }

    void alpa(PresensiBinaanAdapter.ViewHolder holder){
        netral(holder);
        holder.imgAlpa.setColorFilter(Color.parseColor("#E80000"));
    }

    void netral(PresensiBinaanAdapter.ViewHolder holder){
        holder.imgHadir.setColorFilter(Color.parseColor("#DCDCDC"));
        holder.imgIzin.setColorFilter(Color.parseColor("#DCDCDC"));
        holder.imgAlpa.setColorFilter(Color.parseColor("#DCDCDC"));

    }

}