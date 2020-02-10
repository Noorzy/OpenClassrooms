package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.core.internal.deps.dagger.internal.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.AllOf.allOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

public class FavoritesFragmentTest {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> activityActivityTestRule = new ActivityTestRule<ListNeighbourActivity>(ListNeighbourActivity.class);
    private List<Neighbour> mNeighbours;
    private NeighbourApiService mApiService;

    public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
        checkNotNull(itemMatcher);
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(final RecyclerView view) {
                RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
                if (viewHolder == null) {
                    // has no item on such position
                    return false;
                }
                return itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

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
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(atPosition(0, hasDescendant(withText("Caroline")))));
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(atPosition(1, hasDescendant(withText("Elodie")))));
    }
}