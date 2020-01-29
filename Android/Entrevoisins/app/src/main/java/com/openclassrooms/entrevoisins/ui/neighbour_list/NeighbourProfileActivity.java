package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourProfileActivity extends AppCompatActivity {
    @BindView(R.id.backButton)
    public ImageButton mBackButton;
    @BindView(R.id.profileName1)
    public TextView name1;
    @BindView(R.id.profileName2)
    public TextView name2;
    @BindView(R.id.profilePicture)
    public ImageView profilePicture;
    @BindView(R.id.favoriteButton)
    public CheckBox favoriteButton;



    private NeighbourApiService mApiService;
    private Neighbour selectedNeighbour;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile);
        ButterKnife.bind(this);
        selectedNeighbour = getIntent().getParcelableExtra("selectedNeighbour");
        name1.setText(selectedNeighbour.getName());
        name2.setText(selectedNeighbour.getName());
        Glide.with(this).load(selectedNeighbour.getAvatarUrl()).into(profilePicture);
        mApiService = DI.getNeighbourApiService();

        favoriteButtonStatusCheck();


        click();
    }




    public void click() {
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListNeighbour = new Intent(v.getContext() , ListNeighbourActivity.class);
                ListNeighbour.putExtra("neighbour" , selectedNeighbour);
                v.getContext().startActivity(ListNeighbour);
                //finish();
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedNeighbour.isFavoriteCheck() == true) {
                    selectedNeighbour.setFavoriteCheck(false);
                } else {
                    selectedNeighbour.setFavoriteCheck(true);
                }
                mApiService.changeFavoriteCheck(selectedNeighbour);
                favoriteButtonStatusCheck();

            }
        });

    }
    public void favoriteButtonStatusCheck(){
        if (selectedNeighbour.isFavoriteCheck() == true) {
            favoriteButton.setChecked(true);
        }else {
            favoriteButton.setChecked(false);
        }
    }
}


