package scb.phone.com.mobilephone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneEntity {

    @SerializedName("phoneListEntities")
    private List<PhoneListEntity> phoneListEntities;

    public List<PhoneListEntity> getPhoneListEntities() {
        return phoneListEntities;
    }
}
