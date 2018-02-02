package scb.phone.com.mobilephone.data.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import scb.phone.com.mobilephone.data.entity.PhoneEntity;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public interface PhoneListService {

    @GET("https://scb-test-mobile.herokuapp.com/mobile/")
    Observable<PhoneEntity> getPhoneList();

    @GET("https://scb-test-mobile.herokuapp.com/mobile/")
    Observable<PhoneImageEntity> getPhoneImageList(@Query("id") int id);
}
