package scb.phone.com.mobilephone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneImageEntity {

    @SerializedName("imageURLs")
    private List<String> imageURLs;

    public List<String> getImageURLs() {
        return imageURLs;
    }
}
