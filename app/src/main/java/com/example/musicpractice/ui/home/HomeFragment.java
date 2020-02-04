package com.example.musicpractice.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.MainActivity;
import com.example.musicpractice.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private static final String TAG = "HomeFragment";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        String name = ((MainActivity) getActivity()).getName();//you will get name here.
        TextView welcomeText = root.findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + name + "!");

        return root;
    }
}