package com.udacity.gradle.builditbigger.jokes;

public class JokeSupplier implements Jokes {
    public static String getJokeLeadup(int position) {
        int modPosition = position % Jokes.joke.length;
        return Jokes.joke[modPosition][0];
    }

    public static String getPunchline(int position) {
        int modPosition = position % Jokes.joke.length;
        return Jokes.joke[modPosition][1];
    }

    public static int getCount() {
        return Jokes.joke.length;
    }
}
