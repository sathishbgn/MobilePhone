package scb.phone.com.mobilephone.presentation.mapper;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import scb.phone.com.mobilephone.data.entity.PhoneListEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

/**
 * Created by sathish on 2/2/2018 AD.
 */

public class PhoneListDisplayMapper {

    private Gson gson = new Gson();

    @Inject
    public PhoneListDisplayMapper() {
    }

    public PhoneListDisplayEntity transform(PhoneListEntity entity) {
        if (entity == null) {
            return null;
        }
        return gson.fromJson(gson.toJson(entity), PhoneListDisplayEntity.class);
    }

    public List<PhoneListDisplayEntity> transform(List<PhoneListEntity> entity) {
        if (entity == null) {
            return null;
        }
        List<PhoneListDisplayEntity> listDisplayEntities = new ArrayList<>();
        List<PhoneListEntity> list = entity;
        for (PhoneListEntity item : list) {
            listDisplayEntities.add(transform(item));
        }
        return listDisplayEntities;
    }
}
