package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.Profile;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.MainLauncher;

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        if (Profile.getCurrentProfile() != null) {
            Profile profile = Profile.getCurrentProfile();
            Uri userPhoto = profile.getProfilePictureUri(300, 300);
            String id = profile.getId();
            String name = profile.getName();
            Intent i = new Intent(MainActivity.this, ActivityLauncher.class);
            i.putExtra("name", name);
            startActivity(i);
        }

        Button main_fb_btn = (Button) findViewById(R.id.main_fb_btn);
        main_fb_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FacebookActivity.class);
                startActivity(i);
            }
        });

        Button main_line_btn = (Button) findViewById(R.id.main_line_btn);
        main_line_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LineActivity.class);
                startActivity(i);
            }
        });

    }
}
