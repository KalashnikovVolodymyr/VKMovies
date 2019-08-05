package com.vk.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.Locale;

public class SearchMovieActivity extends AppCompatActivity {

    private static String lang;
    private AutoCompleteTextView autoCompleteTextView;
    private String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain", "Spanish"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("lang")) {
            lang = intent.getStringExtra("lang");
        } else {
            lang = Locale.getDefault().getLanguage();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        autoCompleteTextView.setAdapter(adapter);
    }


}
