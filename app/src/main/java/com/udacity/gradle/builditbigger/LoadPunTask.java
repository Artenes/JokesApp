package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * How do you organize an outer space party? You planet.
 */
public class LoadPunTask extends AsyncTask<Void, Void, String> {

    private static final String TAG = LoadPunTask.class.getSimpleName();
    private WeakReference<MainActivity> mMainActivityReference;
    private PunsRepository mPunsRepository;

    public LoadPunTask(MainActivity mainActivity) {
        mMainActivityReference = new WeakReference<>(mainActivity);
        mPunsRepository = new PunsRepository(BuildConfig.JOKES_APP_USE_FAKE_SERVER);
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
        try {
            return mPunsRepository.getPun();
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