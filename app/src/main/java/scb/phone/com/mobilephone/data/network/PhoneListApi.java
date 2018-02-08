package scb.phone.com.mobilephone.data.network;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;
import scb.phone.com.mobilephone.data.entity.PhoneListEntity;

public class PhoneListApi {

    private PhoneListService phoneListService;

    @Inject
    public PhoneListApi(PhoneListService phoneListService) {
        this.phoneListService = phoneListService;
    }

    public Observable<List<PhoneListEntity>> getPhoneList() {
        return phoneListService.getPhoneList();
    }

    public Observable<List<PhoneImageEntity>> getPhoneImageUrl(int id) {
        return phoneListService.getPhoneImageList(id);
    }
}
