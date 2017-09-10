package com.michal.konferencje.dagger.component;

import com.michal.konferencje.categoryconference.CategoryAndConferencePresenter;
import com.michal.konferencje.dagger.module.InteractorModule;
import com.michal.konferencje.loginactivity.LoginActivityPresenter;
import com.michal.konferencje.main_activity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by michal on 08.09.17.
 */
@Singleton
@Component(modules = {InteractorModule.class})
public interface InteractorComponent {
    void inject(LoginActivityPresenter loginActivityPresenter);
    void inject(MainActivityPresenter mainActivityPresenter);
    void inject(CategoryAndConferencePresenter categoryAndConferencePresenter);


}
