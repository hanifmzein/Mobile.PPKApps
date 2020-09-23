package com.uinsk.mobileppkapps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

public class Nilai implements Parcelable {

    String nim;
    String tipe;
    String nilai;
    Mahasiswa mahasiswa;
    TextView tvNilai;

    public Nilai(String nim, String tipe, String nilai, Mahasiswa mahasiswa, TextView tvNilai) {
        this.nim = nim;
        this.tipe = tipe;
        this.nilai = nilai;
        this.mahasiswa = mahasiswa;
        this.tvNilai = tvNilai;
    }

    protected Nilai(Parcel in) {
        nim = in.readString();
        tipe = in.readString();
        nilai = in.readString();
        mahasiswa = in.readParcelable(Mahasiswa.class.getClassLoader());
    }

    public static final Creator<Nilai> CREATOR = new Creator<Nilai>() {
        @Override
        public Nilai createFromParcel(Parcel in) {
            return new Nilai(in);
        }

        @Override
        public Nilai[] newArray(int size) {
            return new Nilai[size];
        }
    };

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public TextView getTvNilai() {
        return tvNilai;
    }

    public void setTvNilai(TextView tvNilai) {
        this.tvNilai = tvNilai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nim);
        parcel.writeString(tipe);
        parcel.writeString(nilai);
        parcel.writeParcelable(mahasiswa, i);
    }
}
