package com.campusapp.cuet;

import android.content.Context;
import android.content.SharedPreferences;


/*This Is Where Shared Preferences are Crated To manage And Create Variables That will Be Used later by Differnet
Portions Of the App.*/

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE=0;

    private static final String PREF_NAME="material-intro-screen-master";

    private static final String IS_FIRST_TIME_LAUNCH="IsFirstTimeLaunch";


    //This is the Constructor of the Shared Prefrences Manager, We always need to give it which context it have to work

    public PrefManager(Context context){
        this._context = context;//getting context and setting it in a local varible
        //Creating the Prefrences in Which we have to give it a name and a value which belongs to the name
        pref=_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        //Now we are creating the editor to edit the value according to ourt need
        editor=pref.edit();


    }
    //This method is actually a default setter forr the first time the app will launch
    public void setFrstTimeLaunch(boolean isFirstTime){
        //Here we are using the editor create more prefrences
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();

    }
    //This  is getter for the object we created
    public boolean isFirstTimeLaunch(){
        //Remember that whatever will be set using the set method will be returned by this metod.
        // The given true value in return is just default in cases wgere we wont give any value to prefrences.
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH,true);
    }

}
