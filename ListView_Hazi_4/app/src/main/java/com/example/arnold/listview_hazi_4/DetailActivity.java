package com.example.arnold.listview_hazi_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String info = getIntent().getStringExtra("info");
        Double price = getIntent().getDoubleExtra("price",0);
        TextView tv1 = (TextView)findViewById(R.id.textView);
        TextView tv2 = (TextView)findViewById(R.id.textView7);
        tv1.setText(info);
        tv2.setText(price.toString());
    }
}
