package com.example.pairprogramming3;


import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;


public class TouchListener implements View.OnTouchListener {
    MainActivity mainActivity;
    GestureDetectorCompat gestureDetectorCompat;

    public TouchListener(MainActivity ma) {
        this.mainActivity = ma;
        //gestureDetectorCompat = new GestureDetectorCompat(this.mainActivity, new MyGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gestureDetectorCompat.onTouchEvent(motionEvent);
        int maskedAction = motionEvent.getActionMasked();
        switch(maskedAction){
            case MotionEvent.ACTION_DOWN:

            case MotionEvent.ACTION_POINTER_DOWN:
                //Log.d("TAG", "Action was DOwn");
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }



    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            mainActivity.onSwipeDown();
            return super.onDoubleTap(e);
        }
        /*
        @Override
        public boolean onDown(MotionEvent e) {
            mainActivity.onSwipeDown();
            return super.onDown(e);
        }

        @Override
        public void onSwipeUp(MotionEvent e) {
            mainActivity.onSwipeUp();
            super.onLongPress(e);
        }
        */
    }

}