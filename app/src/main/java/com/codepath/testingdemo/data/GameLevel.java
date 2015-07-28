package com.codepath.testingdemo.data;

import com.codepath.testingdemo.activities.CameraActivity;
import com.codepath.testingdemo.activities.CustomNetworkRequestActivity;
import com.codepath.testingdemo.activities.DateTimePickerActivity;
import com.codepath.testingdemo.activities.ListViewActivity;
import com.codepath.testingdemo.activities.MainActivity;
import com.codepath.testingdemo.activities.NetworkRequestActivity;
import com.codepath.testingdemo.activities.PasswordActivity;
import com.codepath.testingdemo.activities.RecyclerViewActivity;
import com.codepath.testingdemo.activities.ScrollActivity;
import com.codepath.testingdemo.activities.ViewPagerActivity;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class GameLevel {

    static final Map<Integer, Class> LEVELS = ImmutableMap.<Integer, Class>builder()
            .put(1, MainActivity.class)
            .put(2, PasswordActivity.class)
            .put(3, ScrollActivity.class)
            .put(4, ViewPagerActivity.class)
            .put(5, DateTimePickerActivity.class)
            .put(6, ListViewActivity.class)
            .put(7, RecyclerViewActivity.class)
            .put(8, CameraActivity.class)
            .put(9, NetworkRequestActivity.class)
            .put(10, CustomNetworkRequestActivity.class)
            .build();

    public static Class getClassForLevel(int levelNumber) {
        return LEVELS.get(levelNumber);
    }
    public static int getNumberOfLevels() {
        return LEVELS.size();
    }
}
