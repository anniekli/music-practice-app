package com.example.musicpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateNewActivity extends AppCompatActivity {

    private static final String TAG = "CreateNewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        Log.i(TAG, "Creating");

        EditText enterName = findViewById(R.id.enterName);
        enterName.setHint("Enter your name");

        TextView errorMessage = findViewById(R.id.errorMessage);
        errorMessage.setVisibility(View.GONE);

        Button continueButton = findViewById(R.id.continueButton);

        continueButton.setOnClickListener(unused -> createActivityClicked());

    }

    private void createActivityClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        EditText enterName = findViewById(R.id.enterName);
        String setName = enterName.getText().toString();

        TextView errorMessage = findViewById(R.id.errorMessage);


        if (setName.trim().isEmpty()) {
            errorMessage.setVisibility(View.VISIBLE);
            errorMessage.setTextColor(Color.RED);
            errorMessage.setText("Please enter your name");
        } else {
            intent.putExtra("name", setName);
            Log.i(TAG, "My name is " + setName);
            startActivity(intent);
        }



    }
}
