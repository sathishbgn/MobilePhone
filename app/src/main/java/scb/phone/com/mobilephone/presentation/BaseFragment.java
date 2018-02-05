package scb.phone.com.mobilephone.presentation;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import dagger.android.support.AndroidSupportInjection;

public class BaseFragment extends Fragment implements BaseView {

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {
        if(isAdded()) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if(isAdded()) {
            if (progressDialog != null) {
                progressDialog.hide();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
