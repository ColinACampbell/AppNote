package com.godspeedapps.appnote;

import android.app.Activity;
import android.os.Bundle;

public class Help extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getActionBar().setTitle("Help");
    }
}
