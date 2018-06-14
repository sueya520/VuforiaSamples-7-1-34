package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.vuforia.samples.VuforiaSamples.R;
import java.io.File;
import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileInputStream;

public class Record extends Activity {

    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private Button start,stop,play,next;
    String uid = "", tag = "", blessName = "", blessType = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        Intent intent = this.getIntent();
        uid = intent.getStringExtra("uid");
        tag = intent.getStringExtra("tag");
        blessName = intent.getStringExtra("blessName");
        blessType = intent.getStringExtra("blessType");

        start = (Button)findViewById(R.id.button1);
        stop = (Button)findViewById(R.id.button2);
        play = (Button)findViewById(R.id.button3);
        next = (Button)findViewById(R.id.button4);

        stop.setEnabled(false);
        play.setEnabled(false);
        try{
            File f = File.createTempFile("myrecording", null, getCacheDir());
            outputFile = f.getAbsolutePath();
        }catch (IOException e){

        }

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Record.this, RecordNext.class);
                i.putExtra("path",outputFile);
                i.putExtra("uid",uid);
                i.putExtra("tag",tag);
                i.putExtra("blessName",blessName);
                startActivity(i);
            }
        });

    }

    public void start(View view){
        try {
            myAudioRecorder = new MediaRecorder();
            myAudioRecorder.reset();
            myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            myAudioRecorder.setOutputFile(outputFile);
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        start.setEnabled(false);
        stop.setEnabled(true);
        //Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();

    }

    public void stop(View view){
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder  = null;
        stop.setEnabled(false);
        start.setEnabled(true);
        play.setEnabled(true);
        //Toast.makeText(getApplicationContext(), "Audio recorded successfully",
        //        Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void play(View view) throws IllegalArgumentException,
            SecurityException, IllegalStateException, IOException{

        MediaPlayer m = new MediaPlayer();
        m.setDataSource(outputFile);
        m.prepare();
        m.start();
        //Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
/*
        try{
            if(outputFile == null){return;}
            FileInputStream inputStream = new FileInputStream(outputFile);
            byte[] bytes = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while (inputStream.read(bytes) != -1){
                sb.append(new String(bytes));
            }
            //displayText.setText(sb.toString());
            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
*/
    }

}