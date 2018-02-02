package scb.phone.com.mobilephone.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.domain.ThreadExecutor;
import scb.phone.com.mobilephone.domain.enity.PhoneListDomain;
import scb.phone.com.mobilephone.domain.mapper.PhoneListMapper;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneCase extends BaseInteractor {

    private PhoneListApi phoneListApi;
    private PhoneListMapper phoneListMapper;

    @Inject
    public PhoneCase(ThreadExecutor subscriberOn, ThreadExecutor observerOn, PhoneListApi phoneListApi,
            PhoneListMapper phoneListMapper) {
        super(subscriberOn, observerOn);
        this.phoneListApi = phoneListApi;
        this.phoneListMapper = phoneListMapper;
    }


    public Observable<PhoneListDomain> getPhoneList() {
        return withObservable(phoneListApi.getPhoneList().flatMap(phoneEntity ->
                Observable.just(phoneListMapper.transform(phoneEntity))));
    }

    public Observable<PhoneListDomain> getPhoneImageList(int id) {
        return withObservable(phoneListApi.getPhoneImageUrl(id).flatMap(phoneImageEntity ->
                Observable.just(phoneListMapper.transform(phoneImageEntity))));
    }
}
