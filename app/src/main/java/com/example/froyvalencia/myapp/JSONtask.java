package com.example.froyvalencia.myapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Johannes on 1/30/2016.
 */
/*public class JSONtask extends AsyncTask<String, String, String> {
    HttpURLConnection urlConn = null;
    BufferedReader reader;

    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            InputStream istream = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(istream));
            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (urlConn != null) {
                urlConn.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //tv.setText(reader.toString());
        return null;
    }

    @Override
    protected void onPostExcecute(String result){
        super.onPostExecute(result);
        //TextView tv = (TextView) findViewById(R.id.tvJsonObj);
        Scanner.tv.setText(result);
    }
}*/