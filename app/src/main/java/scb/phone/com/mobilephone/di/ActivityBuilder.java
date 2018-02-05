package scb.phone.com.mobilephone.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import scb.phone.com.mobilephone.presentation.BaseActivity;
import scb.phone.com.mobilephone.presentation.activities.MobileDetailActivity;
import scb.phone.com.mobilephone.presentation.activities.MobileListActivity;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MobileListActivity bindMobileListActivity();
    @ContributesAndroidInjector
    abstract BaseActivity bindBaseActivity();
    @ContributesAndroidInjector
    abstract MobileDetailActivity bindMobileDetailActivity();
}
