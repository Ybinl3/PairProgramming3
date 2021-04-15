package com.example.pairprogramming3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TouchListener touchListener;
    Button camB;
    ImageView pic;

    static final int REQUEST_IMAGE= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camB = (Button) findViewById(R.id.cameraBtn);
        pic = (ImageView) findViewById(R.id.imageView);
        touchListener = new TouchListener(this);
    }


    public void onSwipeDown() {
        pic.setRotation(pic.getRotation() + 180);
    }
    public void onSwipeUp(){
        //turn pic right side up
    }
    public void onButton(View view) {
        Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePicIntent, REQUEST_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnail = (Bitmap) extras.get("data");
            pic.setImageBitmap(thumbnail);
        }
    }
}