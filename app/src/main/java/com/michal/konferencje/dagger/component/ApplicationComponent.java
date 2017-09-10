package com.michal.konferencje.dagger.component;

import com.michal.konferencje.categoryconference.CategoryAndConferenceInteractor;
import com.michal.konferencje.dagger.module.ApplicationModule;
import com.michal.konferencje.loginactivity.LoginActivityInteractor;
import com.michal.konferencje.main_activity.MainActivityInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michal on 08.08.17.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginActivityInteractor loginActivityInteractor);
    void inject(MainActivityInteractor mainActivityInteractor);
    void inject(CategoryAndConferenceInteractor categoryAndConferenceInteractor);

}
