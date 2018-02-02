package scb.phone.com.mobilephone.presentation.mobilelist;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import scb.phone.com.mobilephone.R;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class MobileListActivity extends AppCompatActivity {


    @BindView(R.id.view_pager)
    protected ViewPager viewPager;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
