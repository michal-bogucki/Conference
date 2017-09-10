package com.michal.konferencje.categoryconference;

import com.michal.konferencje.object.Category;

import java.util.List;

/**
 * Created by michal on 09.09.17.
 */

public interface CategoryAndConferencePresenterInterface {
    void setView(CategoryAndConferenceView categoryAndConferenceView);

    void getCategoryList();

    void logOut();

    void showLoginActivity();

    void setCategoryToRecyclerView(List<Category> categories);
}
