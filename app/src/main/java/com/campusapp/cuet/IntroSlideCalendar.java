package com.campusapp.cuet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agency.tango.materialintro.R;
import agency.tango.materialintroscreen.SlideFragment;

/*
*This Class Is Creating The Animated IntroView At The Very begining Of The App.It Uses Gif-Viewer Calss to Show
* The GIFs and All of Them are Collected From The Interenet.
 */
public class IntroSlideCalendar extends SlideFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.calendar, container, false);

        return view;
    }

    //Setting Color For The Backgound Of the Specific Screen.
    @Override
    public int backgroundColor() {
        return R.color.fourth_slide_background;
    }

    //Setting Color For The button Of the Specific Screen.
    @Override
    public int buttonsColor() {
        return R.color.fourth_slide_buttons;
    }



}
