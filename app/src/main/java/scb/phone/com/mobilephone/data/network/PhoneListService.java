package scb.phone.com.mobilephone.data.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import scb.phone.com.mobilephone.data.entity.PhoneEntity;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;

public interface PhoneListService {

    @GET("/public/list.json")
    Observable<PhoneEntity> getPhoneList();

    @GET("/public/detail.json")
    Observable<PhoneImageEntity> getPhoneImageList(@Query("id") int id);
}
