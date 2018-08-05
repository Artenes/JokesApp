package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.artenesnogueira.pundisplay.PunDisplayActivity;

/**
 * My cat was just sick on the carpet, I don’t think it’s feline well.
 */
public class MainActivity extends AppCompatActivity {

    private TextView mInstructionsTextView;
    private Button mTellJokeButton;
    private ProgressBar mLoadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstructionsTextView = findViewById(R.id.instructions_text_view);
        mTellJokeButton = findViewById(R.id.tell_joke_button);
        mLoadingProgressBar = findViewById(R.id.loading_progressbar);

        mLoadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        finishLoading();
    }

    public void tellJoke(String pun) {
        Intent intent = new Intent(this, PunDisplayActivity.class);
        intent.putExtra(PunDisplayActivity.EXTRA_PUN, pun);
        startActivity(intent);
    }

    public void startLoading() {
        mLoadingProgressBar.setVisibility(View.VISIBLE);
        mTellJokeButton.setVisibility(View.GONE);
        mInstructionsTextView.setVisibility(View.GONE);
    }

    public void finishLoading() {
        mLoadingProgressBar.setVisibility(View.GONE);
        mTellJokeButton.setVisibility(View.VISIBLE);
        mInstructionsTextView.setVisibility(View.VISIBLE);
    }

    public void onButtonClicked(View view) {
        new LoadPunTask(this).execute();
    }

}