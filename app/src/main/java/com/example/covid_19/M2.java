package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M2 extends AppCompatActivity {
    private Button button;
    Button buttoncall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        buttoncall = findViewById(R.id.button3);
        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0800203033"));
                startActivity(intent);
            }

        });
    }
    public void openActivity2(){
    Intent intent=new Intent(this, E.class);
    startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this, Rutooro.class);
        startActivity(intent);
    }
}