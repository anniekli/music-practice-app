package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "MusicFragment";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Creating");

        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        Button addMusicButton = root.findViewById(R.id.addMusicButton);
        EditText newMusic = root.findViewById(R.id.newMusic);
        Button confirmAddButton = root.findViewById(R.id.confirmAddButton);

        newMusic.setHint("Mozart Concerto in D Major");

        newMusic.setVisibility(View.VISIBLE);
        confirmAddButton.setVisibility(View.VISIBLE);

        addMusicButton.setOnClickListener(this);
        confirmAddButton.setOnClickListener(this);

        return root;


    }


    @Override
    public void onClick(View view) {
        Button addMusicButton = view.findViewById(R.id.addMusicButton);
        Button confirmAddButton = view.findViewById(R.id.confirmAddButton);
        EditText newMusic = view.findViewById(R.id.newMusic);
        confirmAddButton.setVisibility(View.GONE);


        switch (view.getId()) {
            case R.id.addMusicButton:
                Log.i(TAG, "addMusicButton clicked");

                newMusic.setVisibility(View.GONE);
                addMusicButton.setVisibility(View.GONE);

                break;
            case R.id.confirmAddButton:
                Log.i(TAG, "confirmAddButton clicked");

                newMusic.setVisibility(View.GONE);
                confirmAddButton.setVisibility(View.GONE);
                addMusicButton.setVisibility(View.VISIBLE);
//
//                Button myButton = new Button(getActivity());
//                myButton.setText(newMusic.getText());
//                myButton.setId(i);
//                i++;
//                LinearLayout musicLayout = view.findViewById(R.id.musicLayout);
//                musicLayout.addView(myButton);
//
                break;
            // Do this for all buttons.
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }
}