package com.campusapp.cuet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.mikepenz.iconics.view.IconicsButton;

import java.util.jar.Attributes;

import agency.tango.materialintro.R;
import agency.tango.materialintroscreen.SlideFragment;
import mehdi.sakout.fancybuttons.FancyButton;

//See The IntroSlideCalendar Section To Know More How This Class Works
public class IntroSlideDetail extends SlideFragment {

    String Name;
    String ID;


    public EditText name;
    public EditText id;
    public FancyButton button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.detail, container, false);

        name=(EditText)view.findViewById(R.id.name);
        id=(EditText)view.findViewById(R.id.uni_ID);
        button=(FancyButton) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Name=name.getText().toString();
                        ID=id.getText().toString();

                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("Name",Name).commit();

                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("ID",ID).commit();

                        Context context= view.getContext();
                        Class destinationActivity=MainActivity.class;
                        Intent startChildActivity=new Intent(context,destinationActivity);
                        startActivity(startChildActivity);
                        Toast.makeText(getContext(), "Visit The Update Section On Sidebar", Toast.LENGTH_LONG).show();
                    }
                });

        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.custom_slide_background;
    }

    @Override
    public int buttonsColor() {
        return R.color.custom_slide_buttons;
    }

}