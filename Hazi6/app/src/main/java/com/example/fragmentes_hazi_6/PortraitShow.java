package com.example.fragmentes_hazi_6;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class PortraitShow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.showselectedview);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String info = extras.getString("name");
            Double price = extras.getDouble("buy", 0);
            TextView textView = (TextView)findViewById(R.id.selectedopt);
            textView.setText("You have selected " + info + " worth: " + price.toString());
        }
    }
}
