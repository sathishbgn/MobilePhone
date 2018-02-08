package scb.phone.com.mobilephone.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneImageEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("mobile_id")
    private int mobileId;
    @SerializedName("url")
    private String imageURL;

    public int getId() {
        return id;
    }

    public int getMobileId() {
        return mobileId;
    }

    public String getImageURL() {
        return imageURL;
    }
}
