package com.michal.konferencje.categoryconference;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.michal.konferencje.Cons;
import com.michal.konferencje.dagger.component.ApplicationComponent;
import com.michal.konferencje.object.Category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by michal on 09.09.17.
 */

public class CategoryAndConferenceInteractor implements CategoryAndConferenceInteractorInterface {
    private static final String TAG = "michal";
    private CategoryAndConferencePresenter presenter;
    @Inject
    FirebaseAuth firebaseAuth;
    @Inject
    FirebaseDatabase firebaseDatabase;
    public CategoryAndConferenceInteractor(ApplicationComponent component) {
        component.inject(this);
    }

    @Override
    public void setPresenter(CategoryAndConferencePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getCategoryList() {
        firebaseDatabase.getReference().child(Cons.CATEGORY).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: ");
                List<Category> categories = new ArrayList<Category>();
                int i=0;
                for(DataSnapshot c:dataSnapshot.getChildren()){
                    categories.add(i++,c.getValue(Category.class));
                }
                presenter.setCategoryToRecyclerView(categories);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: ");
            }
        });

    }


    @Override
    public void logOut() {
        firebaseAuth.signOut();
        presenter.showLoginActivity();
    }
}
