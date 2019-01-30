package com.example.arnold.hazi_5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> nameArray = new ArrayList<>();
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameArray.addAll(Arrays.asList("Marci","Peter","Janos","Kinga","Hanna","Reka","Anett"));

        listView = findViewById(R.id.listView);


        adapter = new ArrayAdapter<>(MainActivity.this,R.layout.simple_list,R.id.textView,nameArray);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.pirosID:
                info.targetView.setBackgroundColor(Color.RED);
                adapter.notifyDataSetChanged();
                break;
            case R.id.sargaID:
                info.targetView.setBackgroundColor(Color.YELLOW);
                adapter.notifyDataSetChanged();
                break;
            case R.id.zoldID:
                info.targetView.setBackgroundColor(Color.GREEN);
                adapter.notifyDataSetChanged();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.torolID:
                nameArray.clear();
                adapter.notifyDataSetChanged();
                break;
            case R.id.rendezID:
                Collections.sort(nameArray);
                adapter.notifyDataSetChanged();
               break;
            default:
                break;
        }
        return true;
    }
}
