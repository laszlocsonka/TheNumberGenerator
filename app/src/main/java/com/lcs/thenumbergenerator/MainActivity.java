package com.lcs.thenumbergenerator;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    TextView textView;
    EditText num1,num2;
    int min = 0;
    int max = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        button = findViewById(R.id.generateButton);
        textView = findViewById(R.id.numberText);
        num1 = (EditText) findViewById(R.id.num1Text);
        num2 = (EditText) findViewById(R.id.num2Text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value1 = num1.getText().toString();

                String value2 = num2.getText().toString();

                if(value1.equals("") || value2.equals("")){

                    Toast.makeText(MainActivity.this, "Missing value", Toast.LENGTH_SHORT).show();

                }else{


                    min = Integer.parseInt(value1);
                    max = Integer.parseInt(value2);


                    if (max > min) {
                        Random random = new Random();
                        int num = random.nextInt((max - min) + 1) + min;
                        textView.setText(String.valueOf(num));
                    }else if(max==min) {
                        Toast.makeText(MainActivity.this, "Max is equal to Min", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Max is lower than Min", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}