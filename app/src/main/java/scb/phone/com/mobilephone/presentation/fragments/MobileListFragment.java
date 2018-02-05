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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import scb.phone.com.mobilephone.R;
import scb.phone.com.mobilephone.presentation.BaseFragment;
import scb.phone.com.mobilephone.presentation.activities.MobileDetailActivity;
import scb.phone.com.mobilephone.presentation.adapter.MobileListAdapter;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;
import scb.phone.com.mobilephone.presentation.mobilelist.MobileListView;
import scb.phone.com.mobilephone.presentation.presenter.MobileListPresenter;

public class MobileListFragment extends BaseFragment implements MobileListView {

    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    @Inject
    MobileListPresenter presenter;

    FragmentInteract mFragmentInteract;

    MobileListAdapter adapter;

    List<PhoneListDisplayEntity> favoriteIds = new ArrayList<>();

    List<PhoneListDisplayEntity> displayEntityList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteract) {
            mFragmentInteract = (FragmentInteract) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mobile_list, container, false);
        ButterKnife.bind(this, view);
        presenter.setView(this);
        presenter.getPhoneList();
        return view;
    }

    @Override
    public void setMobileLists(List<PhoneListDisplayEntity> displayEntityList) {
        this.displayEntityList = displayEntityList;
        adapter = new MobileListAdapter(displayEntityList, this, favoriteIds);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void goToMobileDetail(PhoneDetailDisplayEntity entity) {
        startActivity(MobileDetailActivity.newInstance(getContext(), entity));
    }

    @Override
    public void onFavoriteClick(PhoneListDisplayEntity phoneListDisplayEntity, int position) {
        favoriteIds.add(phoneListDisplayEntity);
        adapter.notifyItemChanged(position);
        if (mFragmentInteract != null) {
            mFragmentInteract.onFavoriteClick(phoneListDisplayEntity);
        }
    }

    @Override
    public void updateMobileLists() {
        if (presenter != null) {
            presenter.getPhoneList();
        }
    }

    public void sort(Comparator<PhoneListDisplayEntity> comparator) {
        if (displayEntityList != null && adapter != null) {
            Collections.sort(displayEntityList, comparator);
            adapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public void removeFavorite(PhoneListDisplayEntity entity) {
        favoriteIds.remove(entity);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCardClick(PhoneListDisplayEntity entity) {
        if (presenter != null) {
            presenter.getPhoneImageList(entity);
        }
    }

    public interface FragmentInteract {
        void onFavoriteClick(PhoneListDisplayEntity phoneListDisplayEntity);
    }

}
