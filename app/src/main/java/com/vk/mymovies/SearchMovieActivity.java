package com.vk.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.vk.mymovies.adapters.FindMovieAutoCompleteAdapter;
import com.vk.mymovies.data.Movie;
import com.vk.mymovies.utils.DelayAutoCompleteTextView;


public class SearchMovieActivity extends AppCompatActivity {

    private static String lang;
    private DelayAutoCompleteTextView delayAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_movie);
        delayAutoCompleteTextView = (DelayAutoCompleteTextView) findViewById(R.id.delayAutoCompleteTextView);
        delayAutoCompleteTextView.setThreshold(4);
        delayAutoCompleteTextView.setAdapter(new FindMovieAutoCompleteAdapter(getApplicationContext()));
        delayAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie = (Movie) adapterView.getItemAtPosition(position);
                delayAutoCompleteTextView.setText(movie.getTitle());
            }
        });

    }


}
