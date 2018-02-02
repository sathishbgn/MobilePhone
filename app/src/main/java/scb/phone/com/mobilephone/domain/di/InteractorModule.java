package scb.phone.com.mobilephone.domain.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Provides;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.domain.ThreadExecutor;
import scb.phone.com.mobilephone.domain.mapper.PhoneListMapper;
import scb.phone.com.mobilephone.domain.usecase.PhoneCase;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class InteractorModule {

    @Provides
    @Singleton
    PhoneCase providePhoneCase(@Named("subscriberOn") final ThreadExecutor subscriberOn,
            @Named("observerOn") final ThreadExecutor observerOn, final PhoneListApi phoneListApi,
            PhoneListMapper phoneListMapper) {
        return new PhoneCase(subscriberOn, observerOn, phoneListApi, phoneListMapper);
    }
}
