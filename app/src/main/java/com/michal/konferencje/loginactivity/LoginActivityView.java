package com.michal.konferencje.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.michal.konferencje.ConferenceApp;
import com.michal.konferencje.R;
import com.michal.konferencje.categoryconference.CategoryAndConferenceView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivityView extends AppCompatActivity {

    private final int logIn_al_button = R.id.LogIn_AL_Button;
    @Inject
    LoginActivityPresenter loginActivityPresenter;
    @BindView(R.id.Email_AL_EditText)
    EditText EmailALEditText;
    @BindView(R.id.Password_AL_EditText)
    EditText PasswordALEditText;
    @BindView(R.id.Constraint)
    ConstraintLayout Constraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        ButterKnife.bind(this);
        clearEditText();
        ((ConferenceApp) getApplication()).getPresenterComponent().inject(this);
        loginActivityPresenter.setLoginActivityView(this);

    }

    private String getEditText(EditText editText) {
        return editText.getText().toString();
    }

    @OnClick(logIn_al_button)
    public void onLogInALButtonClicked() {
        String email = getEditText(EmailALEditText);
        String password = getEditText(PasswordALEditText);
        if (loginActivityPresenter.testEmailPassword(email, password)) {
            return;
        }

        loginActivityPresenter.loginUser(email, password);
    }


    @OnClick(R.id.Registration_AL_Button)
    public void onRegistrationALButtonClicked() {
        String email = getEditText(EmailALEditText);
        String password = getEditText(PasswordALEditText);
        if (loginActivityPresenter.testEmailPassword(email, password)) {
            return;
        }

        loginActivityPresenter.registred(email, password);
    }

    @OnClick(R.id.ForgotPassword_AL_Button)
    public void onForgotPasswordALButtonClicked() {

        MaterialDialog builder = new MaterialDialog.Builder(this)
                .title("Add Item")
                .widgetColor(getResources().getColor(R.color.cardview_light_background))
                .inputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
                .input(getString(R.string.podajAdresEmail), "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        clearEditText();
                        String email = input.toString();
                        if (loginActivityPresenter.isEmailValid(email))
                            loginActivityPresenter.forgotPassword(email);
                        else
                            showSnackBar(R.string.ZlyAdres);

                    }
                }).negativeText("Cancel").show();
    }

    public void showSnackBar(int message) {
       Snackbar.make(Constraint, getString(message), Snackbar.LENGTH_LONG).show();
    }

    public void openCategoryActivity() {
        Intent intent = new Intent(this, CategoryAndConferenceView.class);
        startActivity(intent);
        this.finish();
    }

    private void clearEditText() {
        EmailALEditText.setText("");
        PasswordALEditText.setText("");
    }
}
