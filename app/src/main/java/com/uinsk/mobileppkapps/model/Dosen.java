package com.uinsk.mobileppkapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Dosen implements Parcelable {

    String nip;
    String nama;
    String no_wa;
    String prodi_nama;
    String prodi_id;

    public Dosen(JSONObject json) throws JSONException {
        this.nip = json.getString("nip");
        this.nama = json.getString("nama");
        this.no_wa = json.getString("no_wa");
        this.prodi_nama = json.getJSONObject("prodi").getString("nama");
        this.prodi_id = json.getJSONObject("prodi").getString("id");
    }

    public Dosen(Parcel in) {
        nip = in.readString();
        nama = in.readString();
        no_wa = in.readString();
        prodi_nama = in.readString();
        prodi_id = in.readString();
    }

    public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
        @Override
        public Dosen createFromParcel(Parcel in) {
            return new Dosen(in);
        }

        @Override
        public Dosen[] newArray(int size) {
            return new Dosen[size];
        }
    };

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_wa() {
        return no_wa;
    }

    public void setNo_wa(String no_wa) {
        this.no_wa = no_wa;
    }

    public String getProdi_nama() {
        return prodi_nama;
    }

    public void setProdi_nama(String prodi_nama) {
        this.prodi_nama = prodi_nama;
    }

    public String getProdi_id() {
        return prodi_id;
    }

    public void setProdi_id(String prodi_id) {
        this.prodi_id = prodi_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nip);
        parcel.writeString(nama);
        parcel.writeString(no_wa);
        parcel.writeString(prodi_nama);
        parcel.writeString(prodi_id);
    }
}
