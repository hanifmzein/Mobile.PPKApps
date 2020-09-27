package com.uinsk.mobileppkapps.ui.dosen;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.DosenAdapter;
import com.uinsk.mobileppkapps.adapter.PendampingAdapter;
import com.uinsk.mobileppkapps.model.Dosen;
import com.uinsk.mobileppkapps.model.Pendamping;
import com.uinsk.mobileppkapps.ui.pendamping.PendampingViewModel;

import java.util.ArrayList;

public class DosenFragment extends Fragment {

    private DosenViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root =  inflater.inflate(R.layout.fragment_dosen, container, false);

        DosenViewModel dosenViewModel;
        dosenViewModel =
                ViewModelProviders.of(this).get(DosenViewModel.class);
        dosenViewModel.getDosen().observe(getViewLifecycleOwner(), new Observer<ArrayList<Dosen>>() {
            @Override
            public void onChanged(ArrayList<Dosen> dosens) {
                RecyclerView rvPendamping = root.findViewById(R.id.rv_dosen);
                DosenAdapter dosenAdapter = new DosenAdapter(dosens);
                rvPendamping.setHasFixedSize(true);
                rvPendamping.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvPendamping.setAdapter(dosenAdapter);
            }
        });

        return root;
    }

}