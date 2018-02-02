package scb.phone.com.mobilephone.domain.mapper;

import scb.phone.com.mobilephone.data.entity.PhoneEntity;
import scb.phone.com.mobilephone.data.entity.PhoneImageEntity;
import scb.phone.com.mobilephone.domain.enity.PhoneListDomain;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class PhoneListMapper {

    public PhoneListDomain transform(PhoneEntity phoneListEntity) {
        return new PhoneListDomain();
    }

    public PhoneListDomain transform(PhoneImageEntity phoneImageEntity) {
        return new PhoneListDomain();
    }
}
