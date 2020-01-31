package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.rule.ActivityTestRule;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;


public class FavoritesFragmentTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> activityActivityTestRule = new ActivityTestRule<ListNeighbourActivity>(ListNeighbourActivity.class);
    private List<Neighbour> mNeighbours;
    private NeighbourApiService mApiService;


    @Before
    public void init() {
        mApiService = DI.getNeighbourApiService();
        mNeighbours = mApiService.getNeighbours();

        List<Neighbour> FavoritesNeighbours = new ArrayList<>();
        for (Neighbour i : mNeighbours) {
            if (i.isFavoriteCheck() == true) {
                FavoritesNeighbours.add(i);
            }
        }
    }


    @Test
    public void favoritesListHasOnlyFavoritesNeighbour() {
        onView(withText("Favorites"))
                .perform(click());
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(withItemCount(2));

//TODO finir les tests sur la liste de favoris

    }
}