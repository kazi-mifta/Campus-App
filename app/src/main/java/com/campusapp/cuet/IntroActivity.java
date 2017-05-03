package com.campusapp.cuet;

import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.animations.IViewTranslation;


/*
*This class Is Packing All The Intro Calsses And Showing Them Right here Inside This Calss. Material
* Intro Library Is Used In This Section and You can Find More About it on Github.
 */
public class IntroActivity extends MaterialIntroActivity {



    //This One is differnet from appcompat Activity. The materialIntroActivity creates a screen without any top bar in it.
    // it's full Screeen and Looks Great.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);// The last slider should dissapear with a faint vanishing style for this

        getBackButtonTranslationWrapper()//The backbutton function
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });
        //Addding A new Slide Element
      /*  addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.first_slide_background)
                        .buttonsColor(R.color.first_slide_buttons)
                        .image(R.drawable.firsti)
                        .title("Welcome")
                        .description("To The Digital Campus")
                        .build());*/
        addSlide(new IntroSlideWelcome());

        addSlide(new IntroSlideUpdate());

        addSlide(new IntroSlideCalendar());

        addSlide(new IntroSlideCloud());

        addSlide(new IntroSlideCamera());

        addSlide(new IntroSlideHelp());

        addSlide(new IntroSlideDetail());

    }

    @Override
    public void onFinish() {

        Toast.makeText(this, "Visit The Update Section On Sidebar", Toast.LENGTH_LONG).show();
        super.onFinish();
    }
}