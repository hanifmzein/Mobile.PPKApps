package com.uinsk.mobileppkapps.ui.mahasiswa;

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
import com.google.android.material.snackbar.Snackbar;
import com.uinsk.mobileppkapps.R;

public class MahasiswaFragment extends Fragment {

    private MahasiswaViewModel mahasiswaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mahasiswaViewModel =
                ViewModelProviders.of(this).get(MahasiswaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mahasiswa, container, false);

//        final TextView textView = root.findViewById(R.id.text_mahasiswa);
//        mahasiswaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle bundle = new Bundle();
        bundle.putString("tes", "VALUE STRING ARGUMEN");

        setArguments(bundle);

        return root;
    }
}