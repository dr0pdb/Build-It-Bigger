package com.example.displayjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        Bundle bundle = getIntent().getExtras();
        String joke = bundle.getString("joke");
        jokeTextView = (TextView) findViewById(R.id.tv_joke);
        jokeTextView.setText(joke);
    }
}
