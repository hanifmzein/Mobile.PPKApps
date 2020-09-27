package com.uinsk.mobileppkapps.ui.binaan.nilai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.model.Nilai;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class NilaiSheet extends BottomSheetDialogFragment {

    public static String NILAI = "nilai";

    TextView tvNilai;
    EditText edtNilai;
    Button btnNilai;
    Mahasiswa mahasiswa;
    TextView tvAngka;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sheet_nilai, container, false);

        tvNilai = view.findViewById(R.id.tv_nilai);
        edtNilai = view.findViewById(R.id.edt_nilai);
        btnNilai = view.findViewById(R.id.btn_nilai);

        Bundle bundle = getArguments();

        final Nilai nilai = bundle.getParcelable(NILAI);
        tvNilai.setText(nilai.getTipe());
        edtNilai.setText(nilai.getNilai());
        mahasiswa = nilai.getMahasiswa();
        tvAngka = nilai.getTvNilai();

        btnNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nim = nilai.getNim();
                final String tipe = tvNilai.getText().toString();
                final String angka = edtNilai.getText().toString();

                String url = "mahasiswa/nilai/"+nim;

                RequestParams params = new RequestParams();
                params.put("_method", "PATCH");
                params.put("jenis", tipe);
                params.put("nilai", angka);
                StringEntity entity=null;
                try {
                    entity = new StringEntity(params.toString());
                    entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                System.out.println("updating nilai...");

                PropClient.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        try {
                            mahasiswa.setPresensi(mahasiswa.getNilai().put(tipe, angka));
                            tvAngka.setText(angka);
                            dismiss();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("NILAI GAGAL");
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
            }
        });

        return view;
    }
}
