package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.test.suitebuilder.annotation.Suppress;

import com.example.paularanas.builditbigger.backend.jokesApi.JokesApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.paularanas.androidjokedisplaylib.JokeDisplayActivity;

import java.io.IOException;

/**
 * Created by Paul Aranas on 1/18/2016.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static JokesApi myApiService = null;
    private static MainActivityFragment UIContainer;


    public EndpointsAsyncTask() {
    }

    EndpointsAsyncTask(MainActivityFragment context) {
        UIContainer = context;


    }

    @Suppress
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... params) {
        //set up app engine
        JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null).setRootUrl("http://10.0.2.2:8080/_ah/api")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });


        myApiService = builder.build();
        //Have thread sleep 500ms to display indicator more fully
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e)

        {
            return e.getMessage();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // intent to display activity
        Intent intent = new Intent(UIContainer.getActivity(), JokeDisplayActivity.class);
        intent.putExtra("theJoke", result);
        UIContainer.startActivity(intent);

    }


}




