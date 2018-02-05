package scb.phone.com.mobilephone.presentation.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

/**
 * Created by sathish on 2/2/2018 AD.
 */

public class PhoneListDisplayEntity implements Parcelable {

    private int id;

    private String thumbImageURL;

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private int rating;

    public PhoneListDisplayEntity() {

    }

    protected PhoneListDisplayEntity(Parcel in) {
        id = in.readInt();
        thumbImageURL = in.readString();
        name = in.readString();
        description = in.readString();
        brand = in.readString();
        price = new BigDecimal(in.readString());
        rating = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(thumbImageURL);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(brand);
        dest.writeString(price.toString());
        dest.writeInt(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhoneListDisplayEntity> CREATOR = new Creator<PhoneListDisplayEntity>() {
        @Override
        public PhoneListDisplayEntity createFromParcel(Parcel in) {
            return new PhoneListDisplayEntity(in);
        }

        @Override
        public PhoneListDisplayEntity[] newArray(int size) {
            return new PhoneListDisplayEntity[size];
        }
    };

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneListDisplayEntity entity = (PhoneListDisplayEntity) o;

        if (id != entity.id) return false;
        if (rating != entity.rating) return false;
        if (thumbImageURL != null ? !thumbImageURL.equals(entity.thumbImageURL) : entity.thumbImageURL != null)
            return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null)
            return false;
        if (brand != null ? !brand.equals(entity.brand) : entity.brand != null) return false;
        return price != null ? price.equals(entity.price) : entity.price == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (thumbImageURL != null ? thumbImageURL.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }
}
