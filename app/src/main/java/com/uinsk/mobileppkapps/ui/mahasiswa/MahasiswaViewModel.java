package com.uinsk.mobileppkapps.ui.mahasiswa;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class MahasiswaViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Mahasiswa>> listMahasiswa = new MutableLiveData<>();

    public MahasiswaViewModel() {
        String url = "mahasiswa";

        PropClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("mahasiswas");

                    ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();

                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject jsObject = jsonArray.getJSONObject(i);
                        Mahasiswa mahasiswa = new Mahasiswa(jsObject);
                        mahasiswas.add(mahasiswa);
                    }

                    listMahasiswa.postValue(mahasiswas);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("g berhasil");
            }
        });
    }

    public LiveData<ArrayList<Mahasiswa>> getMahasiswa() {
        return listMahasiswa;
    }
}