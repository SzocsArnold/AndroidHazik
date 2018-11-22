package com.example.arnold.hazi_5_contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    String[] list = {"nyuszi","kecske","barany","vakond","hod"};
    ArrayList<String> elemek = new ArrayList<String>(Arrays.asList(list));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listviewID);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,elemek );
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.piros:
                info.targetView.setBackgroundColor(Color.RED);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.zold:
                info.targetView.setBackgroundColor(Color.GREEN);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.sarga:
                info.targetView.setBackgroundColor(Color.YELLOW);
                adapter.notifyDataSetChanged();
            default :
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rendez:
                Collections.sort(elemek, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareToIgnoreCase(s2);
                    }
                });
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"List sorted alphabetically",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.torol:
                elemek.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"List cleared",Toast.LENGTH_SHORT).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
