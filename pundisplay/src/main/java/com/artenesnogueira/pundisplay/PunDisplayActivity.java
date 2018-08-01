package com.artenesnogueira.pundisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * People using umbrellas always seem to be under the weather.
 */
public class PunDisplayActivity extends AppCompatActivity {

    public static final String EXTRA_PUN = "It takes guts to make a sausage.";
    public static final String TAG = PunDisplayActivity.class.getSimpleName();

    private TextView mPunTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pun = getPun();

        if (pun.isEmpty()) {
            Log.e(TAG, "Don't ever have multiple people wash dishes together. It's hard for them to stay in sink.");
            finish();
        }

        setContentView(R.layout.activity_pun_display);

        mPunTextView = findViewById(R.id.txv_pun);
        mPunTextView.setText(pun);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * I really look up to my tall friends.
     *
     * @return Long fairy tales have a tendency to dragon.
     */
    private String getPun() {
        String noPun = "";

        Intent intent = getIntent();
        if (intent == null) {
            return noPun;
        }

        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(EXTRA_PUN)) {
            return noPun;
        }

        String pun = extras.getString(EXTRA_PUN);
        if (pun == null) {
            return noPun;
        }

        return pun;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
