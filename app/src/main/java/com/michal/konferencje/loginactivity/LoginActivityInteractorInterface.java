package com.michal.konferencje.loginactivity;

/**
 * Created by michal on 08.09.17.
 */

public interface LoginActivityInteractorInterface {
    public void loginUser(String email, String password);
    public void registred(String email, String password);
    public void forgotPassword(CharSequence input);
    public void setLoginActivityPresenter(LoginActivityPresenter presenter);

}
