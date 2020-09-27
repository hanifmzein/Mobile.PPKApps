package com.uinsk.mobileppkapps.ui.mahasiswa.presensi;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.MahasiswaPresensiAdapter;
import com.uinsk.mobileppkapps.adapter.PresensiBinaanAdapter;
import com.uinsk.mobileppkapps.adapter.PresensiIndexBinaanAdapter;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.ui.binaan.BinaanViewModel;
import com.uinsk.mobileppkapps.ui.mahasiswa.MahasiswaViewModel;

import java.util.ArrayList;

public class PresensiMahasiswaFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_mahasiswa_presensi, container, false);


        MahasiswaViewModel mahasiswaViewModel = ViewModelProviders.of(this).get(MahasiswaViewModel.class);
        mahasiswaViewModel.getMahasiswa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Mahasiswa>>() {
            @Override
            public void onChanged(ArrayList<Mahasiswa> listMahasiswa) {

                RecyclerView rvMahasiswaPresensi = view.findViewById(R.id.rv_mahasiswa_presensi);
                MahasiswaPresensiAdapter mahasiswaPresensiAdapter = new MahasiswaPresensiAdapter(listMahasiswa);
                rvMahasiswaPresensi.setHasFixedSize(true);
                rvMahasiswaPresensi.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvMahasiswaPresensi.setAdapter(mahasiswaPresensiAdapter);
            }
        });

        return view;
    }

}