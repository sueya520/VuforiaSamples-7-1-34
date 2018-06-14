package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.MainLauncher;

public class Traffic extends Activity {
    ImageView imv;
    Button traffic_btn1, traffic_btn2, traffic_btn3;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic);


        imv = (ImageView)findViewById(R.id.traffic_img);
        imv.setImageResource(R.drawable.bus_dia);

        traffic_btn1 = (Button) findViewById(R.id.traffic_btn1);
        traffic_btn1.setBackgroundResource(R.drawable.bus_2);
        traffic_btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                traffic_btn1.setBackgroundResource(R.drawable.bus_2);
                traffic_btn2.setBackgroundResource(R.drawable.mrt_1);
                traffic_btn3.setBackgroundResource(R.drawable.car_1);
                imv.setImageResource(R.drawable.bus_dia);
            }
        });

        traffic_btn2 = (Button) findViewById(R.id.traffic_btn2);
        traffic_btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                traffic_btn1.setBackgroundResource(R.drawable.bus_1);
                traffic_btn2.setBackgroundResource(R.drawable.mrt_2);
                traffic_btn3.setBackgroundResource(R.drawable.car_1);
                imv.setImageResource(R.drawable.mrt_dia);
            }
        });


        Button google_map_btn = (Button) findViewById(R.id.google_map_btn);
        google_map_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com.tw/maps");
                Intent uriIntent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(uriIntent);
            }
        });

        traffic_btn3 = (Button) findViewById(R.id.traffic_btn3);
        traffic_btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                traffic_btn1.setBackgroundResource(R.drawable.bus_1);
                traffic_btn2.setBackgroundResource(R.drawable.mrt_1);
                traffic_btn3.setBackgroundResource(R.drawable.car_2);
                imv.setImageResource(R.drawable.car_dia);
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;

        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Traffic.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", "香爐報到");
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                mClassToLaunchPackage = getPackageName();
                mClassToLaunch = mClassToLaunchPackage + ".app.ImageTargets.ImageTargets";
                i.setClassName(mClassToLaunchPackage, mClassToLaunch);
                startActivity(i);
            }
        });

        ImageView btn2 = (ImageView) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Traffic.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", "AR導覽");
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets3");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                mClassToLaunchPackage = getPackageName();
                mClassToLaunch = mClassToLaunchPackage + ".app.ImageTargets.ImageTargets3";
                i.setClassName(mClassToLaunchPackage, mClassToLaunch);
                startActivity(i);
            }
        });

        ImageView btn3 = (ImageView) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Traffic.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Traffic.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Traffic.this, OfflineMap.class);
                startActivity(i);
            }
        });

    }
}
