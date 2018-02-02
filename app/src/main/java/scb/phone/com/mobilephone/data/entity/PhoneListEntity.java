package scb.phone.com.mobilephone.data.entity;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneListEntity {

    @SerializedName("id")
    private int id;
    @SerializedName("thumbImageURL")
    private String thumbImageURL;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("brand")
    private String brand;
    @SerializedName("price")
    private BigDecimal price;
    @SerializedName("rating")
    private int rating;


    public int getId() {
        return id;
    }

    public String getThumbImageURL() {
        return thumbImageURL;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}
