package com.example.downloadbymyself;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        URL url=null;
        HttpURLConnection urlConnection=null;
        StringBuilder stringBuilder = new StringBuilder();

        try{

            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line!=null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }


        }catch (Exception e){

        } finally {
            urlConnection.disconnect();

        }
        return stringBuilder.toString();
    }
}
