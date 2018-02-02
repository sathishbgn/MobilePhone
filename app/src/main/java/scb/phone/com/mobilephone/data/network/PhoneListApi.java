package scb.phone.com.mobilephone.data.network;


import javax.inject.Inject;

import io.reactivex.Observable;
import scb.phone.com.mobilephone.data.entity.PhoneEntity;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneListApi {

    private PhoneListService phoneListService;

    @Inject
    public PhoneListApi(PhoneListService phoneListService) {
        this.phoneListService = phoneListService;
    }

    public Observable<PhoneEntity> getPhoneList() {
        return phoneListService.getPhoneList();
    }

    public Observable<PhoneImageEntity> getPhoneImageUrl(int id) {
        return phoneListService.getPhoneImageList(id);
    }
}
