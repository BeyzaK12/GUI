package com.example.moviebrowser;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements MovieFragment.OnMovieSelectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void movieSelected(Movie item) {

        int display_mode = getResources().getConfiguration().orientation;
        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("movie", item);
            startActivity(intent);
        } else {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentByTag("details");
            if (detailsFragment == null) {
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                detailsFragment = DetailsFragment.newInstance(item);
                fts.add(R.id.container, detailsFragment, "details");
                fts.commit();
            } else {
                detailsFragment.setMovie(item, findViewById(R.id.container));
            }
        }

    }
}
