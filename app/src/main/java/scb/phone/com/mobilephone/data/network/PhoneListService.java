package scb.phone.com.mobilephone.data.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;
import scb.phone.com.mobilephone.data.entity.PhoneListEntity;

public interface PhoneListService {

    @GET("/api/mobiles/")
    Observable<List<PhoneListEntity>> getPhoneList();

    @GET("/api/mobiles/{id}/images")
    Observable<List<PhoneImageEntity>> getPhoneImageList(@Path("id") int id);
}
