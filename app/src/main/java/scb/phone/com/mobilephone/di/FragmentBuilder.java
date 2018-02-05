package scb.phone.com.mobilephone.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import scb.phone.com.mobilephone.presentation.BaseFragment;
import scb.phone.com.mobilephone.presentation.fragments.FavoriteListFragment;
import scb.phone.com.mobilephone.presentation.fragments.MobileListFragment;

@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract BaseFragment bindBaseFragment();
    @ContributesAndroidInjector
    abstract MobileListFragment bindMobileListFragment();
    @ContributesAndroidInjector
    abstract FavoriteListFragment bindFavoriteListFragment();
}
