package com.michal.konferencje.categoryconference;

/**
 * Created by michal on 09.09.17.
 */

public interface CategoryAndConferenceInteractorInterface {
    void setPresenter(CategoryAndConferencePresenter presenter);

   void getCategoryList();

    void logOut();
}
