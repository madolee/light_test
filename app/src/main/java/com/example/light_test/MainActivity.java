package com.example.light_test;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraID;
    private AudioManager audio;
    // int  arr[33]={13,88,13,22,22,88,88,13,8,88,8,88,13,22,22,88,88,13,8,13,88,8,13,22,22,88,88,13,8,88,13,13,8};


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        try {
            cameraID = cameraManager.getCameraIdList()[0]; // 0 is for back camera
            //          audio=(AudioManager)getSystemService(Context.AUDIO_SERVICE);



            //          AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void TorchONButtonClick(View view){

        for(int i=-1; i<33; i++)  {

            ARR=arr[i];
            switch(ARR){

                case 8:
                    break;


                case 13:
                    break;



                case 22:
                    break;


                case 0:
                    break;


                delay (1000);
            }
        }
        try {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC,
                    (int) (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * 0.95),
                    AudioManager.FLAG_PLAY_SOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void TorchOFFButtonClick(View view){
        try {
            cameraManager.setTorchMode(cameraID, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}