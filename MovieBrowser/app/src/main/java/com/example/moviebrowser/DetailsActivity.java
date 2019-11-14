package com.example.moviebrowser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        DetailsFragment detailsFragment = DetailsFragment.newInstance(movie);

        fts.add(R.id.container, detailsFragment);
        fts.commit();
    }
}
