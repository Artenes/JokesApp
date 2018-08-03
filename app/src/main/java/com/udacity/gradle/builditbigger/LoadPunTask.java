package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * How do you organize an outer space party? You planet.
 */
public class LoadPunTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = LoadPunTask.class.getSimpleName();
    private static MyApi mApiService = null;
    private WeakReference<MainActivity> mMainActivityReference;

    public LoadPunTask(MainActivity mainActivity) {
        mMainActivityReference = new WeakReference<>(mainActivity);
    }

    @Override
    protected void onPreExecute() {
        MainActivity mainActivity = mMainActivityReference.get();
        if (mainActivity == null) {
            return;
        }
        mainActivity.startLoading();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            mApiService = builder.build();
        }

        try {
            return mApiService.sayHi().execute().getData();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String pun) {
        MainActivity mainActivity = mMainActivityReference.get();
        if (mainActivity == null) {
            return;
        }
        mainActivity.tellJoke(pun);
    }

}