package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.srv_twry.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by srv_twry on 11/6/17.
 */

public class FetchJokeAsyncTask extends AsyncTask<Void,Void,String> {

    private MyApi myApiService = null;

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        }catch (IOException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}