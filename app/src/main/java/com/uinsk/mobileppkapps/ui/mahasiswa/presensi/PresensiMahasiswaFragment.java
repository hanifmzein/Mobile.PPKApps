package com.uinsk.mobileppkapps.ui.mahasiswa.presensi;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uinsk.mobileppkapps.R;

public class PresensiMahasiswaFragment extends Fragment {

    private PresensiMahasiswaViewModel mViewModel;

    public static PresensiMahasiswaFragment newInstance() {
        return new PresensiMahasiswaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mahasiswa_presensi, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PresensiMahasiswaViewModel.class);
        // TODO: Use the ViewModel
    }

}