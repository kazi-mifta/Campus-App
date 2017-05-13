package com.campusapp.cuet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import agency.tango.materialintro.R;

/**
 * Created by Mifta on 5/14/2017.
 */

public class Contributors extends AppCompatActivity {

    TextView Title;
    TextView Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contributors);
    }
}
