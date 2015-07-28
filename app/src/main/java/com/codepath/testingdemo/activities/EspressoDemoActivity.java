package com.codepath.testingdemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codepath.testingdemo.R;
import com.codepath.testingdemo.models.User;

public class EspressoDemoActivity extends AppCompatActivity {

    TextView tvSearchText;
    EditText etSearch;
    Button btnSubmit;

    TextView tvCurrentUser;

    Button btnDisplayCurrentUser;

    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_demo);

        etSearch = (EditText)findViewById(R.id.etSearch);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        tvSearchText = (TextView)findViewById(R.id.tvSearchText);

        tvCurrentUser = (TextView)findViewById(R.id.tvCurrentUser);
        btnDisplayCurrentUser = (Button)findViewById(R.id.btnDisplayCurrentUser);

    }

    public void onSubmitClicked(View view) {
        tvSearchText.setText(etSearch.getText().toString());
        etSearch.setText("");
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void onDisplayCurrentUserClicked(View view) {
        if (currentUser == null) {
            return;
        }
        tvCurrentUser.setText(currentUser.getUserName());
    }
}
