package com.uinsk.mobileppkapps.ui.pendamping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.MahasiswaPresensiAdapter;
import com.uinsk.mobileppkapps.adapter.PendampingAdapter;
import com.uinsk.mobileppkapps.model.Pendamping;

import java.util.ArrayList;

public class PendampingFragment extends Fragment {

    private PendampingViewModel pendampingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pendampingViewModel =
                ViewModelProviders.of(this).get(PendampingViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_pendamping, container, false);

        pendampingViewModel.getPendamping().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pendamping>>() {
            @Override
            public void onChanged(ArrayList<Pendamping> pendampings) {
                RecyclerView rvPendamping = root.findViewById(R.id.rv_pendamping);
                PendampingAdapter pendampingAdapter = new PendampingAdapter(pendampings);
                rvPendamping.setHasFixedSize(true);
                rvPendamping.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                rvPendamping.setAdapter(pendampingAdapter);
            }
        });

        return root;
    }
}