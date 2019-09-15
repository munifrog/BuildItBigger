package com.udacity.gradle.builditbigger.backend;


import com.udacity.gradle.builditbigger.jokes.JokeSupplier;

/** The object model for the data we are sending through endpoints */
class JokeBean {

    private String mIntro;
    private String mPunchline;

    JokeBean(int position) {
        setPosition(position);
    }

    public String [] getData() {
        String [] data = {
            mIntro,
            mPunchline
        };
        return data;
    }

    public String getJokeIntro() {
        return mIntro;
    }

    public String getJokeDelivery() {
        return mPunchline;
    }

    void setPosition(int position) {
        int actual = position % JokeSupplier.getCount();
        mIntro = JokeSupplier.getJokeLeadup(actual);
        mPunchline = JokeSupplier.getPunchline(actual);
    }
}
