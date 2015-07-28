package com.codepath.testingdemo.helpers;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.LayoutAssertions.noEllipsizedText;
import static android.support.test.espresso.assertion.LayoutAssertions.noMultilineButtons;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.runner.lifecycle.Stage.RESUMED;
import static com.codepath.testingdemo.matchers.CustomViewMatchers.nthChildOf;
import static com.codepath.testingdemo.matchers.CustomViewMatchers.withRecyclerView;
import static org.hamcrest.Matchers.allOf;

public class EspressoHelpers {

    // Text Entry

    public static ViewInteraction enterTextIntoViewWithHint(String textToEnter, @StringRes int hintResourceId) {
        return onView(withHint(hintResourceId)).perform(typeText(textToEnter));
    }

    public static ViewInteraction enterTextIntoViewWithId(String textToEnter, @IdRes int viewResourceId) {
        return onView(withId(viewResourceId)).perform(typeText(textToEnter));
    }

    // Scrolling

    public static ViewInteraction scrollToViewWithId(@IdRes int viewResourceId) {
        return onView(withId(viewResourceId)).perform(scrollTo());
    }

    // Tapping

    public static ViewInteraction tapViewWithId(@IdRes int viewResourceId) {
        return onView(withId(viewResourceId)).perform(click());
    }

    // RecyclerView

    public static ViewInteraction onRecyclerViewItemAtPosition(@IdRes int recyclerViewResourceId,
                                                               int position) {


        return onView(nthChildOf(withRecyclerView(recyclerViewResourceId), position));
    }

    // Requires unique identifier for each row to be useful
    public static ViewInteraction onRecyclerViewItem(@IdRes int recyclerViewResourceId,
                                                     @IdRes int identifyingViewResourceId,
                                                     Matcher<View> identifyingMatcher,
                                                     Matcher<View> childMatcher) {
        Matcher<View> itemView =
                allOf(
                        withParent(withRecyclerView(recyclerViewResourceId)),
                        withChild(
                                allOf(withId(identifyingViewResourceId), identifyingMatcher)));

        return Espresso.onView(allOf(isDescendantOfA(itemView), childMatcher));
    }

    // Test that there are no ellipsized texts.
    public static ViewInteraction checkNoEllipsizedTextInViewHierarchy(@IdRes int parentViewId) {
        return onView(withId(parentViewId)).check(noEllipsizedText());
    }


    // Test that there are no multiline buttons.
    public static ViewInteraction checkNoMultilineButtonsInViewHierarchy(@IdRes int parentViewId) {
        return onView(withId(parentViewId)).check(noMultilineButtons());
    }

    // Get activity instance for multi-activity Espresso tests
    public static Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
                if (resumedActivities.iterator().hasNext()) {
                    activity[0] = (AppCompatActivity)resumedActivities.iterator().next();
                }
            }
        });

        return activity[0];
    }
}
