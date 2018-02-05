package scb.phone.com.mobilephone.presentation;

import android.support.annotation.CallSuper;

public abstract class BasePresenter<T extends BaseView> {

    public interface ViewFunction<V> {
        void execute(V view);
    }

    private T view;

    public BasePresenter(){

    }

    public T getView() {
        return view;
    }

    @CallSuper
    public void setView(T view) {
        this.view = view;
    }

    public final boolean isViewAttached() {
        return view != null;
    }

    public void doInView(ViewFunction<T> viewFunction) {
        if (isViewAttached()) {
            viewFunction.execute(view);
        }
    }

    protected void showLoading() {
        if (isViewAttached()) {
            view.showLoading();
        }
    }

    public void hideLoading() {
        if (isViewAttached()) {
            view.hideLoading();
        }
    }
}
