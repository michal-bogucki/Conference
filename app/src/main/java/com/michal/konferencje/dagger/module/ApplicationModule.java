package com.michal.konferencje.dagger.module;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by michal on 08.08.17.
 */
@Module
public class ApplicationModule {
    private Application application;
    public ApplicationModule(Application application){
        this.application = application;

    }
    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }


    @Provides
    public FirebaseDatabase provideFirebaseDatabase() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        return firebaseDatabase;
    }

    @Provides
    public FirebaseAuth provideFirebaseAuth() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        return firebaseAuth;
    }

}
