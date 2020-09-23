package com.uinsk.mobileppkapps.ui.binaan.presensi;

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

import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.PresensiIndexBinaanAdapter;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.ui.binaan.BinaanViewModel;

import java.util.ArrayList;

public class PresensiFragment extends Fragment {

    private BinaanViewModel binaanViewModel;

    public static PresensiFragment newInstance() {
        return new PresensiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_binaan_presensi, container, false);
        final RecyclerView rvIndexPresensi = root.findViewById(R.id.rv_index_presensi);

        String prodi = "semua";
        String kelompok = "B03";

        binaanViewModel = ViewModelProviders.of(this).get(BinaanViewModel.class);
        binaanViewModel.setListMahasiswa(prodi, kelompok);
        binaanViewModel.getMahasiswa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Mahasiswa>>() {
            @Override
            public void onChanged(ArrayList<Mahasiswa> listMahasiswa) {

                int indexActive = 0;

                PresensiIndexBinaanAdapter presensiIndexBinaanAdapter = new PresensiIndexBinaanAdapter(listMahasiswa, indexActive, root);

                rvIndexPresensi.setHasFixedSize(true);
                rvIndexPresensi.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                rvIndexPresensi.setAdapter(presensiIndexBinaanAdapter);
            }
        });

        return root;
    }

}