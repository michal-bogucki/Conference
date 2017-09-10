package com.michal.konferencje.categoryconference;

import com.michal.konferencje.dagger.component.InteractorComponent;
import com.michal.konferencje.object.Category;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by michal on 09.09.17.
 */

public class CategoryAndConferencePresenter implements CategoryAndConferencePresenterInterface {
    private CategoryAndConferenceView view;

    @Inject
    CategoryAndConferenceInteractor interactor;

    public CategoryAndConferencePresenter(InteractorComponent interactorComponent) {
        interactorComponent.inject(this);
        interactor.setPresenter(this);

    }

    @Override
    public void setView(CategoryAndConferenceView view) {
        this.view = view;
    }

    @Override
    public void getCategoryList() {
        interactor.getCategoryList();

    }


    @Override
    public void logOut() {
        interactor.logOut();
    }

    @Override
    public void showLoginActivity() {
        view.openLoginActivity();
    }

    @Override
    public void setCategoryToRecyclerView(List<Category> categories) {
        view.initCategoryRecyclerView(categories);
    }
}
