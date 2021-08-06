package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String greeting=getResources().getString(R.string.greeting);
        button = (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openActivity2();
            }
        });
        checkLanguage();

    }
    public void openActivity2(){
        Intent intent = new Intent(this, M2.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if (itemId== R.id.action_english){
            setLocale("en");
            recreate();

        }
        else if (itemId==R.id.action_rutooro){
            setLocale("");
            recreate();

        }
        else {
            setLocale("");
            recreate();

        }
        return super.onOptionsItemSelected(item);
    }
    public void setLocale(String language){
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("my_prefs", Context.MODE_PRIVATE).edit();
        editor.apply();
    }
    public void checkLanguage(){
        SharedPreferences preferences=getSharedPreferences("my_prefs",Context.MODE_PRIVATE);
        String language=preferences.getString("language", "");
        setLocale(language);
    }

}