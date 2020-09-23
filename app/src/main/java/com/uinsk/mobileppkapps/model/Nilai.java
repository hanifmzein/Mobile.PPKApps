package com.uinsk.mobileppkapps.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Nilai implements Parcelable {

    String tipe;
    String nilai;
    String nim;
    Mahasiswa mahasiswa;

    public Nilai(String nim, String tipe, String nilai, Mahasiswa mahasiswa) {
        this.nim = nim;
        this.tipe = tipe;
        this.nilai = nilai;
        this.mahasiswa = mahasiswa;
    }

    protected Nilai(Parcel in) {
        tipe = in.readString();
        nilai = in.readString();
        nim = in.readString();
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

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tipe);
        parcel.writeString(nilai);
        parcel.writeString(nim);
        parcel.writeParcelable(mahasiswa, i);
    }
}
