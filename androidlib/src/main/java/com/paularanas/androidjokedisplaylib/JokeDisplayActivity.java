package com.paularanas.androidjokedisplaylib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        getWindow().setBackgroundDrawable(null);
        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);
        Intent intent = getIntent();
        String jokeText = intent.getStringExtra("theJoke");
        jokeTextView.setText(jokeText);

    }
}
