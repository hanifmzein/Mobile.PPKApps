package com.uinsk.mobileppkapps.data;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class BinaanData {
    public static ArrayList<Mahasiswa> data = new ArrayList<>();

    public static void setData(ArrayList<Mahasiswa> data) {
        BinaanData.data = data;
    }

    public static ArrayList<Mahasiswa> getData() {
        return data;
    }

    public static void updateData(){
//        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
//
//        String url = "http://10.0.2.2:8000/mahasiswa/semua/B03";
//
//        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                String result = new String(responseBody);
//
//                try {
//                    JSONArray jsonArray = new JSONArray(result);
//                    ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
//
//                    for (int i = 0; i < jsonArray.length(); i++)
//                    {
//                        JSONObject jsonObj = jsonArray.getJSONObject(i);
//                        Mahasiswa mahasiswa = new Mahasiswa(jsonObj);
//                        mahasiswas.add(mahasiswa);
//                    }
//
//                    setData(mahasiswas);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
    }
}
