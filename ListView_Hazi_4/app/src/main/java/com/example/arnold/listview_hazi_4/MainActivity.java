package com.example.arnold.listview_hazi_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
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

    Double[] buyArray = {4.4100, 3.9750, 6.1250, 2.9600, 3.0950, 4.2300, 0.5850, 0.0136};
    Double[] sellArray = {4.5500, 4.1450, 6.3550, 3.0600, 3.2650, 4.3300, 0.6150, 0.0146};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter adapter =new CustomListAdapter(this,nameArray,infoArray,imageArray,buyArray,sellArray);
        listview = (ListView)findViewById(R.id.listviewID);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("info",infoArray[position]);
                intent.putExtra("price",buyArray[position]);
                startActivity(intent);
            }
        });
    }
}
