package com.uinsk.mobileppkapps.ui.binaan.presensi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PresensiViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<ArrayList<Mahasiswa>> listMahasiswa = new MutableLiveData<>();

    public PresensiViewModel() {

        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://10.0.2.2:8000/mahasiswa/semua/B03";
        System.out.println(url);

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();

                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonObj = jsonArray.getJSONObject(i);

                        Mahasiswa mahasiswa = new Mahasiswa(jsonObj);
                        mahasiswas.add(mahasiswa);
                    }

                    listMahasiswa.postValue(mahasiswas);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public LiveData<ArrayList<Mahasiswa>> getMahasiswa() {
        return listMahasiswa;
    }

}