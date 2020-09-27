package com.uinsk.mobileppkapps.ui.pendamping;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Dosen;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.model.Pendamping;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PendampingViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Pendamping>> listPendamping = new MutableLiveData<>();

    public PendampingViewModel() {
        String url = "pendamping";

        PropClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("pendamping");

                    ArrayList<Pendamping> pendampings = new ArrayList<>();

                    for (int i = 0; i<jsonArray.length(); i++){
                        JSONObject jsObject = jsonArray.getJSONObject(i);
                        Pendamping pendamping = new Pendamping(jsObject);
                        pendampings.add(pendamping);
                    }

                    listPendamping.postValue(pendampings);

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

    public LiveData<ArrayList<Pendamping>> getPendamping() {
        return listPendamping;
    }
}