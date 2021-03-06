package com.example.ishmum.couchbaseapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CouchBaseActivities couchBaseActivities = new CouchBaseActivities(this);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_frame_layout, new DataManagementFragment())
                .commit();
    }
}
