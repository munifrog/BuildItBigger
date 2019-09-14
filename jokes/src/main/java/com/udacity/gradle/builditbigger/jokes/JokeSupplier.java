package com.udacity.gradle.builditbigger.jokes;

public class JokeSupplier {
    private static final String NO_PUNCHLINE = "";

    public static String getJokeLeadup() {
        return "A horse walks into the bar...";
    }

    public static String getPunchline() {
        return "... and the bartender says 'Why the long face?'";
    }
}
