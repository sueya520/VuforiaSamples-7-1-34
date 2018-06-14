package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

public class Shine2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shine2);


        Button god1 = (Button) findViewById(R.id.god1);
        god1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //sendMesg();
                Intent i = new Intent(Shine2.this, God1.class);
                startActivity(i);
            }
        });
    }
}
