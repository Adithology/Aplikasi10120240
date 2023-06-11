package com.example.aplikasi10120240;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //(10 juni 2023, 10120240, Fahmi Anwar Sidik, IF-06)
    private static  int SPLASH_SCREEN = 4000;
    // variables
    Animation anim_top, anim_bot;
    ImageView image;
    TextView tittle, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        anim_top = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        anim_bot = AnimationUtils.loadAnimation(this, R.anim.anim_bot);

        //Hooks
        image = findViewById(R.id.ss_header);
        tittle = findViewById(R.id.ss_tittle);
        desc = findViewById(R.id.ss_descr1);


        image.setAnimation(anim_top);
        tittle.setAnimation(anim_bot);
        desc.setAnimation(anim_bot);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,WalkThrough1.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}