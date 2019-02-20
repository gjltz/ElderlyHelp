package com.example.elderlyhelp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar mToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        //设置是否有返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void goToMaps(View v){
        Intent intentMap = new Intent(Menu.this,Map.class);
        startActivity(intentMap);
    }

    public void goSettings(View v){
        Intent intentSettings = new Intent(Menu.this,Settings.class);
        startActivity(intentSettings);
    }
}
