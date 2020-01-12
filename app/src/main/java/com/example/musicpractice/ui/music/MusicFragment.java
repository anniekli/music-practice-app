package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.R;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        Button addMusicButton = root.findViewById(R.id.addMusicButton);
        EditText newMusic = root.findViewById(R.id.newMusic);
        Button confirmAddButton = root.findViewById(R.id.confirmAddButton);

        newMusic.setVisibility(View.GONE);
        confirmAddButton.setVisibility(View.GONE);

        addMusicButton.setOnClickListener(unused -> onClick(root));

        return root;


    }


    @Override
    public void onClick(View view) {
        view.findViewById(R.id.addMusicButton).setVisibility(View.GONE);
        view.findViewById(R.id.newMusic).setVisibility(View.VISIBLE);
        view.findViewById(R.id.confirmAddButton).setVisibility(View.VISIBLE);
    }
}