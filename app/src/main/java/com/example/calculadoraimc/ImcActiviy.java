package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActiviy extends AppCompatActivity {
    String name;
    Double weight, height;

    TextView tvName, tvHeight, tvWeight, tvIMC, tvClassfication;
    DecimalFormat decimalFormat =new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        weight = bundle.getDouble("weight");
        height = bundle.getDouble("height");

        tvName=findViewById(R.id.tvName);
        tvWeight=findViewById(R.id.tvWeight);
        tvHeight=findViewById(R.id.tvHeight);
        tvIMC=findViewById(R.id.tvIMC);
        tvClassfication=findViewById(R.id.tvClassfication);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tvName.setText(name);
        tvWeight.setText(weight.toString());
        tvHeight.setText(height.toString());
        Double imc = calculateIMC(weight, height);
        tvIMC.setText( decimalFormat.format(imc));
        tvClassfication.setText(checkIMC(imc));

    }

    public Double calculateIMC(Double weight, Double height){
        Double imc = weight/(height*height);
        return imc;
    }

    public String checkIMC(Double imc){
        if(imc < 18.5){
            return "Abaixo do peso.";
        }
        if(imc > 18.6 && imc < 24.9){
            return "Peso ideal.";
        }
        if(imc > 25.0 && imc < 29.9){
            return "Levemente acima do peso.";
        }
        if(imc > 30.0 && imc < 34.9){
            return "Obesidade I | Moderada";
        }
        if(imc > 35.0 && imc < 39.9){
            return "Obesidade II | Severa";
        }
        return "Obesidade III | Mórbida";
    }

}