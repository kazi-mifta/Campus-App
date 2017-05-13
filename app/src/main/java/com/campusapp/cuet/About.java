package com.campusapp.cuet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import agency.tango.materialintro.R;

/**
 * Created by Mifta on 5/13/2017.
 */

public class About extends AppCompatActivity {

    TextView Title;
    TextView Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Title=(TextView)findViewById(R.id.textView_title);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/museo_slab_500.otf");
        Title.setTypeface(font);


        Description=(TextView)findViewById(R.id.textView_description);
        Typeface fontv = Typeface.createFromAsset(getAssets(), "fonts/aller_lt.ttf");
        Description.setTypeface(fontv);

        Title.setText("CUET");
        Description.setText("Former Bangladesh Institute of Technology, Chittagong, abbreviated as BIT Chittagong is " +
                "presently Chittagong University of Engineering & Technology (CUET). It is one of the prominent and " +
                "prestigious autonomous self-degree-awarding institute in the engineering education of Bangladesh. " +
                "This Institute was created out of Engineering College, Chittagong that was established in 1968. The " +
                "Chittagong Engineering College functioned as the Faculty of Engineering of the University of Chittagong. " +
                "Through a Government ordinance in 1986, the college was converted into an Institute of Technology. In 2003 " +
                "this institute of technology was converted into a public university. The honorable President of Bangladesh " +
                "is the Chancellor of the University.\n" +
                "\n" +
                "Chittagong University Of Engineering & Technology abbreviated as CUET, is one of the prominent and " +
                "prestigious degree awarding institute in the engineering education of Bangladesh. This University was " +
                "created out of Engineering College, Chittagong, that was established in 1968. The Engineering College , " +
                "Chittagong , functioned as the Faculty of Engineering of the University of Chittagong. Though a Government " +
                "Ordinance in 1986 the college was converted into an institution (BIT, Chittagong).The honorable President " +
                "of Bangladesh is the visitor of the institute . A Board of Governors headed by a Chairman appointed by the " +
                "President is the policy making and administrative authority. There were three other similar Institutes of " +
                "Technology in the country namely BIT Khulna, BIT Rajshahi and BIT Dhaka that are converted to Khulna " +
                "University Of Engineering, Rajshashi University Of Engineering & Technology(RUET) & Technology(KUET)," +
                "Dhaka University Of Engineering & Technology(DUET)\n" +
                "\n" +
                "CUET is unique and incompatible due to its proximity to Chittagong, the major sea-port and the beautiful " +
                "Hill city of the country. The University is situated by the side of the Chittagong-Kaptai road some 25 " +
                "kilometers off from the center of Chittagong City. Moreover all the tourist attractions of the country " +
                "like the large hydroelectric plant, the natural beauty of the lake of Kaptai, hill sports of Rangamati, " +
                "Bandarban, the longest sea beach of the world and tourist resort of Cox's Bazar are only a few hours " +
                "journey.");
    }

}
