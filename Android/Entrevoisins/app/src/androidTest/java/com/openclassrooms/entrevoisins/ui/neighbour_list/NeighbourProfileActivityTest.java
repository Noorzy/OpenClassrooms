package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.openclassrooms.entrevoisins.R;

import org.junit.Rule;
import org.junit.Test;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourProfileActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

public class NeighbourProfileActivityTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> activityActivityTestRule = new ActivityTestRule<ListNeighbourActivity>(ListNeighbourActivity.class);



    @Test
    public void neighbourProfileIsDisplayed() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(9, click()));
        onView(withId(R.id.activity_neighbour_profile))
                .check(matches(isDisplayed()));

    }
    @Test
    public void profileNameIsCorrect() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(9, click()));
        onView(withId(R.id.profileName1))
                .check(matches(withText("Emma")));
        onView(withId(R.id.profileName2))
                .check(matches(withText("Emma")));
    }
}