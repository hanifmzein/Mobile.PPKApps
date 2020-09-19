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
import com.uinsk.mobileppkapps.adapter.IndexBinaanAdapter;
import com.uinsk.mobileppkapps.data.BinaanData;
import com.uinsk.mobileppkapps.model.Mahasiswa;
import com.uinsk.mobileppkapps.ui.binaan.BinaanViewModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PresensiFragment extends Fragment {

    private BinaanViewModel binaanViewModel;

    public static PresensiFragment newInstance() {
        return new PresensiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_binaan_presensi, container, false);

        binaanViewModel = ViewModelProviders.of(this).get(BinaanViewModel.class);

        final RecyclerView rvIndexPresensi = root.findViewById(R.id.rv_index_presensi);

        binaanViewModel.getMahasiswa().observe(getViewLifecycleOwner(), new Observer<ArrayList<Mahasiswa>>() {
            @Override
            public void onChanged(ArrayList<Mahasiswa> listMahasiswa) {

                int size = listMahasiswa.get(0).getListPresensi().length();

                String[] indexs = new String[size];
                int indexActive = 0;

                for (int i=0; i<indexs.length; i++) indexs[i] = Integer.toString(i+1);

                IndexBinaanAdapter indexBinaanAdapter = new IndexBinaanAdapter(listMahasiswa, indexs, indexActive, root);

                rvIndexPresensi.setHasFixedSize(true);
                rvIndexPresensi.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                rvIndexPresensi.setAdapter(indexBinaanAdapter);
            }
        });



        return root;
    }

}