package com.michal.konferencje.dagger.component;

import com.michal.konferencje.categoryconference.CategoryAndConferenceView;
import com.michal.konferencje.dagger.module.PresenterModule;
import com.michal.konferencje.loginactivity.LoginActivityView;
import com.michal.konferencje.main_activity.MainActivityView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michal on 08.08.17.
 */
@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
    void inject(MainActivityView mainActivityView);
    void inject(LoginActivityView loginActivityView);
    void inject(CategoryAndConferenceView categoryAndConferenceView);
}
