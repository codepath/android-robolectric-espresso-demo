package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.fragments.DatePickerFragment;
import com.codepath.testingdemo.fragments.TimePickerFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimePickerActivity extends GameLevelActivity
        implements DatePickerFragment.OnDateSetListener, TimePickerFragment.OnTimeSetListener {

    private Button btnCompleteLevel;
    private final GregorianCalendar expectedCalendar = new GregorianCalendar(1985, 9, 26, 1, 20);
    private GregorianCalendar guessCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        btnCompleteLevel = (Button)findViewById(R.id.btnCompleteLevel);
        guessCalendar = new GregorianCalendar();
    }

    public void onDatePickerClicked(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onTimePickerClicked(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    private void checkIfLevelPassed() {
        btnCompleteLevel.setEnabled(expectedCalendar.equals(guessCalendar));
    }

    public void onCompleteLevelClicked(View view) {
        launchLevelPassedActivity();
    }

    @Override
    public void onDateSet(int year, int month, int day) {
        guessCalendar.set(year, month, day);
        checkIfLevelPassed();
    }

    @Override
    public void onTimeSet(int hour, int minute) {
        guessCalendar.set(Calendar.HOUR, hour);
        guessCalendar.set(Calendar.HOUR_OF_DAY, hour);
        guessCalendar.set(Calendar.MINUTE, minute);
        guessCalendar.set(Calendar.SECOND, 0);
        guessCalendar.set(Calendar.MILLISECOND, 0);
        checkIfLevelPassed();
    }
}
