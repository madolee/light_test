package com.example.light_test;
//;package com.example.auto_light3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static AudioManager audio;
    private CameraManager cameraManager;
    private String cameraID;
    //  private AudioManager audio;
    TextView textv;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);


        try {
            cameraID = cameraManager.getCameraIdList()[0]; // 0 is for back camera
        } catch (Exception e) {
            e.printStackTrace();
        }
        textv = findViewById(R.id.t1);

        Integer[] str_arrary = {88,88,8,13,88,13,8,8,22,22,88,88,8,13};
        ArrayList<Integer> ARR = new ArrayList<>();

        timer(6);
        for (int i = 0; i < str_arrary.length; i++) {

            int sum = i + 15;
            String arr=( String.valueOf(str_arrary[i]));
            textv.setText( String.valueOf(str_arrary[i]));
            textv.setText("Today is " + sum + "/n" + "Work code is" + arr);

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (str_arrary[i]){

                case 88:
                    timer(8);
                    auda();

                    //  Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com")); startActivity(myIntent);
                    timer(  2 );
                    audz();

                    timer(8);
                    Toron();
                    timer(6);
                    Toroff();
                    break;

                case 22:
                    timer(18);
                    Toron();
                    timer(2);
                    Toroff();
                    timer(4);
                    break;


                case 8:
                    timer((int) 5.75);
                    //alram
                    timer((int) 12.25);
                    auda();
                    // music
                    Toron();
                    timer(4);
                    audz();
                    timer(2);


                    break;


                case 13:
                    timer(8);
                    auda();
                    timer((int) 2.4);
                    audz();
                    timer((int) 12.6);
                    auda();
                    Toron();
                    timer(1);
                    audz();
                    Toroff();
                    break;

            }



        }
    }





    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void     audz() {
        try {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC,
                    (int) (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * 0.15),
                    AudioManager.FLAG_PLAY_SOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void  timer(int a){
        try {

            Thread.sleep(3600L *a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public static void auda () {
        try {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC,
                    (int) (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * 0.95),
                    AudioManager.FLAG_PLAY_SOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Toron(){
        try {
            cameraManager.setTorchMode(cameraID, true);
            audio.setStreamVolume(AudioManager.STREAM_MUSIC,
                    (int) (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * 0.95),
                    AudioManager.FLAG_PLAY_SOUND);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void Toroff(){
        try {
            cameraManager.setTorchMode(cameraID, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}