package com.udacity.gradle.builditbigger;

import com.artenesnogueira.puns.Puns;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Repo that holds the puns to display
 */
public class PunsRepository {

    private static MyApi apiService = null;
    private final Puns punsSource;
    private final boolean useFakeServer;

    /**
     * Create a new repository
     *
     * @param useFakeServer if true, there is no need to use google cloud engine
     */
    public PunsRepository(boolean useFakeServer) {
        this.useFakeServer = useFakeServer;
        connectToGoogleCloud();
        punsSource = new Puns();
    }

    /**
     * Get a random pun
     *
     * @return a random pun
     * @throws IOException in case of reading error
     */
    public String getPun() throws IOException {
        if (!useFakeServer && apiService != null) {
            //this is the one that can throw exceptions
            return apiService.sayHi().execute().getData();
        }
        return punsSource.getPun();
    }

    /**
     * Connect to google cloud if necessary
     */
    private void connectToGoogleCloud() {
        if (!useFakeServer && apiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            apiService = builder.build();
        }
    }

}
