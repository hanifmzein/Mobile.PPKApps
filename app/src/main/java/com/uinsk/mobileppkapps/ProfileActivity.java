package com.uinsk.mobileppkapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.connection.PropClient;

import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

public class ProfileActivity extends AppCompatActivity {

    EditText edtId;
    EditText edtNama;
    EditText edtpassword;
    EditText edtNoWa;
    TextView tvId;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtId = findViewById(R.id.edt_id);
        edtNama = findViewById(R.id.edt_nama);
        edtpassword = findViewById(R.id.edt_password);
        edtNoWa = findViewById(R.id.edt_no_wa);
        tvId = findViewById(R.id.tv_id);
        btnUpdate = findViewById(R.id.btn_update);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = pref.edit();
        edtId.setText(pref.getString("user_id", null));
        edtNama.setText(pref.getString("nama", null));

        if (pref.getString("tipe", null).equals("pendamping")){
            tvId.setText("NIM");
        } else if (pref.getString("tipe", null).equals("dosen")){
            tvId.setText("NIP");
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = edtNama.getText().toString();
                String user_id = edtId.getText().toString();
                String password = edtpassword.getText().toString();
                String no_wa = edtNoWa.getText().toString();
                String url = "";
                String id = "";
                if (tvId.getText().toString().equals("NIM")){
                    url = "pendamping/"+edtId.getText().toString();
                    id = "nim";
                } else if (tvId.getText().toString().equals("NIP")){
                    url = "dosen/"+edtId.getText().toString();
                    id = "nip";
                }

                RequestParams params = new RequestParams();
                params.put("_method", "PATCH");
                if (!nama.equals("")){
                    params.put("nama", nama);
                    editor.putString("nama", nama);
                }
                if (!user_id.equals("")){
                    params.put(id, user_id);
                    editor.putString("user_id", user_id);
                }
                editor.apply();

                if (!no_wa.equals("")) params.put("no_wa", no_wa);
                if (!password.equals("")) params.put("password", password);

                PropClient.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });
            }
        });

    }


}