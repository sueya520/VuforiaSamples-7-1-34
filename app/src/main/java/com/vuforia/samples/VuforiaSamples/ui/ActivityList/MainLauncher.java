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
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.Bless;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.OfflineMap;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.ScreenPrint;
import com.vuforia.samples.VuforiaSamples.app.ImageTargets.Traffic;

// This activity starts activities which demonstrate the Vuforia features
public class MainLauncher extends Activity
{
    
    private String mActivities[] = { "香爐","導覽"};
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainLauncher.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", mActivities[0]);
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                startActivity(i);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainLauncher.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", mActivities[1]);
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets2");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                startActivity(i);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainLauncher.this, Bless.class);
                startActivity(i);
            }
        });

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainLauncher.this, OfflineMap.class);
                startActivity(i);
            }
        });

        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainLauncher.this, Traffic.class);
                startActivity(i);
            }
        });

    }

}
