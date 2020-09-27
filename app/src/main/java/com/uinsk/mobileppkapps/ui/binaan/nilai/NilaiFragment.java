package com.uinsk.mobileppkapps.ui.binaan.nilai;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.SslCertificate;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.NilaiBinaanAdapter;
import com.uinsk.mobileppkapps.adapter.NilaiIndexBinaanAdapter;
import com.uinsk.mobileppkapps.adapter.PresensiIndexBinaanAdapter;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.ui.binaan.BinaanViewModel;

import java.util.ArrayList;
import java.util.Iterator;

public class NilaiFragment extends Fragment {

    private BinaanViewModel binaanViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root =  inflater.inflate(R.layout.fragment_binaan_nilai, container, false);
        final RecyclerView rvIndexNilai = root.findViewById(R.id.rv_index_nilai);

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0);
        String tipe = pref.getString("tipe", null);
        String binaan = pref.getString("binaan", null);

        String prodi = "";
        String kelompok = "";

        if (tipe.equals("dosen")){
            prodi = binaan;
            kelompok = "semua";
        } else if (tipe.equals("pendamping")){
            prodi = "semua";
            kelompok = binaan;
        }

        binaanViewModel = ViewModelProviders.of(this).get(BinaanViewModel.class);
        binaanViewModel.setListMahasiswa(prodi, kelompok);
        binaanViewModel.getMahasiswa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Mahasiswa>>() {
            @Override
            public void onChanged(ArrayList<Mahasiswa> listMahasiswa) {

                int indexActive = 0;

                int len = listMahasiswa.get(0).getNilai().length();

                String[] indexNilai = new String[len];

                Iterator x = listMahasiswa.get(0).getNilai().keys();

                for (int i=0; i<len; i++) indexNilai[i] = x.next().toString();

                NilaiIndexBinaanAdapter nilaiIndexBinaanAdapter = new NilaiIndexBinaanAdapter(getActivity(), indexNilai, listMahasiswa, indexActive, root);

                rvIndexNilai.setHasFixedSize(true);
                rvIndexNilai.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                rvIndexNilai.setAdapter(nilaiIndexBinaanAdapter);


                RecyclerView rvMahasiswa = root.findViewById(R.id.rv_binaan);
                NilaiBinaanAdapter nilaiBinaanAdapter;
                rvMahasiswa.setLayoutManager(new LinearLayoutManager(root.getContext()));
                nilaiBinaanAdapter = new NilaiBinaanAdapter(listMahasiswa, indexNilai[indexActive]);
                rvMahasiswa.setAdapter(nilaiBinaanAdapter);
            }
        });

        return root;
    }

    @Override
    public void onResume() {



        super.onResume();
    }

}