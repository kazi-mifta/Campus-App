package com.campusapp.cuet;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import agency.tango.materialintro.R;

public class Contributors extends Activity {

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));
        persons.add(new Person("Unkonwn CUETIAN", "INSIDER BUild", R.drawable.cuet_logo));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
