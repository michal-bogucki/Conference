package com.michal.konferencje.loginactivity;

/**
 * Created by michal on 08.09.17.
 */

public interface LoginActivityPresenterInterface {
    public void loginUser(String email, String password);
    public void registred(String email, String password);
    public void forgotPassword(CharSequence input);
    public void setLoginActivityView(LoginActivityView loginActivityView);
    public void onFailure(int zledane);
    public void onSuccess();
    public boolean testEmailPassword(String email, String password);
    public boolean isEmailValid(CharSequence email);
}
