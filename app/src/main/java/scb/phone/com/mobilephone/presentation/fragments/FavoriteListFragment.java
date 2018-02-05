package scb.phone.com.mobilephone.presentation.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.BaseFragment;
import scb.phone.com.mobilephone.presentation.adapter.FavoriteListAdapter;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class FavoriteListFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;
    List<PhoneListDisplayEntity> displayEntityList = new ArrayList<>();
    FavoriteListAdapter mAdapter;
    FragmentInterface mFragmentInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        ButterKnife.bind(this, view);
        setFavoriteList();
        return view;
    }

    public void setFavoriteList() {
        mAdapter = new FavoriteListAdapter(displayEntityList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
    }

    public void updateList() {
        if (mFragmentInterface != null) {
            displayEntityList = mFragmentInterface.getList();
            setFavoriteList();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            mFragmentInterface = (FragmentInterface) context;
        }
    }

    public void sort(Comparator<PhoneListDisplayEntity> comparator) {
        if (displayEntityList != null && mAdapter != null) {
            Collections.sort(displayEntityList, comparator);
            mAdapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public interface FragmentInterface {
        List<PhoneListDisplayEntity> getList();

    }

}
