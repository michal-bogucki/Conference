package com.michal.konferencje.main_activity;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.michal.konferencje.dagger.component.ApplicationComponent;

import javax.inject.Inject;

/**
 * Created by michal on 08.09.17.
 */

public class MainActivityInteractor {
    @Inject
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authListener;
    MainActivityPresenter presenter;
    public MainActivityInteractor(ApplicationComponent component) {
        component.inject(this);

    }
    public void setPresenter(MainActivityPresenter presenter){
        this.presenter = presenter;
    }

    public void subscribe() {

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user == null) {
                    presenter.showLoginActivity();
                } else {

                    presenter.showCategoryList();
                }
            }
        };

        firebaseAuth.addAuthStateListener(authListener);
    }

    public void unsubscribe() {
        if(authListener != null) {
            firebaseAuth.removeAuthStateListener(authListener);
        }
    }
}
