package com.example.corona19.measures;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.corona19.R;

public class Precautions extends AppCompatActivity {
    ListView lw;
    MyCustomBaseAdapter cba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);
        int image[]={R.mipmap.stayhome,R.mipmap.washhands,R.mipmap.covercough,R.mipmap.distance,R.mipmap.putmask,R.mipmap.donttoucheyes,
                R.mipmap.helpline};
        String data [] = {"Stay Home","Wash hands often","Cover your cough","Keep distance","Put Mask",
                "Don’t touch your eyes, nose or mouth","SICK?Call the helpline"};
        lw = findViewById(R.id.listview);
        cba = new  MyCustomBaseAdapter(getApplicationContext(),image,data);
        lw.setAdapter(cba);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),cba.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
