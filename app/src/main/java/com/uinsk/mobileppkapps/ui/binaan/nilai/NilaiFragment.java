package com.uinsk.mobileppkapps.ui.binaan.nilai;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uinsk.mobileppkapps.R;

public class NilaiFragment extends Fragment {

    private NilaiViewModel mViewModel;

    public static NilaiFragment newInstance() {
        return new NilaiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_binaan_nilai, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NilaiViewModel.class);
        // TODO: Use the ViewModel
    }

}