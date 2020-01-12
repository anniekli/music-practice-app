package com.example.musicpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity {

    /** What to include:
     *
     * practice tracker(you input how much time you practiced, the app will display a graph
     *
     * track what you are working on(what pieces, excerpts, etudes, etc)
     * you can search from a catalog and when you enter in a piece or etude, a list of youtube videos
     * or recordings of that piece will pop up(you can click a button tht says "videos" or it will display some
     * automatically?
     *
     * you can write notes on what you practiced, what you still need to work on, metronome markings, what to remember
     * for each piece, etc.
     *
     * includes a timer that only runs when your phone is off or is on that app so you don't get distracted
     * (can also include a list of apps that you can use, i.e. metronome or tuner)
     *
     * can create automatic practice plans for you, or you can create a plan based on when your performance/audition is,
     * how much time you have to prepare, how prepared you are(optional?)
     *
     * can also have a built in point system? or rewards? practice streaks!!!
     *
     * @param savedInstanceState
     */

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(TAG, "Creating");


        ImageButton logoButton = findViewById(R.id.logoButton);
        logoButton.setOnClickListener(unused -> launchCreateNewActivity());
    }

    public void launchCreateNewActivity() {
        Intent intent = new Intent(this, CreateNewActivity.class);
        startActivity(intent);
    }
}
