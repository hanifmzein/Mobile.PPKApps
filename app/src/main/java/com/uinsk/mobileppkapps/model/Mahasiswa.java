package com.uinsk.mobileppkapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Mahasiswa implements Parcelable {

    String nim;
    String nama;
    String idProdi;
    String idKelompok;
    JSONArray listPresensi;

    public Mahasiswa(JSONObject json) throws JSONException {

        nim = json.getString("nim");
        nama = json.getString("nama");
        idProdi = json.getString("id_prodi");
        idKelompok = json.getString("id_kelompok");
        listPresensi = json.getJSONArray("list_presensi");

    }

    protected Mahasiswa(Parcel in) {
        nim = in.readString();
        nama = in.readString();
        idProdi = in.readString();
        idKelompok = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(String idProdi) {
        this.idProdi = idProdi;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public JSONArray getListPresensi() {
        return listPresensi;
    }

    public void setListPresensi(JSONArray listPresensi) {
        this.listPresensi = listPresensi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nim);
        parcel.writeString(nama);
        parcel.writeString(idProdi);
        parcel.writeString(idKelompok);
    }
}
