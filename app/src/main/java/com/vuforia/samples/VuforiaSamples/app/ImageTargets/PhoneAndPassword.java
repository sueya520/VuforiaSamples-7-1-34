package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

public class PhoneAndPassword extends Activity {

    String blessText = "",  blessName="", imgPath ="";
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_password);

        ImageView card_send_img = (ImageView) findViewById(R.id.card_open_img);
        card_send_img.setBackgroundResource(R.drawable.card_open);

        AnimationDrawable animationDrawable = (AnimationDrawable) card_send_img
                .getBackground();

        // 動畫是否正在運行
        if (animationDrawable.isRunning()) {
            // 停止動畫播放
            animationDrawable.stop();
        }else {
            // 開始或者繼續動畫播放
            animationDrawable.start();
        }

        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhoneAndPassword.this, AboutScreen.class);
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
                Intent i = new Intent(PhoneAndPassword.this, AboutScreen.class);
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
                Intent i = new Intent(PhoneAndPassword.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhoneAndPassword.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(PhoneAndPassword.this, OfflineMap.class);
                startActivity(i);
            }
        });


        EditText etx1 = (EditText)findViewById(R.id.etphone);
        etx1.requestFocus();

        Intent intent = this.getIntent();
        blessText = intent.getStringExtra("blessText");
        blessName = intent.getStringExtra("blessName");
        imgPath = intent.getStringExtra("imgPath");
        Button ppbtn = (Button) findViewById(R.id.ppbtn);
        ppbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText etphone = (EditText)findViewById(R.id.etphone);
                //EditText etpwd = (EditText)findViewById(R.id.etpwd);
                if(!"".equals(etphone.getText().toString())){
                    Intent i = new Intent(PhoneAndPassword.this, CompleteUpload.class);
                    i.putExtra("phone",etphone.getText()+"");
                    i.putExtra("password",etphone.getText()+"");
                    i.putExtra("blessName",blessName);
                    i.putExtra("blessText",blessText);
                    i.putExtra("imgPath",imgPath);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "欄位不得為空",
                                    Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
