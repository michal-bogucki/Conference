package com.michal.konferencje.categoryconference;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.michal.konferencje.ConferenceApp;
import com.michal.konferencje.Cons;
import com.michal.konferencje.R;
import com.michal.konferencje.adapter.CategoryAdapter;
import com.michal.konferencje.adapter.ConferenceAdapter;
import com.michal.konferencje.loginactivity.LoginActivityView;
import com.michal.konferencje.object.Category;
import com.michal.konferencje.object.Conference;
import com.michal.konferencje.object.InitLeftMenu;
import com.michal.konferencje.usercard.UserCardActivityView;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryAndConferenceView extends AppCompatActivity implements View.OnClickListener {
    @Inject
    CategoryAndConferencePresenter presenter;
    @BindView(R.id.nameRecyclerView)
    TextView nameRecyclerView;
    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.recyclerViewCategoryConference)
    RecyclerView recyclerView;
    @BindView(R.id.constraintCategory)
    ConstraintLayout constraintCategory;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private boolean isCategory = true;
    private ResideMenu resideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_and_conference);
        ButterKnife.bind(this);
        ((ConferenceApp) getApplication()).getPresenterComponent().inject(this);
        presenter.setView(this);
        initComponent();
    }

    private void initComponent() {
        InitLeftMenu initLeftMenu = new InitLeftMenu(this, this, constraintLayout, recyclerView);
        resideMenu = initLeftMenu.getResideMenu();
        if (isCategory) {
            presenter.getCategoryList();
        }
    }

    private void initConferenceRecyclerView(List<Conference> conferenceList) {
       fab.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        RecyclerView.Adapter oldAdapter = recyclerView.getAdapter();
        if (oldAdapter != null) {
            oldAdapter.notifyDataSetChanged();
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0)
                    fab.hide();
                else if (dy <= 0)
                    fab.show();
            }
        });
        ConferenceAdapter conferenceAdapter = new ConferenceAdapter(conferenceList, this);
        recyclerView.setAdapter(conferenceAdapter);
    }

    public void initCategoryRecyclerView(List<Category> categories) {
        fab.setVisibility(View.GONE);
        nameRecyclerView.setText(Cons.CATEGORY);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.clearOnScrollListeners();
        RecyclerView.Adapter oldAdapter = recyclerView.getAdapter();
        if (oldAdapter != null) {
            oldAdapter.notifyDataSetChanged();
        }
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void onClick(View view) {

        if (isOk(view, getClickMenu(0))) {
            Intent intent = new Intent(this, UserCardActivityView.class);
            startActivity(intent);
            resideMenu.closeMenu();
        } else if (isOk(view, getClickMenu(1))) {
            resideMenu.closeMenu();
        } else if (isOk(view, getClickMenu(2))) {
            resideMenu.closeMenu();
        } else if (isOk(view, getClickMenu(3))) {
            presenter.logOut();
            resideMenu.closeMenu();
        } else {
            if (isCategory) {
                Category category = (Category) view.getTag();
                initConferenceRecyclerView(category.getConferenceList());
                nameRecyclerView.setText(category.getName());
                isCategory = false;

            } else if (!isCategory) {
                Conference conference = (Conference) view.getTag();

            }

        }

    }


    public ResideMenuItem getClickMenu(int i) {
        return resideMenu.getMenuItems().get(i);
    }

    public boolean isOk(View view1, View view2) {
        return view1 == view2;
    }


    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivityView.class);
        startActivity(intent);
        finish();
    }


    @OnClick(R.id.menu)
    public void onViewClicked() {
        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
    }


    @Override
    public void onBackPressed() {
        if (isCategory) {
            super.onBackPressed();
        } else {
            isCategory = true;
            presenter.getCategoryList();
            nameRecyclerView.setText(Cons.CATEGORY);
        }
    }

    @OnClick(R.id.fab)
    public void onViewClickedFab() {
    }
}
