package com.codepath.testingdemo.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.codepath.testingdemo.R;

public class CameraActivity extends GameLevelActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView ivThumbnail;
    Button btnCompleteLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ivThumbnail = (ImageView)findViewById(R.id.ivThumbnail);
        btnCompleteLevel = (Button)findViewById(R.id.btnCompleteLevel);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void onTakePictureClicked(View view) {
        dispatchTakePictureIntent();
    }

    public void onCompleteLevelClicked(View view) {
         launchLevelPassedActivity();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivThumbnail.setImageBitmap(imageBitmap);
            btnCompleteLevel.setEnabled(true);
        }
    }
}
