package com.example.volleyjsonrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myURL = "https://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22";

        Button mybutton = findViewById(R.id.buttonapi);

       mybutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,

                       new Response.Listener<JSONObject>() {
                           @Override
                           public void onResponse(JSONObject response) {

                               Log.i("JSON ", "JSON Response is " + response);

                        /*     try {
                                   String coord = response.getString("coord");
                                   JSONObject result = new JSONObject(coord);
                                   String lat = result.getString("lat");
                                   String lon = result.getString("lon");

                                   Log.i("Longitude","Longitude :" +lon);
                                   Log.i("Lattitude","Latitude :" +lat);
                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }*/

                          /*   try {
                                   String weather = response.getString("weather");
                                   JSONArray arr = new JSONArray(weather);
                                   for(int i = 0; i<arr.length(); i++){

                                       JSONObject parObj = arr.getJSONObject(i);

                                       String main = parObj.getString("main");
                                       String des = parObj.getString("description");

                                       Log.i("main", "main : " +main);
                                       Log.i("des","description: "+des);


                                   }

                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
*/
                               try {
                                   String info = response.getString("main");
                                   JSONObject res = new JSONObject(info);
                                   String temp = res.getString("temp");
                                   Double celcius =  Double.parseDouble(temp)- 273.16;

                                   Log.i("temp","Temperature in Celcius" +celcius);

                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
                           }
                       },

                       new Response.ErrorListener() {
                           @Override
                           public void onErrorResponse(VolleyError error) {

                               Log.i("Error","Error " +error);
                           }
                       }

               );

               MySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
           }
       });
    }
}
