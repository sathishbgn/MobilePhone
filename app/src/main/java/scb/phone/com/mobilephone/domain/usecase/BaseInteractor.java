package scb.phone.com.mobilephone.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import scb.phone.com.mobilephone.domain.ThreadExecutor;

/**
 * Created by sathish on 1/2/2018 AD.
 */

public class BaseInteractor {

    protected ThreadExecutor subscriberOn;
    protected ThreadExecutor observerOn;

    private ListCompositeDisposable disposables = new ListCompositeDisposable();
    private Observable observable;

    public BaseInteractor(final ThreadExecutor subscriberOn, final ThreadExecutor observerOn) {
        this.subscriberOn = subscriberOn;
        this.observerOn = observerOn;
    }

    protected Observable withObservable(final Observable observable) {
        this.observable = observable;
        return this.observable;
    }

    /**
     * Subscribe the subscriber to the registered observable
     *
     * @param subscriber Subscriber
     */
    public void execute(final Subscriber subscriber) {
        getSubscription(observable, subscriber);
    }

    // Another options for calling execute. Just to make the code for the caller be more expressive.

    /**
     * Subscribe the subscriber to the observable
     *
     * @param observable Observable
     * @param subscriber Subscriber
     * @param <T>        Observable type
     */
    public <T> void execute(Observable<T> observable, Subscriber<T> subscriber) {
        getSubscription(observable, subscriber);
    }

    /**
     * Subscribe the subscriber to the observable
     *
     * @param observable Observable
     * @param onNext     Consumer
     * @param <T>        Observable type
     */
    public <T> void execute(Observable<T> observable, Consumer<T> onNext) {
        getSubscription(observable, onNext);
    }

    /**
     * Subscribe onNext and onError actions to the observable
     *
     * @param observable Observable
     * @param onNext     onNext Action
     * @param onError    onError Action
     * @param <T>        Observable type
     */
    public <T> void execute(Observable<T> observable, Consumer<T> onNext, Consumer<Throwable> onError) {
        getSubscription(observable, onNext, onError);
    }

    /**
     * Unsubscribe all
     */
    public void unsubscribe() {
        unsubscribeAll();
    }

    /**
     * Unsubscribe all
     */
    public void unsubscribeAll() {
        disposables.dispose();
    }

    private <T> Disposable getSubscription(Observable<T> observable, final Consumer<T> onNext, final Consumer<Throwable> onError) {
        Disposable disposable = observable
                .subscribeOn(subscriberOn.getScheduler())
                .observeOn(observerOn.getScheduler())
                .subscribe(onNext, onError);

        addSubscription(disposable);
        return disposable;
    }

    private <T> Disposable getSubscription(Observable<T> observable, final Consumer<T> onNext) {
        Disposable disposable = observable
                .subscribeOn(subscriberOn.getScheduler())
                .observeOn(observerOn.getScheduler())
                .subscribe(onNext);
        addSubscription(disposable);

        return disposable;
    }


    private <T> void getSubscription(Observable<T> observable, final Subscriber<T> subscriber) {
        observable
                .subscribeOn(subscriberOn.getScheduler())
                .observeOn(observerOn.getScheduler())
                .doOnSubscribe(this::addSubscription)
                .safeSubscribe(subscriber);


    }

    private void addSubscription(Disposable disposable) {
        if (disposables.isDisposed()) {
            disposables = new ListCompositeDisposable();
        }
        if (disposable != null) {
            disposables.add(disposable);
        }
    }

    public static class Subscriber<T> extends DisposableObserver<T> {

        @Override
        public void onNext(@NonNull T t) {
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }

        public void unsubscribe(){
            dispose();
        }

    }

}
