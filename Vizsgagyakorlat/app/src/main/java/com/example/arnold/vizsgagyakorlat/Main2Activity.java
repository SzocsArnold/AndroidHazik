package com.example.arnold.vizsgagyakorlat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btnAddProduct;
    EditText editTextCode;
    EditText editTextName;
    EditText editTextprice;
    Button btnCancel;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView)findViewById(R.id.textView);

        btnAddProduct = (Button)findViewById(R.id.button);
        btnCancel = (Button)findViewById(R.id.button2);

        editTextCode = (EditText)findViewById(R.id.editText);
        editTextName = (EditText)findViewById(R.id.editText2);
        editTextprice = (EditText)findViewById(R.id.editText3);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("code",editTextCode.getText().toString());
                intent.putExtra("name",editTextName.getText().toString());
                intent.putExtra("price",editTextprice.getText().toString());

                setResult(Activity.RESULT_OK,intent);

                finish();
            }
        });



    }
}
