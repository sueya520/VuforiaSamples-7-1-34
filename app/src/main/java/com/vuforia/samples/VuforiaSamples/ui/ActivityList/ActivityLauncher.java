/*===============================================================================
Copyright (c) 2016-2018 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/


package com.vuforia.samples.VuforiaSamples.ui.ActivityList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.BlessType;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.OfflineMap;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.Traffic;

// This activity starts activities which demonstrate the Vuforia features
public class ActivityLauncher extends Activity
{
    
    private String mActivities[] = { "香爐","導覽"};
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    String name = "";
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_list);

        Intent intent = this.getIntent();
        name = intent.getStringExtra("name");

        Button shine_btn = (Button) findViewById(R.id.shine_btn);
        shine_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", mActivities[0]);
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                i.putExtra("name", name);
                mClassToLaunchPackage = getPackageName();
                mClassToLaunch = mClassToLaunchPackage + ".app.ImageTargets.ImageTargets";
                i.setClassName(mClassToLaunchPackage, mClassToLaunch);
                startActivity(i);
            }
        });

        Button arnavibtn = (Button) findViewById(R.id.arnavibtn);
        arnavibtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", mActivities[1]);
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets3");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                i.putExtra("name", name);
                mClassToLaunchPackage = getPackageName();
                mClassToLaunch = mClassToLaunchPackage + ".app.ImageTargets.ImageTargets3";
                i.setClassName(mClassToLaunchPackage, mClassToLaunch);
                //startActivity(i);
            }
        });

        Button bless_btn = (Button) findViewById(R.id.bless_btn);
        bless_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ActivityLauncher.this, BlessType.class);
                i.putExtra("name", name);
                //startActivity(i);
            }
        });

        Button traffic_btn = (Button) findViewById(R.id.traffic_btn);
        traffic_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ActivityLauncher.this, Traffic.class);
                i.putExtra("name", name);
                //startActivity(i);
            }
        });

        Button mapgobtn = (Button) findViewById(R.id.mapgobtn);
        mapgobtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ActivityLauncher.this, OfflineMap.class);
                i.putExtra("name", name);
                //startActivity(i);
            }
        });

    }

}
