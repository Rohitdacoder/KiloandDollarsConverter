package com.example.unitconvt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText edittext;

    Button button2;
    TextView textView2;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        edittext = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Getting the user input
                String str = edittext.getText().toString();

                // converting string into double
                double kilo = Double.parseDouble(str);

                // using convert method to convert kilo into grams
                double gram = Converting(kilo);

                //display the converting result
                textView.setText("" +gram);

                Toast.makeText(
                        MainActivity.this,
                        "Conversation going onn",
                        Toast.LENGTH_SHORT).show();
            }
        });

        button2 = findViewById(R.id.button2);
        editText2 = findViewById(R.id.editText2);
        textView2 = findViewById(R.id.textView2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText2.getText().toString();

                double cur = Double.parseDouble(input);

                double rupee = CunrrenyConvt(cur);

                textView2.setText(""+rupee);
            }
        });


    }

    public double Converting(double input)
    {
        return input*1000;
    }

    public double CunrrenyConvt(double inputCurrency)
    {
        return inputCurrency*83;
    }
}