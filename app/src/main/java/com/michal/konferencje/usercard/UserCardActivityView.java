package com.michal.konferencje.usercard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michal.konferencje.R;
import com.michal.konferencje.editprofilactivity.EditProfilActivityView;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserCardActivityView extends AppCompatActivity {

    @BindView(R.id.nameUser_AUC_TextView)
    TextView name;
    @BindView(R.id.email_AUC_TextView)
    TextView email;
    @BindView(R.id.phone_AUC_TextView)
    TextView phone;
    @BindView(R.id.fieldOfStudy_AUC_TextView)
    TextView fieldOfStudy;
    @BindView(R.id.profileImage_AUC_Image)
    CircleImageView profileImage;
    @BindView(R.id.background_AUC_ImageView)
    ImageView backgroundImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_card_view);
    }

    @OnClick(R.id.editProfil_AUC_FAB)
    public void editProfil(View view){
        Intent editProfilIntent = new Intent(this,EditProfilActivityView.class);
        startActivity(editProfilIntent);
        finish();
    }
}
