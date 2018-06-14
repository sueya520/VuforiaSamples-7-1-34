package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.vuforia.samples.VuforiaSamples.R;

public class Shine extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shine);
        ImageView _imageView1 =(ImageView)findViewById(R.id.scrollimage);
        _imageView1.setImageResource(0);
        _imageView1.setBackgroundResource(R.drawable.img);
        AnimationDrawable _animaition = (AnimationDrawable)_imageView1.getBackground();
        _animaition.start();//启动

        ImageView imgv = (ImageView)findViewById(R.id.scrollimagetext);
        imgv.setImageResource(R.drawable.content_welcome);

        boolean flag = true;
        _imageView1.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             ImageView imgv = (ImageView)findViewById(R.id.scrollimagetext);
             imgv.setImageResource(R.drawable.content);
             //TextView tx = (TextView) findViewById(R.id.scrollimagetext);
             //tx.setText("本寺自清朝建立至今\n擁有許多珍貴的文化遺跡\n推薦你來探索湧蓬之美");
             Button startbtn = (Button) findViewById(R.id.startbtn);
             Button goldbtn = (Button) findViewById(R.id.goldbtn);
             startbtn.setVisibility(View.VISIBLE);
             goldbtn.setVisibility(View.VISIBLE);
             if (".".equals(startbtn.getText())) {
                 startbtn.setText("..");
                 startbtn.setBackgroundResource(R.drawable.startbtn);
                 //tx.setText("本寺自清朝建立至今\n擁有許多珍貴的文化遺跡\n推薦你來探索湧蓬之美");
                 imgv.setImageResource(R.drawable.content2);
             } else {

                 startbtn.setText(".");
                 startbtn.setBackgroundResource(R.drawable.startbtnmdpi);
             }

             if (".".equals(goldbtn.getText())) {
                 goldbtn.setText("..");
                 goldbtn.setBackgroundResource(R.drawable.goldbtnmdpi);
             } else {
                 goldbtn.setText(".");
                 goldbtn.setBackgroundResource(R.drawable.goldbtn);
             }

             Button eduemdpi = (Button) findViewById(R.id.eduemdpi);
             Button sonmdpi = (Button) findViewById(R.id.sonmdpi);
             Button moneymdpi = (Button) findViewById(R.id.moneymdpi);
             eduemdpi.setVisibility(View.GONE);
             sonmdpi.setVisibility(View.GONE);
             moneymdpi.setVisibility(View.GONE);
             sonmdpi.setBackgroundResource(R.drawable.sonmdpi);

             Button gpsbtn = (Button) findViewById(R.id.gpsbtn);
             gpsbtn.setVisibility(View.GONE);
         }
     });

        Button startbtn =(Button)findViewById(R.id.startbtn);
        Button goldbtn =(Button)findViewById(R.id.goldbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*
                Button startbtn =(Button)findViewById(R.id.startbtn);
                Button goldbtn =(Button)findViewById(R.id.goldbtn);
                startbtn.setBackgroundResource(R.drawable.startbtn);
                goldbtn.setBackgroundResource(R.drawable.goldbtnmdpi);
                */
            }
        });

        goldbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*
                Button startbtn =(Button)findViewById(R.id.startbtn);
                Button goldbtn =(Button)findViewById(R.id.goldbtn);
                startbtn.setBackgroundResource(R.drawable.startbtnmdpi);
                goldbtn.setBackgroundResource(R.drawable.goldbtn);
                */
                Button startbtn =(Button)findViewById(R.id.startbtn);
                Button goldbtn =(Button)findViewById(R.id.goldbtn);
                startbtn.setVisibility(View.GONE);
                goldbtn.setVisibility(View.GONE);

                Button eduemdpi = (Button) findViewById(R.id.eduemdpi);
                Button sonmdpi = (Button) findViewById(R.id.sonmdpi);
                Button moneymdpi = (Button) findViewById(R.id.moneymdpi);
                eduemdpi.setVisibility(View.VISIBLE);
                sonmdpi.setVisibility(View.VISIBLE);
                moneymdpi.setVisibility(View.VISIBLE);
            }
        });

        Button sonmdpi = (Button) findViewById(R.id.sonmdpi);
        sonmdpi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button sonmdpi = (Button) findViewById(R.id.sonmdpi);
                sonmdpi.setBackgroundResource(R.drawable.son2mdpi);

                Button gpsbtn = (Button) findViewById(R.id.gpsbtn);
                gpsbtn.setVisibility(View.VISIBLE);
            }
        });
    }
}
