package scb.phone.com.mobilephone.presentation.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jenbodint on 2/5/2018 AD.
 */

public class PhoneDetailDisplayEntity implements Parcelable {

    private List<Integer> id;
    private List<Integer> mobileId;
    private List<String> imageURL;
    private PhoneListDisplayEntity detail;

    public PhoneDetailDisplayEntity(List<Integer> id, List<Integer> mobileId, List<String> imageURL, PhoneListDisplayEntity detail) {
        this.id = id;
        this.mobileId = mobileId;
        this.imageURL = imageURL;
        this.detail = detail;
    }

    protected PhoneDetailDisplayEntity(Parcel in) {
        id = in.readArrayList(Integer.class.getClassLoader());
        mobileId = in.readArrayList(Integer.class.getClassLoader());
        imageURL = in.createStringArrayList();
        detail = in.readParcelable(PhoneListDisplayEntity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(id);
        dest.writeList(mobileId);
        dest.writeStringList(imageURL);
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

    public List<Integer> getId() {
        return id;
    }

    public List<Integer> getMobileId() {
        return mobileId;
    }

    public List<String> getImageURL() {
        return imageURL;
    }

    public PhoneListDisplayEntity getDetail() {
        return detail;
    }
}
