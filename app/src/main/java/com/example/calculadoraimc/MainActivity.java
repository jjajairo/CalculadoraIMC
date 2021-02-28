package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edName, edWeight, edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.edName);
        edWeight=findViewById(R.id.edWeight);
        edHeight=findViewById(R.id.edHeight);
    }

    public void calculaImc(View v){
        String name = edName.getText().toString();
        Double weight = Double.parseDouble( edWeight.getText().toString() );
        Double height = Double.parseDouble( edHeight.getText().toString() );

        Intent i= new Intent(this, ImcActiviy.class);

        i.putExtra("name", name);
        i.putExtra("weight", weight);
        i.putExtra("height", height);

        startActivity(i);
    }
}