package com.example.corona19.Videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.corona19.R;

import java.util.ArrayList;
import java.util.List;

public class vaccine extends AppCompatActivity {
    AnyChartView anyChartView;
    String[] category = {"Drug","Diagnostic test","Biological","Diatery Supplement","Behavioural"};
    int[] trials = {284,85,35,21,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();

    }
    public void setupPieChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for(int i =0;i< category.length;i++){
            dataEntries.add(new ValueDataEntry(category[i],trials[i]));

        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }
}

