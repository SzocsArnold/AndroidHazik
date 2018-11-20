package com.example.arnold.listview_hazi_4;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;

    private final Integer[] imageIDArray;

    private final String[] nameArray;

    private final String[] infoArray;

    private final Double[] buyArray;

    private final Double[] sellArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam, Double[] buyArrayParam, Double[] sellArrayParam) {
        super(context,R.layout.listview_row,nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
        this.imageIDArray = imageIDArrayParam;
        this.buyArray = buyArrayParam;
        this.sellArray = sellArrayParam;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView nameTextField = (TextView)  rowView.findViewById(R.id.textView1);
        TextView currencyTextField = (TextView)  rowView.findViewById(R.id.textView2);
        TextView number1TextField = (TextView)  rowView.findViewById(R.id.textView5);
        TextView number2TextField = (TextView)  rowView.findViewById(R.id.textView6);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2);

        nameTextField.setText(nameArray[position]);
        currencyTextField.setText(infoArray[position]);
        number1TextField.setText(Double.toString(buyArray[position]));
        number2TextField.setText(Double.toString(sellArray[position]));
        imageView.setImageResource(imageIDArray[position]);
        return rowView;
    }

}
