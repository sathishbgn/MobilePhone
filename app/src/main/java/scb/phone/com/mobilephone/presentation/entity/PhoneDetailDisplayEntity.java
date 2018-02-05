package scb.phone.com.mobilephone.presentation.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jenbodint on 2/5/2018 AD.
 */

public class PhoneDetailDisplayEntity implements Parcelable {
    private List<String> imageURLs;
    private PhoneListDisplayEntity detail;

    public PhoneDetailDisplayEntity() {
    }

    protected PhoneDetailDisplayEntity(Parcel in) {
        imageURLs = in.createStringArrayList();
        detail = in.readParcelable(PhoneListDisplayEntity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(imageURLs);
        dest.writeParcelable(detail, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhoneDetailDisplayEntity> CREATOR = new Creator<PhoneDetailDisplayEntity>() {
        @Override
        public PhoneDetailDisplayEntity createFromParcel(Parcel in) {
            return new PhoneDetailDisplayEntity(in);
        }

        @Override
        public PhoneDetailDisplayEntity[] newArray(int size) {
            return new PhoneDetailDisplayEntity[size];
        }
    };

    public List<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(List<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public PhoneListDisplayEntity getDetail() {
        return detail;
    }

    public void setDetail(PhoneListDisplayEntity detail) {
        this.detail = detail;
    }


}
