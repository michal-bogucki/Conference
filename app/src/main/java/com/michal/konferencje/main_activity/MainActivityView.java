package com.michal.konferencje.main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.michal.konferencje.ConferenceApp;
import com.michal.konferencje.R;
import com.michal.konferencje.categoryconference.CategoryAndConferenceView;
import com.michal.konferencje.loginactivity.LoginActivityView;

import javax.inject.Inject;

public class MainActivityView extends AppCompatActivity {

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        ((ConferenceApp) getApplication()).getPresenterComponent().inject(this);
        mainActivityPresenter.setMainActivityView(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityPresenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainActivityPresenter.unsubscribe();
    }

    public void showLoginActivity() {
        Intent intent = new Intent(this, LoginActivityView.class);
        startActivity(intent);
        this.finish();
    }

    public void showCategoryList() {
        Intent intent = new Intent(this, CategoryAndConferenceView.class);
        startActivity(intent);
        this.finish();
    }
}
