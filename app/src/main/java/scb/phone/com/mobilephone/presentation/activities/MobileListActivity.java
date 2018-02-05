package scb.phone.com.mobilephone.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.BaseActivity;
import scb.phone.com.mobilephone.presentation.adapter.MobileListTabAdapter;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;
import scb.phone.com.mobilephone.presentation.fragments.FavoriteListFragment;
import scb.phone.com.mobilephone.presentation.fragments.MobileListFragment;
import scb.phone.com.mobilephone.presentation.presenter.MobileListPresenter;

public class MobileListActivity extends BaseActivity
        implements MobileListFragment.FragmentInteract,
        FavoriteListFragment.FragmentInterface {

    @BindView(R.id.tabs)
    protected TabLayout tabLayout;

    @BindView(R.id.view_pager)
    protected ViewPager viewPager;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    private MobileListFragment mobileListFragment;
    private FavoriteListFragment favoriteListFragment;

    private List<PhoneListDisplayEntity> displayEntityList = new ArrayList<>();

    @Inject
    MobileListPresenter presenter;

    AlertDialog dialog;
    int mMenuSortSelected = 0;

    private final Comparator<PhoneListDisplayEntity> sortAZ = (prev, next) -> prev.getPrice().compareTo(next.getPrice());
    private final Comparator<PhoneListDisplayEntity> sortZA = (prev, next) -> next.getPrice().compareTo(prev.getPrice());
    private final Comparator<PhoneListDisplayEntity> sortRating = (prev, next) -> String.valueOf(next.getRating()).compareTo(String.valueOf(prev.getRating()));

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof MobileListFragment) {
            mobileListFragment = (MobileListFragment) fragment;
        } else if (fragment instanceof FavoriteListFragment) {
            favoriteListFragment = (FavoriteListFragment) fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_list);
        ButterKnife.bind(this);
        setUpView();
    }

    private void setUpView() {
        setSupportActionBar(toolbar);

        viewPager.setAdapter(new MobileListTabAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private void showSortDialog() {
        dialog = new AlertDialog.Builder(this)
                .setSingleChoiceItems(R.array.menu_sorting, mMenuSortSelected,
                        (dialogInterface, i) -> {
                            mMenuSortSelected = i;
                            dialog.hide();
                            sort(i);
                        })
                .create();
        dialog.show();
    }

    private void sort(int sortOptions) {
        if (viewPager.getCurrentItem() == 1) {
            if (sortOptions == 1) {
                favoriteListFragment.sort(sortZA);
            } else if (sortOptions == 2) {
                favoriteListFragment.sort(sortRating);
            } else {
                favoriteListFragment.sort(sortAZ);
            }
        } else {

            if (sortOptions == 1) {
                mobileListFragment.sort(sortZA);
            } else if (sortOptions == 2) {
                mobileListFragment.sort(sortRating);
            } else {
                mobileListFragment.sort(sortAZ);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort:
                showSortDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFavoriteClick(PhoneListDisplayEntity phoneListDisplayEntity) {
        Toast.makeText(this, String.format("You have added %s to favorite list", phoneListDisplayEntity.getName()), Toast.LENGTH_SHORT).show();
        viewPager.setCurrentItem(1);
        displayEntityList.add(phoneListDisplayEntity);
        if (favoriteListFragment != null) {
            favoriteListFragment.updateList();
        }
    }

    /**
     * to able to send value back to FavoriteFragment
     * @return
     */
    @Override
    public List<PhoneListDisplayEntity> getList() {
        return displayEntityList;
    }
}
