package com.michal.konferencje.object;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.michal.konferencje.R;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

/**
 * Created by michal on 05.05.17.
 */

public class InitLeftMenu {

    Activity activity;
    ResideMenu resideMenu;
    View.OnClickListener onClickListener;

    public InitLeftMenu(View.OnClickListener onClickListener,Activity conferenceActivityView, ConstraintLayout ignored_view, RecyclerView recyclerView) {
        this.onClickListener = onClickListener;
        this.activity = conferenceActivityView;
        initMenu();
        resideMenu.addIgnoredView(ignored_view);
        resideMenu.addIgnoredView(recyclerView);
    }

    private void initMenu(){
        resideMenu = new ResideMenu(activity);
        resideMenu.setBackground(R.drawable.tlo);
        resideMenu.attachToActivity(activity);
        resideMenu.setScaleValue(0.5f);





        String titles[] = { activity.getString(R.string.Moje_Konto), activity.getString(R.string.Moje_konferencje)
                , activity.getString(R.string.Ustawienia), activity.getString(R.string.wyloguj) };
        int icon[] = { R.drawable.ic_person_white_24dp, R.drawable.ic_list_white_24dp ,R.drawable.ic_settings_white_24dp,R.drawable.ic_power_settings_new_white_18dp };

        for (int i = 0; i < titles.length; i++){
            ResideMenuItem item = new ResideMenuItem(activity, icon[i], titles[i]);
            item.setOnClickListener(onClickListener);
            resideMenu.addMenuItem(item,  ResideMenu.DIRECTION_LEFT);

        }


    }

    public ResideMenu getResideMenu() {
        return resideMenu;
    }





}
