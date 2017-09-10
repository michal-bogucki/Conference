package com.michal.konferencje.main_activity;

import com.google.firebase.auth.FirebaseAuth;
import com.michal.konferencje.dagger.component.InteractorComponent;

import javax.inject.Inject;

/**
 * Created by michal on 08.08.17.
 */

public class MainActivityPresenter {

    MainActivityView mainActivityView;
    private FirebaseAuth.AuthStateListener authListener;
    @Inject
    MainActivityInteractor mainActivityInteractor;
    public MainActivityPresenter(InteractorComponent component) {
        component.inject(this);
        mainActivityInteractor.setPresenter(this);
    }
    public void setMainActivityView(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    public void subscribe() {
        mainActivityInteractor.subscribe();
    }


    public void unsubscribe() {
       mainActivityInteractor.unsubscribe();
    }

    public void showLoginActivity() {
        mainActivityView.showLoginActivity();
    }

    public void showCategoryList() {
        mainActivityView.showCategoryList();
    }
}
