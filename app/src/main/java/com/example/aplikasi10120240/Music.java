package com.example.aplikasi10120240;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Music extends AppCompatActivity {
    //(10 juni 2023, 10120240, Aditya Sukmadinata , IF-6)
    Context contextVideo, context;
    RecyclerView recyclerViewVideo, recyclerViewMusic;
    RecyclerView.Adapter recyclerViewAdapterVideo, recyclerViewAdapterMusic;
    RecyclerView.LayoutManager recylerViewLayoutManagerVideo, recylerViewLayoutManagerMusic;
    VideoView videoView;
    String[] subjectValuesVideo = {
            "UNDERCOVER MARTYN - TWO DOOR CINEMA CLUB"
    };
    String[] subjectUrlVideo;
    String[] subjectValuesMusic = {
            "UNDERCOVER MARTYN - TWO DOOR CINEMA CLUB"
    };
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        subjectUrlVideo=new String[]{
                "android.resource://"+getPackageName()+"/"+R.raw.video,
                "android.resource://"+getPackageName()+"/"+R.raw.video,
                "android.resource://"+getPackageName()+"/"+R.raw.video
        };
        contextVideo=getApplicationContext();
        recyclerViewVideo=findViewById(R.id.recyclerViewVideo);
        recylerViewLayoutManagerVideo=new LinearLayoutManager(this);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewVideo.setLayoutManager(recylerViewLayoutManagerVideo);
        recyclerViewAdapterVideo=new com.example.aplikasi10120240.AdapterRecycleViewVideo(subjectValuesVideo,subjectUrlVideo,this);
        recyclerViewVideo.setAdapter(recyclerViewAdapterVideo);

        context=getApplicationContext();
        recyclerViewMusic=findViewById(R.id.recyclerViewMusic);
        recylerViewLayoutManagerMusic=new LinearLayoutManager(context);
        //context,LinearLayoutManager.HORIZONTAL,false
        recyclerViewMusic.setLayoutManager(recylerViewLayoutManagerMusic);
        recyclerViewAdapterMusic=new com.example.aplikasi10120240.AdapterRecycleViewMusic(subjectValuesMusic,context);
        recyclerViewMusic.setAdapter(recyclerViewAdapterMusic);

        //ass
        drawerLayout=findViewById(R.id.DrawerLayout);
    }
    public void ClickMenu(View view){
        //Open drawer
        com.example.aplikasi10120240.HomeActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        com.example.aplikasi10120240.HomeActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        //redirect to home
        com.example.aplikasi10120240.HomeActivity.redirectActivity(this, com.example.aplikasi10120240.HomeActivity.class);
    }
    public void ClickGallery(View view){
        //redirect to gallery
        com.example.aplikasi10120240.HomeActivity.redirectActivity(this, com.example.aplikasi10120240.Gallery.class);
    }

    public void ClickDaily(View view){
        //redirect to gallery
        com.example.aplikasi10120240.HomeActivity.redirectActivity(this, com.example.aplikasi10120240.Daily.class);
    }
    public void ClickMusic(View view){

        //recreate
        recreate();
    }
    public void ClickProfile(View view){
        //redirect to profile
        com.example.aplikasi10120240.HomeActivity.redirectActivity(this, com.example.aplikasi10120240.Profile.class);
    }
    public void ClickLogout(View view){
        //close
        com.example.aplikasi10120240.HomeActivity.logout(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //close drawer
        com.example.aplikasi10120240.HomeActivity.closeDrawer(drawerLayout);
    }
}