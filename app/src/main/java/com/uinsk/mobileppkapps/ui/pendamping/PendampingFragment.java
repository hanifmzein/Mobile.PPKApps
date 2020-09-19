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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uinsk.mobileppkapps.R;

public class PendampingFragment extends Fragment {

    private PendampingViewModel pendampingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pendampingViewModel =
                ViewModelProviders.of(this).get(PendampingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pendamping, container, false);
        final TextView textView = root.findViewById(R.id.text_pendamping);
        pendampingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}