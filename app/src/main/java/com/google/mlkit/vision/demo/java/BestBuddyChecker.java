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

    /*
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    PreviewView previewView;
    Button bFoto;
    private ImageCapture imageCapture;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        bFoto = findViewById(R.id.button);
        previewView = findViewById(R.id.preview);

        bFoto.setOnClickListener((View.OnClickListener) this);
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                startCameraX(cameraProvider);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, getExecutor());
    }

    private Executor getExecutor() {
        return ContextCompat.getMainExecutor(this);
    }

    @SuppressLint("RestrictedApi")
    private void startCameraX(ProcessCameraProvider cameraProvider) {
        cameraProvider.unbindAll();
        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();
        Preview preview = new Preview.Builder()
                .build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        // Image capture use case
        imageCapture = new ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .build();

        // Image analysis use case
        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build();

        imageAnalysis.setAnalyzer(getExecutor(), this);
    }

    @Override
    public void analyze(@NonNull ImageProxy image) {
        // image processing here for the current frame
        Log.d("TAG", "analyze: got the frame at: " + image.getImageInfo().getTimestamp());
        image.close();
    }


    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                capturePhoto();
                break;
        }
    }

    private void capturePhoto() {
        long timestamp = System.currentTimeMillis();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, timestamp);
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");



        imageCapture.takePicture(
                new ImageCapture.OutputFileOptions.Builder(
                        getContentResolver(),
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        contentValues
                ).build(),
                getExecutor(),
                new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        Toast.makeText(BestBuddyChecker.this, "Photo has been saved successfully.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        Toast.makeText(BestBuddyChecker.this, "Error saving photo: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
**/

    /***
     *
     *
     *
     *
     * ------------ unser code --------------------
     *
     *
     *
     *
     */
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
