package com.example.arnold.hazi1;
import java.math.BigInteger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double eredmeny=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText szam1=(EditText)findViewById(R.id.editText);
        final EditText szam2=(EditText)findViewById(R.id.editText2);
        final TextView tvEredmeny=(TextView)findViewById(R.id.textView4);
        final TextView tvOutput=(TextView)findViewById(R.id.textView5);
        final Button btnPlus=(Button)findViewById(R.id.button);
        final Button btnMinus=(Button)findViewById(R.id.button2);
        final Button btnMultiplication=(Button)findViewById(R.id.button3);
        final Button btnDivide=(Button)findViewById(R.id.button4);
        final Button btnSzamol=(Button)findViewById(R.id.button6);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              eredmeny=Double.parseDouble(szam1.getText().toString())+Double.parseDouble(szam2.getText().toString());
              tvOutput.setText(szam1.getText()+"+"+szam2.getText());
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 eredmeny=Double.parseDouble(szam1.getText().toString())-Double.parseDouble(szam2.getText().toString());
                 tvOutput.setText(szam1.getText()+"-"+szam2.getText());

            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 eredmeny=Double.parseDouble(szam1.getText().toString())*Double.parseDouble(szam2.getText().toString());
                 tvOutput.setText(szam1.getText()+"*"+szam2.getText());

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 eredmeny=Double.parseDouble(szam1.getText().toString())/Double.parseDouble(szam2.getText().toString());
                 tvOutput.setText(szam1.getText()+"/"+szam2.getText());

            }
        });
        btnSzamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEredmeny.setText(Double.toString(eredmeny));
                eredmeny=0;
                tvOutput.setText("");
            }
        });

    }
}
