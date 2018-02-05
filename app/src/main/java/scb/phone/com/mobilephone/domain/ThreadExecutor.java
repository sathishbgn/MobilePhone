package scb.phone.com.mobilephone.domain;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.Scheduler;

public class ThreadExecutor {

    private Scheduler scheduler;

    public ThreadExecutor(final Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
