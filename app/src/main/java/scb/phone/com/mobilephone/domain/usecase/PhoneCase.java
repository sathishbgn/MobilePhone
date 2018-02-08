package scb.phone.com.mobilephone.domain.usecase;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.domain.ThreadExecutor;
import scb.phone.com.mobilephone.domain.mapper.PhoneListMapper;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;
import scb.phone.com.mobilephone.presentation.mapper.PhoneListDisplayMapper;

public class PhoneCase extends BaseInteractor {

    private PhoneListApi phoneListApi;
    private PhoneListMapper phoneListMapper;
    private PhoneListDisplayMapper phoneListDisplayMapper;

    @Inject
    public PhoneCase(ThreadExecutor subscriberOn, ThreadExecutor observerOn, PhoneListApi phoneListApi,
                     PhoneListMapper phoneListMapper, PhoneListDisplayMapper phoneListDisplayMapper) {
        super(subscriberOn, observerOn);
        this.phoneListApi = phoneListApi;
        this.phoneListMapper = phoneListMapper;
        this.phoneListDisplayMapper = phoneListDisplayMapper;
    }


    public Observable<List<PhoneListDisplayEntity>> getPhoneList() {
        Log.d("log", "getPhoneList");
        return withObservable(phoneListApi.getPhoneList().flatMap(phoneEntity ->
                Observable.just(phoneListDisplayMapper.transform(phoneEntity))));
    }

    public Observable<PhoneDetailDisplayEntity> getPhoneImageList(PhoneListDisplayEntity entity) {
        Log.d("log", "getPhoneImageList" + entity);
        return withObservable(phoneListApi.getPhoneImageUrl(entity.getId()).flatMap(phoneImageEntity ->
                Observable.just(phoneListMapper.transform(entity, phoneImageEntity))));
    }
}
