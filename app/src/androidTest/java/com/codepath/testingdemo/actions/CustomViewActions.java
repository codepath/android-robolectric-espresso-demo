package com.codepath.testingdemo.actions;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

public class CustomViewActions {

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with the specified id";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View viewToClick = view.findViewById(id);
                if (viewToClick != null) {
                    viewToClick.performClick();
                }
            }
        };
    }
}
