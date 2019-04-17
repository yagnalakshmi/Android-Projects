package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //https://api.openweathermap.org/data/2.5/weather?q=Singapore&appid=20515bbd16f9db29bb734764fdcf25ad

    String baseURL = "https://api.openweathermap.org/data/2.5/weather?q=";
    String api = "&appid=20515bbd16f9db29bb734764fdcf25ad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final  EditText city = findViewById(R.id.city);
        final TextView result = findViewById(R.id.result);
        Button button = findViewById(R.id.button);
        final TextView displayTemp = findViewById(R.id.disTemp);
        final TextView displayHum = findViewById(R.id.disHum);
        final ImageView displayImg = findViewById(R.id.disImg);
        final TextView displayLat = findViewById(R.id.disLat);
        final TextView displayLong = findViewById(R.id.disLong);


        city.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    city.setHint("");
                else
                    city.setHint("Enter the city...");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(city.getText().toString().isEmpty()){

                    Toast.makeText(getApplicationContext(),"Please enter your city", Toast.LENGTH_SHORT).show();
                }
                else{

                    String myURL = baseURL + city.getText().toString() + api;

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

                          /*
                                   String weather = response.getString("weather");
                                   JSONArray arr = new JSONArray(weather);
                                   for(int i = 0; i<arr.length(); i++){

                                       JSONObject parObj = arr.getJSONObject(i);

                                       String main = parObj.getString("main");
                                       String des = parObj.getString("description");

                                       Log.i("main", "main : " +main);
                                       Log.i("des","description: "+des);



*/
                                    try {

                                        //Display the weather

                                        String weather = response.getString("weather");
                                        JSONArray arr = new JSONArray(weather);
                                        for(int i = 0; i<arr.length(); i++) {

                                            JSONObject parObj = arr.getJSONObject(i);

                                            String main = parObj.getString("main");
                                            String des = parObj.getString("description");
                                            result.setText(main);

                                            Log.i("main", "main : " + main);
                                            Log.i("des", "description: " + des);

                                            switch(main){

                                                case "Clouds":
                                                    displayImg.setImageResource(R.drawable.cloudy);
                                                    break;
                                                case "Rain":
                                                    displayImg.setImageResource(R.drawable.rainy);
                                                    break;
                                                case "Haze":
                                                    displayImg.setImageResource(R.drawable.haze);
                                                    break;
                                                case "Suuny":
                                                    displayImg.setImageResource(R.drawable.sunny);
                                                    break;
                                                default:
                                                    displayImg.setImageResource(R.drawable.other);

                                            }




                                        }

                                        //Display Temperature and Humidity

                                        String info = response.getString("main");
                                        JSONObject res = new JSONObject(info);
                                        String temp = res.getString("temp");
                                        Double celcius =  Double.parseDouble(temp)- 273.16;
                                        String temperature = String.format("%.1f", celcius);
                                       // String temperature = celcius.toString();
                                        displayTemp.setText(temperature);
                                        String humidity = res.getString("humidity");
                                        displayHum.setText(humidity);

                                        Log.i("temp","Temperature in Celcius" +celcius);

                                        // Display Latitude and Longitude

                                        String coord = response.getString("coord");
                                        JSONObject result = new JSONObject(coord);
                                        String lat = result.getString("lat");
                                        String lon = result.getString("lon");

                                        displayLat.setText(lat);
                                        displayLong.setText(lon);



                                    }

                                    catch (JSONException e) {
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
            }
        });

    }
}
