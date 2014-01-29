package com.pineappslab.frcontainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

/**
 * Example about replacing fragments inside a ViewPager. I'm using
 * android-support-v7 to maximize the compatibility.
 * 
 * @author Dani Lao (@dani_lao)
 * 
 */
public class MainActivity extends ActionBarActivity {

	// For this example, only two pages
	static final int NUM_ITEMS = 2;

	ViewPager mPager;
	SlidePagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* Instantiate a ViewPager and a PagerAdapter. */
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);

	}

	/* PagerAdapter class */
	public class SlidePagerAdapter extends FragmentPagerAdapter {
		public SlidePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			/*
			 * IMPORTANT: This is the point. We create a RootFragment acting as
			 * a container for other fragments
			 */
			if (position == 0)
				return new RootFragment();
			else
				return new StaticFragment();
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}
	}

}
