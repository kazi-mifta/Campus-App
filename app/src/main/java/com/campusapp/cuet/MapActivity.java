package com.campusapp.cuet;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import agency.tango.materialintro.R;

/*
*This is where The Map Activity Gets Created And We Can See And Scrool The Map . It Uses Co-Ordinate System To
* Show the View As We Scrool Up or Down or Sideways.
 */
public class MapActivity extends Activity {
    private LinearLayout container;
    private int currentX;
    private int currentY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.map));


    }
}