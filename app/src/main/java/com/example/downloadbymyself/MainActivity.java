package com.example.downloadbymyself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String yandex= "https://yandex.ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadTask downloadTask = new DownloadTask();
        String rez=null;
        try{
            rez = downloadTask.execute(yandex).get();
        }catch (Exception e){
            Log.i("test",e.toString());

        }
        Log.i("test",rez);
    }
}