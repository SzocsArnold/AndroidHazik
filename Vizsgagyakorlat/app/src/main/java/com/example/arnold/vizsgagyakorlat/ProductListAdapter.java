package com.example.arnold.vizsgagyakorlat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product> {

    private Context mContext;
    int mResource;

    public ProductListAdapter(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        String productCode = getItem(position).getProductCode();
        String productName = getItem(position).getProductName();
        Double price = getItem(position).getPrice();

        Product product = new Product(productCode,productName,price);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvCode = (TextView)convertView.findViewById(R.id.textView7);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView5);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.textView6);

        tvCode.setText(productCode);
        tvName.setText(productName);
        tvPrice.setText(price.toString());

        return convertView;

    }
}
