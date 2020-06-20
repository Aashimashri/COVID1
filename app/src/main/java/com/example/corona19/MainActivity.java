package com.example.corona19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.corona19.Country.AffectedCountries;
import com.example.corona19.Graph.GraphWiseReport;
import com.example.corona19.Videos.vaccine;
import com.example.corona19.Videos.video;
import com.example.corona19.measures.Measures;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView txt_total, txt_active, txt_recovered, txt_deaths, txt_updated;
    private CardView card_today, card_tests,card_graph, card_state,card_measures,card_country,card_video,card_vaccine;

    //RequestQueue object declaration for fetching the data from API.
    private RequestQueue requestQueue;

    //JSONObject declaration for storing the fetched data.
    private JSONObject response1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_total=findViewById(R.id.txt_total);
        txt_active=findViewById(R.id.txt_active);
        txt_recovered=findViewById(R.id.txt_recovered);
        txt_deaths=findViewById(R.id.txt_deaths);
        txt_updated=findViewById(R.id.txt_updated);
        card_today=findViewById(R.id.card_today);
        card_tests=findViewById(R.id.card_tests);
        card_state=findViewById(R.id.card_state);
        card_graph=findViewById(R.id.card_graph);
        card_measures=findViewById(R.id.card_measures);
        card_country=findViewById(R.id.card_country);
        card_video=findViewById(R.id.card_video);
        card_vaccine=findViewById(R.id.card_vaccine);



        //Creating a new Volley request for fetching the data.
        requestQueue= Volley.newRequestQueue(this);

        //Calling the method for fetching the data.
        parseJson();

        card_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TodayCases.class);
                try {

                    //Fetching a JSONArray "statewise: from the API.
                    JSONArray array=response1.getJSONArray("statewise");
                    JSONObject object=array.getJSONObject(0);

                    //Passing the fetched data to TodayCases activity.
                    intent.putExtra("confirmed", object.getString("deltaconfirmed"));
                    intent.putExtra("deaths", object.getString("deltadeaths"));
                    intent.putExtra("lastUpdated", object.getString("lastupdatedtime"));
                    intent.putExtra("recovered", object.getString("deltarecovered"));
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        card_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TestsReport.class);
                try {
                    JSONArray array=response1.getJSONArray("tested");
                    JSONObject object=array.getJSONObject(array.length()-1);
                    intent.putExtra("totalsamplestested", object.getString("totalsamplestested"));
                    intent.putExtra("lastUpdated", object.getString("updatetimestamp"));
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        card_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, StateWiseReport.class);
                startActivity(intent);
            }
        });

        card_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this, GraphWiseReport.class);
               startActivity(intent);

            }
        });

        card_measures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Measures.class);
                startActivity(intent);

            }
        });
        card_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AffectedCountries.class);
                startActivity(intent);

            }
        });
        card_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, video.class);
                startActivity(intent);
            }
        });
        card_vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, vaccine.class);
                startActivity(intent);
            }
        });
    }

    //Method for fetching the API data.
    private void parseJson() {

        //Url for fetching the data.
        String url="https://api.covid19india.org/data.json";

        //Fetching JSON Object from the API.
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                response1=response;
                try {
                    JSONArray array=response.getJSONArray("statewise");
                    JSONObject object=array.getJSONObject(0);
                    txt_active.setText(object.getString("active"));
                    txt_total.setText(object.getString("confirmed"));
                    txt_recovered.setText(object.getString("recovered"));
                    txt_deaths.setText(object.getString("deaths"));
                    String lastUpdated="Last Updated: "+ object.getString("lastupdatedtime");
                    txt_updated.setText(lastUpdated);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        //Adding the request to the RequestQueue object.
        requestQueue.add(request);
    }
}