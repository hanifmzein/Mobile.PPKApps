package com.uinsk.mobileppkapps.ui.dosen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Dosen;
import com.uinsk.mobileppkapps.model.Pendamping;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class DosenViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Dosen>> listDosen = new MutableLiveData<>();

    public DosenViewModel() {
        String url = "dosen";

        PropClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("dosen");

                    ArrayList<Dosen> dosens = new ArrayList<>();

                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject jsObject = jsonArray.getJSONObject(i);
                        Dosen dosen = new Dosen(jsObject);
                        dosens.add(dosen);
                    }

                    listDosen.postValue(dosens);

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

    public LiveData<ArrayList<Dosen>> getDosen() {
        return listDosen;
    }
}