package scb.phone.com.mobilephone.presentation.presenter;

import java.util.List;

import javax.inject.Inject;

import scb.phone.com.mobilephone.domain.usecase.BaseInteractor;
import scb.phone.com.mobilephone.domain.usecase.PhoneCase;
import scb.phone.com.mobilephone.presentation.BasePresenter;
import scb.phone.com.mobilephone.presentation.entity.PhoneDetailDisplayEntity;
import scb.phone.com.mobilephone.presentation.entity.PhoneListDisplayEntity;
import scb.phone.com.mobilephone.presentation.mapper.PhoneListDisplayMapper;
import scb.phone.com.mobilephone.presentation.mobilelist.MobileListView;

public class MobileListPresenter extends BasePresenter<MobileListView> {

    private PhoneCase phoneCase;
    private PhoneListDisplayMapper phoneListDisplayMapper;

    @Inject
    public MobileListPresenter(PhoneCase phoneCase, PhoneListDisplayMapper phoneListDisplayMapper) {
        this.phoneCase = phoneCase;
        this.phoneListDisplayMapper = phoneListDisplayMapper;
    }

    public void getPhoneList() {
        phoneCase.getPhoneList();
        phoneCase.execute(new GetPhoneList());
    }

    public void getPhoneImageList(PhoneListDisplayEntity entity) {
        phoneCase.getPhoneImageList(entity);
        phoneCase.execute(new GetPhoneImageList());
    }

    private class GetPhoneList extends BaseInteractor.Subscriber<List<PhoneListDisplayEntity>> {

        public GetPhoneList() {
            showLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            hideLoading();
        }

        @Override
        public void onNext(List<PhoneListDisplayEntity> phoneEntity) {
            super.onNext(phoneEntity);
            doInView(view -> view.setMobileLists(phoneEntity));
        }

        @Override
        public void onComplete() {
            super.onComplete();
            hideLoading();
        }
    }

    private class GetPhoneImageList extends BaseInteractor.Subscriber<PhoneDetailDisplayEntity> {

        public GetPhoneImageList() {
            showLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            hideLoading();
        }

        @Override
        public void onNext(PhoneDetailDisplayEntity entity) {
            super.onNext(entity);
            doInView(view -> view.goToMobileDetail(entity));
        }

        @Override
        public void onComplete() {
            super.onComplete();
            hideLoading();
        }
    }

}
