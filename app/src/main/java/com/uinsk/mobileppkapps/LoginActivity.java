package com.uinsk.mobileppkapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uinsk.mobileppkapps.connection.PropClient;
import com.uinsk.mobileppkapps.model.Dosen;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.model.Pendamping;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

import static com.uinsk.mobileppkapps.MainActivity.LOGIN;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = pref.edit();
        editor.remove("tipe");
        editor.remove("user_id");
        editor.remove("nama");
        editor.remove("binaan");
        editor.apply();

        edtUsername = findViewById(R.id.edt_user);
        edtPassword = findViewById(R.id.edt_pass);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = edtUsername.getText().toString();
                final String password = edtPassword.getText().toString();
                final String url = "login";

                RequestParams params = new RequestParams();
                params.put("username", username);
                params.put("password", password);

                PropClient.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                        String result = new String(responseBody);
                        System.out.println(result);

                        try {
                            JSONObject jsonObject = new JSONObject(result).getJSONObject("user");
                            String tipe = jsonObject.getString("tipe");

                            String binaan = "";
                            String user_id = "";
                            if (tipe.equals("dosen")){
                                binaan = jsonObject.getJSONObject("prodi").getString("id");
                                user_id = jsonObject.getString("nip");
                            } else if (tipe.equals("pendamping")) {
                                binaan = jsonObject.getJSONObject("kelompok").getString("id");
                                user_id = jsonObject.getString("nim");
                            }
                            String nama = jsonObject.getString("nama");

                            editor.putString("tipe", tipe);
                            editor.putString("user_id", user_id);
                            editor.putString("binaan", binaan);
                            editor.putString("nama", nama);
                            editor.apply();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @SuppressLint("ShowToast")
                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        System.out.println(new String(responseBody));
                        Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

}