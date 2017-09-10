package com.michal.konferencje;

import android.app.Application;

import com.michal.konferencje.dagger.component.ApplicationComponent;
import com.michal.konferencje.dagger.component.DaggerApplicationComponent;
import com.michal.konferencje.dagger.component.DaggerInteractorComponent;
import com.michal.konferencje.dagger.component.DaggerPresenterComponent;
import com.michal.konferencje.dagger.component.InteractorComponent;
import com.michal.konferencje.dagger.component.PresenterComponent;
import com.michal.konferencje.dagger.module.ApplicationModule;
import com.michal.konferencje.dagger.module.InteractorModule;
import com.michal.konferencje.dagger.module.PresenterModule;

/**
 * Created by michal on 08.08.17.
 */

public class ConferenceApp extends Application{
    private ApplicationComponent applicationComponent;
    private PresenterComponent presenterComponent;
    private InteractorComponent interactorComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(this))
                .build();
        interactorComponent = DaggerInteractorComponent.builder()
                .interactorModule(new InteractorModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return  applicationComponent;
    }

    public PresenterComponent getPresenterComponent(){
        return presenterComponent;
    }

    public InteractorComponent getInteractorComponent(){return interactorComponent;}
}
