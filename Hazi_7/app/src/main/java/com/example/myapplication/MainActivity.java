package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyCustomAdapter adapter;
    List<Country> countryList;

    ListView listview;
    String[] nameArray = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};

    String[] infoArray = {"Euro",
            "Dolar american",
            "Lira sterlina",
            "Dolar austrian",
            "Dolar canadian",
            "Franc elvetian",
            "Corona daneza",
            "Forint maghiar"};

    Integer[] imageArray = {R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbp,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycle_viewID);
        countryList = new ArrayList<>();

        for(int i =0; i<8;i++){
            countryList.add(new Country(nameArray[i],infoArray[i],imageArray[i]));
        }

        adapter = new MyCustomAdapter(this,countryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
