package com.uinsk.mobileppkapps.ui.mahasiswa.nilai;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uinsk.mobileppkapps.R;

public class NilaiMahasiswaFragment extends Fragment {

    private NilaiMahasiswaViewModel mViewModel;

    public static NilaiMahasiswaFragment newInstance() {
        return new NilaiMahasiswaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mahasiswa_nilai, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NilaiMahasiswaViewModel.class);
        // TODO: Use the ViewModel
    }

}