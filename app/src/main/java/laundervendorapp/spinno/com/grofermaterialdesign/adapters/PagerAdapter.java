package laundervendorapp.spinno.com.grofermaterialdesign.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.SparseArrayCompat;

import laundervendorapp.spinno.com.grofermaterialdesign.customview.playstandclasses.ScrollTabHolder;
import laundervendorapp.spinno.com.grofermaterialdesign.customview.playstandclasses.ScrollTabHolderFragment;
import laundervendorapp.spinno.com.grofermaterialdesign.fragments.ScrollViewFragment;

/**
 * Created by spinnosolutions on 9/30/15.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    private SparseArrayCompat<ScrollTabHolder> mScrollTabHolders;
    private final String[] TITLES = { "Fruits", "Veges", "Body Care", "Pet Care", "Baby care", "Audio"};
    private ScrollTabHolder mListener;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        mScrollTabHolders = new SparseArrayCompat<ScrollTabHolder>();
    }

    public void setTabHolderScrollingContent(ScrollTabHolder listener) {
        mListener = listener;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        ScrollTabHolderFragment fragment = (ScrollTabHolderFragment) ScrollViewFragment.newInstance(position);
        mScrollTabHolders.put(position, fragment);
        if (mListener != null) {
            fragment.setScrollTabHolder(mListener);
        }
        return fragment;
    }

    public SparseArrayCompat<ScrollTabHolder> getScrollTabHolders() {
        return mScrollTabHolders;
    }

}