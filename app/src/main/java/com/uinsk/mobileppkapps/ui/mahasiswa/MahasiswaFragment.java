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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.uinsk.mobileppkapps.R;

public class MahasiswaFragment extends Fragment {

    private MahasiswaViewModel mahasiswaViewModel;
    BottomNavigationView bottomNavigationView;
    NavController navController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mahasiswaViewModel =
                ViewModelProviders.of(this).get(MahasiswaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mahasiswa, container, false);

        bottomNavigationView = root.findViewById(R.id.nav_bottom);
        navController = Navigation.findNavController(root.findViewById(R.id.nav_host_fragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return root;
    }
}