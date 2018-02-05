package scb.phone.com.mobilephone.domain.mapper;

import java.util.List;

import javax.inject.Inject;

import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

public class PhoneListMapper {

    @Inject
    public PhoneListMapper() {
    }

    public PhoneDetailDisplayEntity transform(PhoneListDisplayEntity entity, List<String> imageURLs) {
        PhoneDetailDisplayEntity detailEntity = new PhoneDetailDisplayEntity();
        detailEntity.setDetail(entity);
        detailEntity.setImageURLs(imageURLs);
        return detailEntity;
    }
}
