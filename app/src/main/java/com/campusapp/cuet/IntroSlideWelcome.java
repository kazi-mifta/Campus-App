package com.campusapp.cuet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agency.tango.materialintro.R;
import agency.tango.materialintroscreen.SlideFragment;

//See The IntroSlideCalendar Section To Know More How This Class Works
public class IntroSlideWelcome extends SlideFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.welcome, container, false);

        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.first_slide_background;
    }

    @Override
    public int buttonsColor() {
        return R.color.first_slide_buttons;
    }




}