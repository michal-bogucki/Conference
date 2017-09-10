package com.michal.konferencje.loginactivity;

import com.michal.konferencje.R;
import com.michal.konferencje.dagger.component.InteractorComponent;

import javax.inject.Inject;

/**
 * Created by michal on 08.08.17.
 */

public class LoginActivityPresenter implements LoginActivityPresenterInterface {


    @Inject
    LoginActivityInteractor loginActivityInteractor;
    LoginActivityView loginActivityView;

    public LoginActivityPresenter(InteractorComponent component) {
        component.inject(this);
        loginActivityInteractor.setLoginActivityPresenter(this);
    }

    @Override
    public void setLoginActivityView(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    @Override
    public void loginUser(String email, String password) {
        loginActivityInteractor.loginUser(email,password);

    }
    @Override
    public void registred(String email, String password) {
        loginActivityInteractor.registred(email,password);
    }
    @Override
    public void forgotPassword(CharSequence input) {
        loginActivityInteractor.forgotPassword(input);
    }


    @Override
    public void onFailure(int text) {
    loginActivityView.showSnackBar(text);
    }

    @Override
    public void onSuccess() {
        loginActivityView.openCategoryActivity();
    }
    @Override
    public boolean testEmailPassword(String email, String password) {
        boolean test = false;
        if (!isEmailValid(email)) {
            loginActivityView.showSnackBar(R.string.ZlyAdres);
            test = true;

        }
        if (password.length() < 6) {
            loginActivityView.showSnackBar(R.string.Haslo5Znaków);
            test = true;
        }
        return test;
    }
    @Override
    public boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}