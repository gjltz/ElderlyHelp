package com.example.elderlyhelp;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {

    private final int WELCOME_DISPLAY_LONG = 3000;      //欢迎页延迟播放3s

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        },WELCOME_DISPLAY_LONG);
    }
}
