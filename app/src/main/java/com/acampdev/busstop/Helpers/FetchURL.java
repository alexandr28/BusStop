package com.acampdev.busstop.Helpers;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchURL extends AsyncTask<String, Void, String>{

    Context context;
    String directionMode="driving";

    public FetchURL(Context context){this.context=context;}

    @Override
    protected String doInBackground(String... strings) {
        String data="";
        directionMode = strings[1];
        try{
            data=downloadURL(strings[0]);
            Log.d("log","Background task Data "+ data);
        }catch (Exception e){Log.d("Background Task",e.toString());}
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        PointsParser pointsParser= new PointsParser(context,directionMode);
        pointsParser.execute(s);
    }

    private String downloadURL(String strURL) throws IOException{
        String data="";
        InputStream inputStream = null;
        HttpURLConnection urlConnection=null;
        try{
            URL url= new URL(strURL);
            urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            inputStream=urlConnection.getInputStream();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer=new StringBuffer();
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            data=stringBuffer.toString();
            Log.d("log","Downloaded URL: "+ data);
            bufferedReader.close();
        }catch (Exception e){
            Log.d("log","Exception downloaded URL: "+ e.toString());
        }finally {
            assert inputStream != null;
            inputStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}
