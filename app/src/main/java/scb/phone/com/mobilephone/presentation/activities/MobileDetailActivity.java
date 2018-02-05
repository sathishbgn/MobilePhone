package scb.phone.com.mobilephone.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.adapter.ImageSlideAdapter;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;

public class MobileDetailActivity extends AppCompatActivity {

    public static final String PHONE_LIST_DISPLAY = "PHONE_LIST_DISPLAY";

    @BindView(R.id.view_pager)
    protected ViewPager viewPager;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.tv_title)
    protected TextView tvTitle;

    @BindView(R.id.tv_brand)
    protected TextView tvBrand;

    @BindView(R.id.tv_description)
    protected TextView tvDescription;

    public static Intent newInstance(Context context, PhoneDetailDisplayEntity entity) {
        Intent intent = new Intent(context, MobileDetailActivity.class);
        intent.putExtra(PHONE_LIST_DISPLAY, entity);
        return intent;
    }

    public MobileDetailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_detail);
        ButterKnife.bind(this);
        setUpView();
    }

    private void setUpView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PhoneDetailDisplayEntity entity = getIntent().getParcelableExtra(PHONE_LIST_DISPLAY);
        tvTitle.setText(entity.getDetail().getName());
        tvBrand.setText(entity.getDetail().getBrand());
        tvDescription.setText(entity.getDetail().getDescription());
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new ImageSlideAdapter(entity));
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
