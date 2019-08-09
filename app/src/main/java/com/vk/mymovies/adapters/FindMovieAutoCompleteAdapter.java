package com.vk.mymovies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.vk.mymovies.R;
import com.vk.mymovies.data.Movie;
import com.vk.mymovies.utils.FindMovieService;

import java.util.ArrayList;
import java.util.List;

public class FindMovieAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;

    private final Context mContext;
    private List<Movie> mResults;

    public FindMovieAutoCompleteAdapter(Context context) {
        mContext = context;
        mResults = new ArrayList<Movie>();
    }

    @Override
    public int getCount() {
        return mResults.size();;
    }

    @Override
    public Object getItem(int i) {
        return mResults.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.move_find, parent, false);
        }
        Movie movie = (Movie) getItem(position);
        ((TextView) convertView.findViewById(R.id.textMovieTitle)).setText(movie.getTitle());
        ((TextView) convertView.findViewById(R.id.textMovieTitle2)).setText(movie.getReleaseDate());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<Movie> movies = findMovies(constraint.toString());
                    // Assign the data to the FilterResults
                    filterResults.values = movies;
                    filterResults.count = movies.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    mResults = (List<Movie>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};

        return filter;
    }

    /**
     * Returns a search result for the given book title.
     */
    private List<Movie> findMovies(String movieTitle) {
        // GoogleBooksService is a wrapper for the Google Books API
        FindMovieService service = new FindMovieService (mContext, MAX_RESULTS);
        return service.findMovies(movieTitle);
    }
    }

