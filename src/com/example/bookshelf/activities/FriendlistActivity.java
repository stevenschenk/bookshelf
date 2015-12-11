package com.example.bookshelf.activities;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import com.example.BookShelf.R;
import com.example.bookshelf.adapters.FriendViewAdapter;
import com.example.bookshelf.model.SaveSharedPreference;




/**
 * Created by Steven on 13-6-2015.
 */
public class FriendlistActivity extends FragmentActivity {
    FriendViewAdapter adapter;
    ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Instantiate objects
        pager = new ViewPager(this);
        adapter = new FriendViewAdapter(getSupportFragmentManager(), this);

        //Set the actionbar details
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(SaveSharedPreference.getFirstName(FriendlistActivity.this).substring(0, 1).toUpperCase() +
                SaveSharedPreference.getFirstName(FriendlistActivity.this).substring(1) + getString(R.string.friendlist_postfix));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(199, 92, 92)));
        actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        //Pager must have an id
        pager.setId(1);

        //Make new PagerTabStrip (tabs in actionbar)
        PagerTabStrip strip = new PagerTabStrip(this);
        strip.setTabIndicatorColor(Color.WHITE);
        strip.setBackgroundDrawable(new ColorDrawable(Color.rgb(199, 92, 92)));

        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.height = ViewPager.LayoutParams.WRAP_CONTENT;
        layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.TOP;

        // Add PagerTabStrip to view
        pager.addView(strip, layoutParams);

        //Only load current screen
        pager.setOffscreenPageLimit(0);

        //Set adapter to view
        pager.setAdapter(adapter);


        //Show content
        setContentView(pager);
    }
}
