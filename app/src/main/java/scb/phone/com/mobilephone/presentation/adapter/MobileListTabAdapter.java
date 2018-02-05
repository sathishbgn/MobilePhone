package scb.phone.com.mobilephone.presentation.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.fragments.FavoriteListFragment;
import scb.phone.com.mobilephone.presentation.fragments.MobileListFragment;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class MobileListTabAdapter extends FragmentStatePagerAdapter {

    private int[] titleTabs = {
            R.string.tab_mobile_list,
            R.string.tab_favorite_list
    };

    private static final int MOBILE_LIST = 0;
    private static final int FAVORITE_LIST = 1;
    private Context context;

    public MobileListTabAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MOBILE_LIST:
                return new MobileListFragment();
            case FAVORITE_LIST:
                return new FavoriteListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titleTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(titleTabs[position]);
    }

}
