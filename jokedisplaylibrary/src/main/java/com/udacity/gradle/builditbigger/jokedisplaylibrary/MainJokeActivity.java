package com.udacity.gradle.builditbigger.jokedisplaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {
    public static final String JOKE_DELIVERY_INITIAL = "tell_joke_leadup";
    public static final String JOKE_DELIVERY_PUNCHLINE = "tell_joke_delivery";

    TextView mTvJokeLeadUp;
    TextView mTvJokeDelivery;
    TextView mTvInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        Intent intent = getIntent();
        if(intent != null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            mTvJokeLeadUp = findViewById(R.id.tv_joke_leadup);
            mTvJokeLeadUp.setText(intent.getStringExtra(JOKE_DELIVERY_INITIAL));

            mTvInstructions = findViewById(R.id.tv_joke_instruction);

            mTvJokeDelivery = findViewById(R.id.tv_joke_delivery);
            String punchline = intent.getStringExtra(JOKE_DELIVERY_PUNCHLINE);
            if (punchline != null && !punchline.isEmpty()) {
                mTvInstructions.setVisibility(View.VISIBLE);
                mTvJokeDelivery.setVisibility(View.INVISIBLE);
                mTvJokeDelivery.setText(punchline);

                FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTvJokeDelivery.setVisibility(View.VISIBLE);
                        mTvInstructions.setVisibility(View.GONE);
                    }
                });
            }
        } else {
            finish();
        }
    }

}
