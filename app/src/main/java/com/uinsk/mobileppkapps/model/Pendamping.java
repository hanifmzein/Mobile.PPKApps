package com.uinsk.mobileppkapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class Pendamping implements Parcelable {

    String nim;
    String prodi;
    String nama;
    String no_wa;
    String kelompok_id;

    public Pendamping(JSONObject json) throws JSONException {
        this.nim = json.getString("nim");
        this.nama = json.getString("nama");
        this.prodi = json.getString("prodi");
        this.no_wa = json.getString("no_wa");
        this.kelompok_id = json.getJSONObject("kelompok").getString("id");
    }

    protected Pendamping(Parcel in) {
        nim = in.readString();
        prodi = in.readString();
        nama = in.readString();
        no_wa = in.readString();
        kelompok_id = in.readString();
    }

    public static final Creator<Pendamping> CREATOR = new Creator<Pendamping>() {
        @Override
        public Pendamping createFromParcel(Parcel in) {
            return new Pendamping(in);
        }

        @Override
        public Pendamping[] newArray(int size) {
            return new Pendamping[size];
        }
    };

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
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

    public String getKelompok_id() {
        return kelompok_id;
    }

    public void setKelompok_id(String kelompok_id) {
        this.kelompok_id = kelompok_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nim);
        parcel.writeString(prodi);
        parcel.writeString(nama);
        parcel.writeString(no_wa);
        parcel.writeString(kelompok_id);
    }
}
