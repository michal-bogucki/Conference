package com.michal.konferencje.dagger.module;

import com.michal.konferencje.ConferenceApp;
import com.michal.konferencje.categoryconference.CategoryAndConferencePresenter;
import com.michal.konferencje.loginactivity.LoginActivityPresenter;
import com.michal.konferencje.main_activity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michal on 08.08.17.
 */
@Module
public class PresenterModule {
    ConferenceApp conferenceApp;
    public PresenterModule(ConferenceApp conferenceApp){
        this.conferenceApp = conferenceApp;
    }
    @Provides
    @Singleton
    MainActivityPresenter mainActivityPresenter(){
        return new MainActivityPresenter(conferenceApp.getInteractorComponent());
    }

    @Provides
    @Singleton
    LoginActivityPresenter loginActivityPresenter(){
        return new LoginActivityPresenter(conferenceApp.getInteractorComponent());
    }



    @Provides
    @Singleton
    CategoryAndConferencePresenter categoryAndConferencePresenter(){
        return new CategoryAndConferencePresenter(conferenceApp.getInteractorComponent());
    }


}
