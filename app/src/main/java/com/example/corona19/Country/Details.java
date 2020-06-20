package com.example.corona19.Country;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.corona19.R;

public class Details extends AppCompatActivity {



    private int positionCountry;

    TextView tvCountry,tvCases,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvRecovered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Intent intent=getIntent();
        positionCountry=intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of" +AffectedCountries.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry=findViewById(R.id.tvCountry);
        tvActive=findViewById(R.id.tvActive);
        tvCases=findViewById(R.id.tvCases);
        tvCritical=findViewById(R.id.tvCritical);
        tvTodayCases=findViewById(R.id.tvTodayCases);
        tvTotalDeaths=findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths=findViewById(R.id.tvTodayDeaths);
        tvRecovered=findViewById(R.id.tvRecovered);

        tvCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
