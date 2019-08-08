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
            convertView = inflater.inflate(R.layout.trailer_item, parent, false);
        }
        Movie movie = (Movie) getItem(position);
        ((TextView) convertView.findViewById(R.layout.id.text1)).setText(book.getTitle());
        ((TextView) convertView.findViewById(R.id.text2)).setText(book.getAuthor());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
