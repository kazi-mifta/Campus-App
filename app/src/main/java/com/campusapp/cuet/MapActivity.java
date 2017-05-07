package com.campusapp.cuet;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.github.chrisbanes.photoview.PhotoView;

import agency.tango.materialintro.R;

/*
*This is where The Map Activity Gets Created And We Can See And Scrool The Map . It Uses Co-Ordinate System To
* Show the View As We Scrool Up or Down or Sideways.
 */
public class MapActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);

        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(photoView);
        Glide.with(this).load(R.drawable.map).into(imageViewTarget);


    }
}