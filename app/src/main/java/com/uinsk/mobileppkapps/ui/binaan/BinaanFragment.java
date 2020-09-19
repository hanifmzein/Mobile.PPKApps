package com.uinsk.mobileppkapps.ui.binaan;

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
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.uinsk.mobileppkapps.R;
import com.uinsk.mobileppkapps.adapter.IndexBinaanAdapter;
import com.uinsk.mobileppkapps.data.BinaanData;
import com.uinsk.mobileppkapps.model.Mahasiswa;

import java.util.ArrayList;

public class BinaanFragment extends Fragment {

    private BinaanViewModel binaanViewModel;
    BottomNavigationView bottomNavigationView;
    NavController navController;

    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binaanViewModel = ViewModelProviders.of(this).get(BinaanViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_binaan, container, false);

        bottomNavigationView = root.findViewById(R.id.nav_bottom);
        navController = Navigation.findNavController(root.findViewById(R.id.nav_host_fragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        return root;
    }
}