package com.company.salemedicine;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToStore extends AppCompatActivity {

    EditText Name;
    EditText Price;
    EditText Quantity;
    Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_store);

        Init();
        OnClick();
    }


    private void Init() {
        Name=findViewById(R.id.Name_Edittext);
        Price=findViewById(R.id.Price_Edittext);
        Quantity=findViewById(R.id.Quantity_Edittext);
        Add=findViewById(R.id.Add);
    }


    private void OnClick() {
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validate()){

                }
            }
        });
    }

    private boolean Validate() {

        if (Name.getText().length()<=0){
            Name.setError("Required item");
            return false;
        }
        else if (Price.getText().length()<=0){
            Price.setError("Required item");
            return false;
        }
        else if (Quantity.getText().length()<=0){
            Quantity.setError("Required item");
                return false;
        }else {
            return true;
        }
    }
}
