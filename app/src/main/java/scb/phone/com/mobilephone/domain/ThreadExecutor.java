package scb.phone.com.mobilephone.domain;

import io.reactivex.Scheduler;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class ThreadExecutor {

    private Scheduler scheduler;

    public ThreadExecutor(final Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }
}
