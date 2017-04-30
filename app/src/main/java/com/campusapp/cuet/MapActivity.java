package com.campusapp.cuet;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;

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
        container = (LinearLayout) findViewById(R.id.Container);
        container.scrollTo(220, 400);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                currentX = (int) event.getRawX();
                currentY = (int) event.getRawY();
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                int x2 = (int) event.getRawX();
                int y2 = (int) event.getRawY();
                container.scrollBy(currentX - x2 , currentY - y2);
                currentX = x2;
                currentY = y2;
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return true;
    }
}