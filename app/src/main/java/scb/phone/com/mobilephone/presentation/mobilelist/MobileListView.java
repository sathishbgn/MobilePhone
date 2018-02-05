package scb.phone.com.mobilephone.presentation.mobilelist;

import java.util.List;

import scb.phone.com.mobilephone.presentation.BaseView;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;

public interface MobileListView extends BaseView {
    void updateMobileLists();
    void onCardClick(PhoneListDisplayEntity entity);
    void setMobileLists(List<PhoneListDisplayEntity> displayEntityList);
    void goToMobileDetail(PhoneDetailDisplayEntity entity);
    void onFavoriteClick(PhoneListDisplayEntity phoneListDisplayEntity, int position);
}
