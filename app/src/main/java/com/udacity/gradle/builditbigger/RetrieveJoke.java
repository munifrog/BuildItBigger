package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.JokeBean;

import java.io.IOException;

public class RetrieveJoke extends AsyncTask<Pair<String, Integer>, Void, JokeBean> {
    private static MyApi mApiService = null;

    private static final String API_PROTOCOL = "http";
    private static final String API_SERVER = "10.0.2.2"; // Emulator localhost IP equivalent
    private static final int API_PORT = 8080;
    private static final String API_PATH = "/_ah/api";

    private Listener mListener;

    RetrieveJoke(Listener listener) {
        mListener = listener;
    }

    public interface Listener {
        void onRetrieved(String intro, String punchline);
        void onInternetFailure(Exception e);
    }

    @Override
    protected JokeBean doInBackground(Pair<String, Integer> ... params) {
        if (mApiService == null) {
            String url = API_PROTOCOL + "://" + API_SERVER + ":" + API_PORT + API_PATH;

            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),
                    null
            )
                    .setApplicationName(params[0].first)
                    .setRootUrl(url)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            mApiService = builder.build();
        }

        try {
            return mApiService.getJokeAt(params[0].second).execute();
        } catch (IOException e) {
            e.printStackTrace();
            mListener.onInternetFailure(e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(JokeBean joke) {
        if (joke != null) {
            mListener.onRetrieved(joke.getJokeIntro(), joke.getJokeDelivery());
        }
    }
}
