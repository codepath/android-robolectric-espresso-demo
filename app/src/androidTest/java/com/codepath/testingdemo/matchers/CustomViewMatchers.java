package com.codepath.testingdemo.matchers;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class CustomViewMatchers {

    public static Matcher<View> withRecyclerView(@IdRes int viewId) {
        return allOf(isAssignableFrom(RecyclerView.class), withId(viewId));
    }

    // Pulled from http://stackoverflow.com/a/30073528/681493
    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("with " + childPosition + " child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup viewGroup = (ViewGroup) view.getParent();

                return parentMatcher.matches(view.getParent()) &&
                        viewGroup.getChildAt(childPosition).equals(view);
            }
        };
    }
}
