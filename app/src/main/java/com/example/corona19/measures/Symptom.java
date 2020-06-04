package com.example.corona19.measures;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.corona19.R;

public class Symptom extends AppCompatActivity {
    ListView lw;
    MyCustomBaseAdapter1 cba1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        int image[]={R.mipmap.fever,R.mipmap.chestpain,R.mipmap.diffinbreath,R.mipmap.tired,R.mipmap.headache,R.mipmap.drycough,
                R.mipmap.sorethroat};
        String data [] = {"fever","chest pain or pressure","difficulty breathing","tiredness","headache",
                "dry cough","sore throat"};
        lw = findViewById(R.id.listviewsy);
        cba1 = new  MyCustomBaseAdapter1(getApplicationContext(),image,data);
        lw.setAdapter(cba1);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),cba1.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
