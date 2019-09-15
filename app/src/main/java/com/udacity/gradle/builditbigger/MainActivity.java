package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.jokedisplaylibrary.MainJokeActivity;

import static com.udacity.gradle.builditbigger.jokedisplaylibrary.MainJokeActivity.JOKE_DELIVERY_INITIAL;
import static com.udacity.gradle.builditbigger.jokedisplaylibrary.MainJokeActivity.JOKE_DELIVERY_PUNCHLINE;


public class MainActivity extends AppCompatActivity implements RetrieveJoke.Listener {
    private static int mJokeCount = -1;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mJokeCount++;
        mProgressBar.setVisibility(View.VISIBLE);
        RetrieveJoke jokeRetriever = new RetrieveJoke(this);
        //noinspection unchecked
        jokeRetriever.execute(new Pair(getString(R.string.app_name),mJokeCount));
    }

    @Override
    public void onRetrieved(String intro, String punchline) {
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(this, MainJokeActivity.class);
        intent.putExtra(JOKE_DELIVERY_INITIAL, intro);
        if (!punchline.isEmpty()) {
            intent.putExtra(JOKE_DELIVERY_PUNCHLINE, punchline);
        }
        startActivity(intent);
    }

    @Override
    public void onInternetFailure(Exception e) {
        mProgressBar.setVisibility(View.GONE);
        e.printStackTrace();
    }
}
