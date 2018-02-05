package scb.phone.com.mobilephone.di;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import scb.phone.com.mobilephone.MobileApplication;
import scb.phone.com.mobilephone.domain.ThreadExecutor;

@Module
public class ApplicationModule {

    // Resources provide

    @Provides
    @Singleton
    Context provideContext(MobileApplication application) {
        return application;
    }

    @Provides
    Resources provideResources(Context context) {
        return context.getResources();
    }

    @Provides
    AssetManager provideAssets(Context context) {
        return context.getAssets();
    }

    @Provides
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Named("fileDir")
    File provideFileDir(Context context) {
        return context.getFilesDir();
    }

    @Provides
    @Named("externalStorage")
    File provideExternalStorageDir(Context context) {
        return new File(Environment.getExternalStorageDirectory(), "SCB");
    }

    // ThreadExecutor provide
    @Provides
    @Singleton
    @Named("subscriberOn")
    ThreadExecutor provideSubscriberOnThreadExecutor() {
        return new ThreadExecutor(Schedulers.newThread());
    }

    @Provides
    @Singleton
    @Named("observerOn")
    ThreadExecutor provideObserverOnExecutionThread() {
        return new ThreadExecutor(AndroidSchedulers.mainThread());
    }
}
