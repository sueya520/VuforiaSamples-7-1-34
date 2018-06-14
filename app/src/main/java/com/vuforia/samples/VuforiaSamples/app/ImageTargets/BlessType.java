package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URI;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.ClipboardManager;

public class BlessType extends Activity
{
    String blessType = "", name = "";
    Button blesstypebtn1, blesstypebtn2, blesstypebtn3, blesstypebtn4, blesstypebtn5;
    Button next;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blesstype);

        Intent intent = this.getIntent();
        name = intent.getStringExtra("name");

        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(BlessType.this, AboutScreen.class);
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
                Intent i = new Intent(BlessType.this, AboutScreen.class);
                i.putExtra("ABOUT_TEXT_TITLE", "AR導覽");
                //i.setClassName(ActivityLauncher.this, AboutScreen.class);
                i.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets3");
                i.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                i.putExtra("name", name);
                mClassToLaunchPackage = getPackageName();
                mClassToLaunch = mClassToLaunchPackage + ".app.ImageTargets.ImageTargets3";
                i.setClassName(mClassToLaunchPackage, mClassToLaunch);
                startActivity(i);
            }
        });

        ImageView btn3 = (ImageView) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(BlessType.this, BlessType.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(BlessType.this, Traffic.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(BlessType.this, OfflineMap.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        });

        blesstypebtn1 = (Button) findViewById(R.id.blesstypebtn1);
        blesstypebtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blessType = "A";
                blesstypebtn1.setBackgroundResource(R.drawable.ping2);
                blesstypebtn2.setBackgroundResource(R.drawable.son1);
                blesstypebtn3.setBackgroundResource(R.drawable.love1);
                blesstypebtn4.setBackgroundResource(R.drawable.test1);
                blesstypebtn5.setBackgroundResource(R.drawable.work1);
                next.setVisibility(View.VISIBLE);
                //nextStep();
            }
        });
        blesstypebtn2 = (Button) findViewById(R.id.blesstypebtn2);
        blesstypebtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blessType = "B";
                blesstypebtn1.setBackgroundResource(R.drawable.ping1);
                blesstypebtn2.setBackgroundResource(R.drawable.son2);
                blesstypebtn3.setBackgroundResource(R.drawable.love1);
                blesstypebtn4.setBackgroundResource(R.drawable.test1);
                blesstypebtn5.setBackgroundResource(R.drawable.work1);
                next.setVisibility(View.VISIBLE);
                //nextStep();
            }
        });
        blesstypebtn3 = (Button) findViewById(R.id.blesstypebtn3);
        blesstypebtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blessType = "C";
                blesstypebtn1.setBackgroundResource(R.drawable.ping1);
                blesstypebtn2.setBackgroundResource(R.drawable.son1);
                blesstypebtn3.setBackgroundResource(R.drawable.love2);
                blesstypebtn4.setBackgroundResource(R.drawable.test1);
                blesstypebtn5.setBackgroundResource(R.drawable.work1);
                next.setVisibility(View.VISIBLE);
                //nextStep();
            }
        });
        blesstypebtn4 = (Button) findViewById(R.id.blesstypebtn4);
        blesstypebtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blessType = "D";
                blesstypebtn1.setBackgroundResource(R.drawable.ping1);
                blesstypebtn2.setBackgroundResource(R.drawable.son1);
                blesstypebtn3.setBackgroundResource(R.drawable.love1);
                blesstypebtn4.setBackgroundResource(R.drawable.test2);
                blesstypebtn5.setBackgroundResource(R.drawable.work1);
                next.setVisibility(View.VISIBLE);
                //nextStep();
            }
        });
        blesstypebtn5 = (Button) findViewById(R.id.blesstypebtn5);
        blesstypebtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blessType = "E";
                blesstypebtn1.setBackgroundResource(R.drawable.ping1);
                blesstypebtn2.setBackgroundResource(R.drawable.son1);
                blesstypebtn3.setBackgroundResource(R.drawable.love1);
                blesstypebtn4.setBackgroundResource(R.drawable.test1);
                blesstypebtn5.setBackgroundResource(R.drawable.work2);
                next.setVisibility(View.VISIBLE);
                //nextStep();
            }
        });
        next = (Button) findViewById(R.id.next);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextStep();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int vWidth = dm.widthPixels;
        int vHeight = dm.heightPixels;
        int sub = vWidth/5;
        blesstypebtn1.setX(0);
        blesstypebtn2.setX(10);
        blesstypebtn3.setX(20);
        blesstypebtn4.setX(30);
        blesstypebtn5.setX(40);

    }

    public void fbShare(){
        //ClipboardManager _clipboard = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        //_clipboard.setText("12333");
    }

    public void nextStep(){
        EditText et = (EditText)findViewById(R.id.bless_type_edit_text);
        String input = et.getText()+"";

        Intent i = new Intent(BlessType.this, RecordNext.class);
        i.putExtra("blessType",blessType);
        i.putExtra("blessName",input);
        startActivity(i);
    };

    public JSONObject httpGet() {
        JSONObject jsonObject = null;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        String parpms = "test";
        try {
            URL url = new URL("http://pegamid.azurewebsites.net/api/Blessing/SendBlessing?msg="+parpms);
            URLConnection conn = null;
            try {
                conn = url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = in.readLine();
                while(line!=null){
                    sb.append(line);
                    line = in.readLine();
                }
                try {
                    jsonObject = new JSONObject(sb.toString());
                    System.out.println(jsonObject.get("uid"));
                    System.out.println(jsonObject.get("tag"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }



}
