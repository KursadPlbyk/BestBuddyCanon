package com.google.mlkit.vision.demo.java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.demo.R;
import com.google.mlkit.vision.demo.java.facedetector.FaceGraphic;
import com.google.mlkit.vision.pose.PoseLandmark;


public class BestBuddyChecker extends Activity /*extends AppCompatActivity implements ImageAnalysis.Analyzer, View.OnClickListener**/ {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision_live_preview);

        textView = findViewById(R.id.buddyCheckerLabel);
        textView.setText("hallo");
    }

    public static boolean checkPortraitMode(float top, float left, float right, float bottom) {
        // check if face is complete, including headspace
        if (top < 300 || left < 200 || right > 880 || bottom > 1690) {
            return false;
        }
        return true;
    }


    public static boolean checkLandscapeMode(PoseLandmark leftFootIndex, PoseLandmark rightFootIndex, PoseLandmark nose) {
        // check if legs are in picture
        if (leftFootIndex.getPosition().x > 320 || rightFootIndex.getPosition().x > 320 ||
                leftFootIndex.getPosition().x < 80 || rightFootIndex.getPosition().x < 80 ||
                nose.getPosition().y < 80 || leftFootIndex.getPosition().y > 600 ||
                rightFootIndex.getPosition().y > 600 ) {
            return false;
        }
        return true;
    }

    public static boolean checkLandscapeMode2(PoseLandmark leftFootIndex, PoseLandmark rightFootIndex, PoseLandmark nose) {
        // check if legs are in picture
        if (leftFootIndex.getPosition().x > 400 || rightFootIndex.getPosition().x > 400) {
            return false;
        }
        return true;
    }

//    public static boolean checkZweiDrittel(PoseLandmark leftHip, PoseLandmark rightHip){
//        //check if rule of thirds is fulfilled
//
//    }

}
