package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codepath.testingdemo.R;

public class PasswordActivity extends GameLevelActivity {

    EditText etPassword;
    Button btnCompleteLevel;

    private static final String SUPER_SECRET_PASSWORD = "42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        btnCompleteLevel = (Button)findViewById(R.id.btnCompleteLevel);

        etPassword = (EditText)findViewById(R.id.etPassword);
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (SUPER_SECRET_PASSWORD.equals(s.toString())) {
                    btnCompleteLevel.setEnabled(true);
                }
            }
        });
    }

    public void onCompleteLevelClicked(View view) {
        // do something
        launchLevelPassedActivity();
    }
}
