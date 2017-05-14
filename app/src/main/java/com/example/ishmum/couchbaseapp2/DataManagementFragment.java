package com.example.ishmum.couchbaseapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataManagementFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_data_management, container, false);
        ((TextView) v.findViewById(R.id.data_management_fragment_text_view)).setText("Hello World!");
        return v;
    }

}
