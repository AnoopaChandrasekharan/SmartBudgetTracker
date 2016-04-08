package com.example.anu.smartbudgettracker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;


import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
 PieChart pieChart;

    public Dashboard() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        pieChart=(PieChart) view.findViewById(R.id.pcPieChart);
        ArrayList<Entry> entries= new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));

        PieDataSet pieDataSet= new PieDataSet(entries,"$" );
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        ArrayList<String> labels=new ArrayList<>();
        labels.add("food");
        labels.add("rent");
        labels.add("entertainment");
        labels.add("travel");
        PieData pieData=new PieData(labels,pieDataSet);
        pieData.setValueTextSize(15);
        pieChart.setData(pieData);

        pieChart.setDescription("Spending details of current month");
        pieChart.setDrawHoleEnabled(false);
        pieChart.setDescriptionTextSize(20);

        //pieChart.setHoleColorTransparent(false);

        pieChart.animateXY(500,500);



        return view;
    }

}
