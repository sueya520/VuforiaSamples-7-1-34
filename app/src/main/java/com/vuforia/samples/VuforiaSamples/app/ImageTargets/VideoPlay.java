package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.vuforia.samples.VuforiaSamples.R;
import android.widget.MediaController;

public class VideoPlay extends Activity {
    private VideoView vidView;
    private MediaController vidControl;
    String vidAddress = "https://youtu.be/mji9K7WaNEE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
/*
        vidView = (VideoView) findViewById(R.id.myVideo);
        vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);

        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);
        vidView.start();
*/
        startActivity(new Intent( Intent.ACTION_VIEW, Uri.parse( vidAddress ) ));
    }
}
