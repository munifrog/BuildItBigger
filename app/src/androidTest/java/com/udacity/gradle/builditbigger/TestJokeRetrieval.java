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
    private boolean mbReadyToContinue;
    private String mIntro;
    private String mPunchline;

    @Test
    public void retrievesNonEmptyJoke() {
        RetrieveJoke jokeRetriever = new RetrieveJoke(this);
        mbReadyToContinue = false;
        //noinspection unchecked
        jokeRetriever.execute(new Pair("Test Application", JOKE_TO_RETRIEVE));
        while (!mbReadyToContinue) {
            // Do nothing
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // Ignored
            }
        }
        assertNotEquals("", mIntro);
        assertNotEquals("", mPunchline);
    }

    @Override
    public void onRetrieved(String intro, String punchline) {
        mIntro = intro;
        mPunchline = punchline;
        mbReadyToContinue = true;
    }

    @Override
    public void onInternetFailure(Exception e) {
        // Should not happen but not necessarily a bug if it does
        mIntro = "";
        mPunchline = "";
        mbReadyToContinue = true;
    }
}
