package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import com.vuforia.samples.VuforiaSamples.R;

public class ImagePlay extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_play);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        //GridView的點選事件, 傳入int position知user點選哪一個item
        gridview.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView parent, View v, int position, long id)
            {
                //Toast.makeText(ImagePlay.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
