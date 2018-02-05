package scb.phone.com.mobilephone.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import scb.phone.com.mobilephone.MobileApplication;
import scb.phone.com.mobilephone.data.di.DataModule;
import scb.phone.com.mobilephone.domain.di.InteractorModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class,
        InteractorModule.class,
        DataModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(MobileApplication application);
        ApplicationComponent build();
    }

    // Application
    void inject(MobileApplication mobileApplication);

}
