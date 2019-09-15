package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestJokeRetrieval implements RetrieveJoke.Listener {
    private static final int JOKE_TO_RETRIEVE = 1;

    @Test
    public void retrievesNonEmptyJoke() {
        RetrieveJoke jokeRetriever = new RetrieveJoke(this);
        //noinspection unchecked
        jokeRetriever.execute(new Pair("Test Application", JOKE_TO_RETRIEVE));
    }

    @Override
    public void onRetrieved(String intro, String punchline) {
        assertNotEquals("", intro);
        assertNotEquals("", punchline);
    }

    @Override
    public void onInternetFailure(Exception e) {
        // Should not happen but not necessarily a bug if it does
    }
}
