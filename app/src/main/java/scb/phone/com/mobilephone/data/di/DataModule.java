package scb.phone.com.mobilephone.data.di;

import dagger.Provides;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.data.network.PhoneListService;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class DataModule {

    @Provides
    PhoneListApi providePhoneListApi(final PhoneListService phoneListService){
        return new PhoneListApi(phoneListService);
    }
}
