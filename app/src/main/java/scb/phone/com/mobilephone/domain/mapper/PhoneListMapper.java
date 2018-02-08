package scb.phone.com.mobilephone.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

public class PhoneListMapper {

    private PhoneListDisplayEntity phoneListDisplayEntity;

    @Inject
    public PhoneListMapper() {
    }

    public PhoneDetailDisplayEntity transform(PhoneListDisplayEntity phoneListDisplayEntity, List<PhoneImageEntity> phoneImageEntities) {
        this.phoneListDisplayEntity = phoneListDisplayEntity;
        if (phoneImageEntities == null) {
            return null;
        }

        List<Integer> id = new ArrayList<>(phoneImageEntities.size());
        List<Integer> mobileId = new ArrayList<>(phoneImageEntities.size());
        List<String> imageURL = new ArrayList<>(phoneImageEntities.size());
        for (PhoneImageEntity phoneImageEntity:phoneImageEntities) {
            id.add(phoneImageEntity.getId());
            mobileId.add(phoneImageEntity.getMobileId());
            imageURL.add(phoneImageEntity.getImageURL());
        }
        return new PhoneDetailDisplayEntity(id, mobileId, imageURL, phoneListDisplayEntity);

    }
}
