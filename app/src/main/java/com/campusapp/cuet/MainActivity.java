package com.campusapp.cuet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.materialize.util.UIUtils;


import agency.tango.materialintro.R;

/*The main Scrren which will be shown when app will be Started Everythime except First Time. Here it is AppCompatActivity
*which will ceate A view which Has top navigation Bar in it. Here The Crossfade Drawer Library Is Used.Github Has a
* Lot OF details about This Library Too.
*/
public class  MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    AppCompatButton button;

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    private CrossfadeDrawerLayout crossfadeDrawerLayout = null;
    public static String Namemain;
    public static String IDmain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting Name And ID For The Header Section
       // Namemain= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name", "Name");
        //IDmain=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("ID", "ID");


        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CUET");





        // Create a few sample profile
        // NOTE you have to define the loader logic too. See the CustomApplication for more details
        final IProfile profile = new ProfileDrawerItem().withIcon(R.drawable.profile3);
        // Create the AccountHeader Section
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        profile
                )
                .withSavedInstance(savedInstanceState)
                .build();
        //Creating The MAin Drawer Where Everything Will Reside.
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withDrawerLayout(R.layout.crossfade_drawer)
                .withDrawerWidthDp(72)
                .withGenerateMiniDrawer(true)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Campus").withIcon(GoogleMaterial.Icon.gmd_landscape).withIconColor(Color.DKGRAY).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Updates").withIcon(GoogleMaterial.Icon.gmd_dashboard).withIconColor(Color.DKGRAY).withIdentifier(2).withSelectable(false),
                        new PrimaryDrawerItem().withName("Calendar").withIcon(FontAwesome.Icon.faw_calendar_check_o).withIconColor(Color.DKGRAY).withIdentifier(3).withSelectable(false),
                        new PrimaryDrawerItem().withName("Cloud").withIcon(GoogleMaterial.Icon.gmd_cloud_download).withIconColor(Color.DKGRAY).withIdentifier(4).withSelectable(false),
                        new PrimaryDrawerItem().withName("Photography").withIcon(GoogleMaterial.Icon.gmd_burst_mode).withIconColor(Color.DKGRAY).withIdentifier(5).withSelectable(false),
                        new SectionDrawerItem().withName("Help Section"),
                        new SecondaryDrawerItem().withName("Geeks").withIcon(FontAwesome.Icon.faw_pied_piper).withIconColor(Color.DKGRAY).withIdentifier(6).withSelectable(false),
                        new SecondaryDrawerItem().withName("Map").withIcon(FontAwesome.Icon.faw_map).withIconColor(Color.DKGRAY).withIdentifier(7).withSelectable(false),
                        new SectionDrawerItem().withName("Others"),
                        new SecondaryDrawerItem().withName("Contributors").withIcon(GoogleMaterial.Icon.gmd_assignment_ind).withIconColor(Color.DKGRAY).withIdentifier(8),
                        new SecondaryDrawerItem().withName("About").withIcon(GoogleMaterial.Icon.gmd_description).withIconColor(Color.DKGRAY).withIdentifier(9)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            //Things That Will Happen When Clicked on Drawer Items
                            if (drawerItem.getIdentifier() == 1) {
                                Toast.makeText(MainActivity.this, "You Are In The Digital Campus Of CUET", Toast.LENGTH_SHORT).show();
                            } else if (drawerItem.getIdentifier() == 2) {
                                Intent intent = new Intent(MainActivity.this, CampusWebView.class);
                                startActivity(intent);
                            } else if (drawerItem.getIdentifier() == 3) {
                                Intent intent = new Intent(MainActivity.this, CalendarWebView.class);
                                startActivity(intent);
                            }else if (drawerItem.getIdentifier() == 4) {
                                Intent intent = new Intent(MainActivity.this, CloudWebView.class);
                                startActivity(intent);
                            }else if (drawerItem.getIdentifier() == 5) {
                                Intent intent = new Intent(MainActivity.this, PhotographyWebView.class);
                                startActivity(intent);
                            } else if (drawerItem.getIdentifier() == 6) {
                                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                                startActivity(intent);
                            }else if (drawerItem.getIdentifier() == 7) {
                                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                                startActivity(intent);
                            }
                        }
                        //we do not consume the event and want the Drawer to continue with the event chain
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(false)
                .build();


        //get the CrossfadeDrawerLayout which will be used as alternative DrawerLayout for the Drawer
        //the CrossfadeDrawerLayout library can be found here: https://github.com/mikepenz/CrossfadeDrawerLayout
        crossfadeDrawerLayout = (CrossfadeDrawerLayout) result.getDrawerLayout();
        //define maxDrawerWidth
        crossfadeDrawerLayout.setMaxWidthPx(DrawerUIUtils.getOptimalDrawerWidth(this));
        //add second view (which is the miniDrawer)
        final MiniDrawer miniResult = result.getMiniDrawer();
        //build the view for the MiniDrawer
        View view = miniResult.build(this);
        //set the background of the MiniDrawer as this would be transparent
        view.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(this, com.mikepenz.materialdrawer.R.attr.material_drawer_background, com.mikepenz.materialdrawer.R.color.material_drawer_background));
        //we do not have the MiniDrawer view during CrossfadeDrawerLayout creation so we will add it here
        crossfadeDrawerLayout.getSmallView().addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
        miniResult.withCrossFader(new ICrossfader() {
            @Override
            public void crossfade() {
                boolean isFaded = isCrossfaded();
                crossfadeDrawerLayout.crossfade(400);

                //only close the drawer if we were already faded and want to close it now
                if (isFaded) {
                    result.getDrawerLayout().closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public boolean isCrossfaded() {
                return crossfadeDrawerLayout.isCrossfaded();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Intro) {
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            //At the Moment Of Creation We are callling the Intent To start a Activity in Intro Activity Class
            startActivity(intent);
        }
        if(id == R.id.Push){
            String token = FirebaseInstanceId.getInstance().getToken();
            Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

}
