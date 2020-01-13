package com.example.musicpractice.ui.music;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicpractice.R;

public class MusicFragment extends Fragment implements View.OnClickListener {

    private MusicViewModel musicViewModel;
    private static final String TAG = "MusicFragment";
    Button addMusicButton, confirmAddButton ;
    EditText newMusic;
    static int i = 1;
    LinearLayout getMusicLayout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Creating");

        musicViewModel =
                ViewModelProviders.of(this).get(MusicViewModel.class);
        View root = inflater.inflate(R.layout.fragment_music, container, false);
        addMusicButton = root.findViewById(R.id.addMusicButton);
        newMusic = root.findViewById(R.id.newMusic);
        confirmAddButton = root.findViewById(R.id.confirmAddButton);

        newMusic.setHint("Mozart Concerto in D Major");
        newMusic.setVisibility(View.GONE);
        confirmAddButton.setVisibility(View.GONE);

        addMusicButton.setOnClickListener(this);
        confirmAddButton.setOnClickListener(this);
        getMusicLayout = root.findViewById(R.id.musicLayout);


        return root;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addMusicButton:
                Log.i(TAG, "addMusicButton clicked");
                confirmAddButton.setVisibility(View.VISIBLE);
                newMusic.setVisibility(View.VISIBLE);
                addMusicButton.setVisibility(View.GONE);
                newMusic.setText("");


                break;
            case R.id.confirmAddButton:
                Log.i(TAG, "confirmAddButton clicked");

                newMusic.setVisibility(View.GONE);
                confirmAddButton.setVisibility(View.GONE);
                addMusicButton.setVisibility(View.VISIBLE);

                Button myButton = new Button(getActivity());
                myButton.setText(newMusic.getText());
                myButton.setId(i);
                i++;
                getMusicLayout.addView(myButton);

                break;
            // Do this for all buttons.
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }
}