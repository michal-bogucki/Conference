package com.michal.konferencje.dagger.module;

import com.michal.konferencje.ConferenceApp;
import com.michal.konferencje.categoryconference.CategoryAndConferenceInteractor;
import com.michal.konferencje.loginactivity.LoginActivityInteractor;
import com.michal.konferencje.main_activity.MainActivityInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michal on 08.09.17.
 */
@Module
public class InteractorModule {
    ConferenceApp conferenceApp;
    public InteractorModule(ConferenceApp conferenceApp){
        this.conferenceApp = conferenceApp;
    }

    @Provides
    @Singleton
    LoginActivityInteractor loginActivityInteractor(){
        return new LoginActivityInteractor(conferenceApp.getComponent());
    }


    @Provides
    @Singleton
    MainActivityInteractor mainActivityInteractor(){
        return new MainActivityInteractor(conferenceApp.getComponent());
    }


    @Provides
    @Singleton
    CategoryAndConferenceInteractor categoryAndConferenceInteractor(){
        return new CategoryAndConferenceInteractor(conferenceApp.getComponent());
    }
}

