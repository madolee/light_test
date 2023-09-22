package com.example.light_test;
//;package com.example.auto_light3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

        Integer[] str_arrary = {13,88,13,8,8,22,22,88,88,8,13,13,88,88,13,22,22,88,88,13,13,88,8,8,88,22,22,88,88,8,13,13,88,8,13,8,88,8,13,22,22,88};
        ArrayList<Integer> ARR = new ArrayList<>();


        Toron();
        timer((float)0.18);
        Toroff();
        audz();


        for (int i = 0; i < str_arrary.length; i++) {

            int sum = i + 15;
            String arr=( String.valueOf(str_arrary[i]));
            textv.setText( String.valueOf(str_arrary[i]));
            textv.setText("Today is " + sum + "/n" + "Work code is" + arr);

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (str_arrary[i]){

                case 88:
                    if (str_arrary[i - 1] == 22){

                        timer(15);
                        auda();
                        timer(3);
                        Toron();
                        timer(6);
                        audz();
                        Toroff();
                        break;
                }
                    timer(8);
                    auda();

                    //  Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com")); startActivity(myIntent);
                    timer(  2 );
                    audz();

                    timer(7);
                    Toron();
                    timer(7);
                    Toroff();
                    break;

                case 22:
                    if  (str_arrary[i - 1] == 22){
                        timer(15);
                        auda();
                        timer(3);
                        Toron();
                        timer(6);
                        audz();
                        Toroff();
                        break;

                }
                    timer(8);
                    auda();
                    timer(  2 );
                    audz();



                    timer(7);
                    Toron();

                    timer(7 );
                    Toroff();
                    break;


                case 8:
                    timer((float) 5.75);
                    //alram
                    auda();
                    timer((float) 0.25);
                    audz();
                    timer((int) 12);
                    auda();
                    // music
                    Toron();
                    timer(4);
                    audz();
                    timer(2);
                    Toroff();

                    break;


                case 13:
                    timer(8);
                    auda();
                    timer((float) 2.4);
                    audz();
                    timer((float) 12.6);
                    auda();
                    Toron();
                    timer(1);
                    audz();
                    Toroff();
                    break;

            }



        }
    }



// Log.d( tag, "test", msg: "test:if 진행 " );

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



    public static void  timer(float a){
        try {

            Thread.sleep((long) (3600000 *a));

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