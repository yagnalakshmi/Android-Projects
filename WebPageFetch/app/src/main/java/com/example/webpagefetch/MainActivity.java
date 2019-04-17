package com.example.webpagefetch;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


//import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


   public class SetupFetch extends AsyncTask<String, Void, String>{


       @Override
       protected String doInBackground(String... strings) {

           URL url;
           HttpsURLConnection urlConnection = null;


           try {


               url = new URL(strings[0]);
               urlConnection = (HttpsURLConnection) url.openConnection();

               InputStream inputStream = urlConnection.getInputStream();

               InputStreamReader reader = new InputStreamReader(inputStream);
               int data = reader.read();

               String wpage = " ";
               while(data != -1){

                   char storeData = (char) data;
                   wpage += storeData;
                   data = reader.read();

               }

               return wpage;

           } catch (IOException e) {
               e.printStackTrace();
               return "cannot fetch webpage";
           }
       }
   }

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         SetupFetch request = new SetupFetch();
         String page = null;

         try{

             page = request.execute("https://www.google.com/").get();
             Log.i("done","done");


         }

         catch(Exception e){

             e.printStackTrace();
         }

         Log.i("stackoverflow",page);
         Log.i("done","done");
    }
}
