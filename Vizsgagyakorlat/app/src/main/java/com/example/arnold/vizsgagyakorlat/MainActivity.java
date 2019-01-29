package com.example.arnold.vizsgagyakorlat;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_CODE_GET_FORM_DATA=1014;
    public ArrayList<Product> productList;
    public ProductListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView productListView=(ListView)findViewById(R.id.listView);
        Product product = new Product("4548","Allview X2 Soul",500.50);
        Product product2 = new Product("6574","Samsung SmartTv",1900.40);
        productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        adapter = new ProductListAdapter(this,R.layout.adapter_view_layout,productList);
        productListView.setAdapter(adapter);
        registerForContextMenu(productListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mycontext_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.deleteID:
                productList.remove(info.position);
                adapter.notifyDataSetChanged();
                Toast.makeText(this,"Product deleted",Toast.LENGTH_SHORT).show();
                return true;
             default:
                 return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivityForResult(intent,REQUEST_CODE_GET_FORM_DATA);
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(this,Main3Activity.class);
                startActivity(intent2);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            productList.add(new Product(data.getStringExtra("code"),data.getStringExtra("name"),Double.parseDouble(data.getStringExtra("price"))));
            adapter.notifyDataSetChanged();
            Toast.makeText(this,"Product added",Toast.LENGTH_SHORT).show();
        }
    }

}
