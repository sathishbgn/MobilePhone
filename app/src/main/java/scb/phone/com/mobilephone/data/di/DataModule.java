package scb.phone.com.mobilephone.data.di;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import scb.phone.com.mobilephone.data.network.PhoneListApi;
import scb.phone.com.mobilephone.data.network.PhoneListService;
import scb.phone.com.mobilephone.domain.mapper.PhoneListMapper;
import scb.phone.com.mobilephone.presentation.mapper.PhoneListDisplayMapper;

@Module
public class DataModule {

    @Inject
    PhoneListService phoneListService;

    @Provides
    PhoneListApi providePhoneListApi(final PhoneListService phoneListService) {
        return new PhoneListApi(phoneListService);
    }

    @Provides
    PhoneListService providePhoneListService(Retrofit retrofit) {
        return createService(retrofit, PhoneListService.class);
    }

    @Provides
    PhoneListMapper providePhoneListMapper() {
        return new PhoneListMapper();
    }

    @Provides
    PhoneListDisplayMapper providePhoneListDisplayMapper() {
        return new PhoneListDisplayMapper();
    }
    
    @Provides
    @Singleton
    Retrofit buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://scb-jenbodin.firebaseapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    private <S> S createService(Retrofit retrofit, Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
