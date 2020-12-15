package com.example.corona19.measures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.corona19.R;
import com.example.corona19.measures.Precautions;
import com.example.corona19.measures.Symptom;

public class Measures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measures);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menubar:
                Intent intent = new Intent(this, Precautions.class);
                startActivity(intent);

                break;
            case R.id.symptom:
                Intent intent1 = new Intent(this, Symptom.class);
                startActivity(intent1);

                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
