package scb.phone.com.mobilephone.domain.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.domain.ThreadExecutor;
import scb.phone.com.mobilephone.domain.mapper.PhoneListMapper;
import scb.phone.com.mobilephone.domain.usecase.PhoneCase;
import scb.phone.com.mobilephone.presentation.mapper.PhoneListDisplayMapper;

@Module
public class InteractorModule {

    @Provides
    @Singleton
    PhoneCase providePhoneCase(@Named("subscriberOn") final ThreadExecutor subscriberOn,
                               @Named("observerOn") final ThreadExecutor observerOn, final PhoneListApi phoneListApi,
                               PhoneListMapper phoneListMapper,
                               PhoneListDisplayMapper phoneListDisplayMapper) {
        return new PhoneCase(subscriberOn, observerOn, phoneListApi, phoneListMapper, phoneListDisplayMapper);
    }
}
