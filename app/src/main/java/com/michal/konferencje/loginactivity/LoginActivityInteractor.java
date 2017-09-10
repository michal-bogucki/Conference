package com.michal.konferencje.loginactivity;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.michal.konferencje.R;
import com.michal.konferencje.dagger.component.ApplicationComponent;
import com.michal.konferencje.object.User;

import javax.inject.Inject;

import static com.michal.konferencje.Cons.USER_DATABASE_REFERENCE;

/**
 * Created by michal on 08.09.17.
 */

public class LoginActivityInteractor implements LoginActivityInteractorInterface {
    @Inject
    FirebaseAuth firebaseAuth;
    @Inject
    FirebaseDatabase database;
    private LoginActivityPresenter presenter;

    public LoginActivityInteractor(ApplicationComponent component) {
        component.inject(this);
    }

    @Override
    public void setLoginActivityPresenter(LoginActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            presenter.onSuccess();
                        } else {
                            presenter.onFailure(R.string.zledane);

                        }


                    }
                });
    }

    @Override
    public void registred(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            addUserToDatabase();
                            presenter.onSuccess();

                        } else {
                            presenter.onFailure(R.string.takiuzytkownikjuzistnieje);
                        }

                    }
                });
    }

    private void addUserToDatabase() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        User userDatabase = new User();
        userDatabase.setEmail(user.getEmail());
        userDatabase.setIdUser(user.getUid());
        database.getReference().child(USER_DATABASE_REFERENCE).push().setValue(userDatabase);
    }

    @Override
    public void forgotPassword(CharSequence input) {
        firebaseAuth.sendPasswordResetEmail((String) input)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            presenter.onFailure(R.string.haslo);
                        } else {
                            presenter.onFailure(R.string.error);
                        }
                    }
                });
    }


}
