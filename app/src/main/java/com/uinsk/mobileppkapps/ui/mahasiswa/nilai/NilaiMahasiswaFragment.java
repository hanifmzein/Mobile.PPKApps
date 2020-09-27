package com.uinsk.mobileppkapps.ui.mahasiswa.nilai;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.MahasiswaNilaiAdapter;
import com.uinsk.mobileppkapps.adapter.MahasiswaPresensiAdapter;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.ui.mahasiswa.MahasiswaViewModel;

import java.util.ArrayList;

public class NilaiMahasiswaFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_mahasiswa_nilai, container, false);

        final RecyclerView rvMahasiswaNilai = view.findViewById(R.id.rv_mahasiswa_nilai);

        MahasiswaViewModel mahasiswaViewModel = ViewModelProviders.of(this).get(MahasiswaViewModel.class);
        mahasiswaViewModel.getMahasiswa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Mahasiswa>>() {
            @Override
            public void onChanged(ArrayList<Mahasiswa> listMahasiswa) {

                MahasiswaNilaiAdapter mahasiswaNilaiAdapter = new MahasiswaNilaiAdapter(listMahasiswa);

                rvMahasiswaNilai.setHasFixedSize(true);
                rvMahasiswaNilai.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvMahasiswaNilai.setAdapter(mahasiswaNilaiAdapter);
            }
        });

        return view;
    }

}