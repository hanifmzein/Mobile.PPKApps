package com.uinsk.mobileppkapps.ui.binaan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uinsk.mobileppkapps.R;

public class BinaanFragment extends Fragment {

    private BinaanViewModel binaanViewModel;
    BottomNavigationView bottomNavigationView;
    NavController navController;

    FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_binaan, container, false);

        bottomNavigationView = root.findViewById(R.id.nav_bottom);
        navController = Navigation.findNavController(root.findViewById(R.id.nav_host_fragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        return root;
    }
}