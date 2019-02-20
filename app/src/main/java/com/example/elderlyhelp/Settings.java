package com.example.elderlyhelp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.os.Bundle;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar mToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        //设置是否有返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //实现返回功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
