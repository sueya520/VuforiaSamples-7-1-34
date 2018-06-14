package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.auth.LineLoginApi;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.MainLauncher;

public class LineActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int Code = 1;


    private ImageView faceView;


    private TextView tv_DisplayName;


    private TextView tv_Userid;


    private Button loingButton;

    private Button logoutButton;


    private LineProfile profile;


    private LineCredential credential;


    private String Channel = "1580309963";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.line);


        initView();

        if (Profile.getCurrentProfile() != null) {
            Intent i = new Intent(LineActivity.this, ActivityLauncher.class);
            startActivity(i);
        }
    }

    private void initView() {



        faceView = (ImageView) findViewById(R.id.faceImage);


        tv_DisplayName = (TextView) findViewById(R.id.DisplayName);


        tv_Userid = (TextView) findViewById(R.id.Userid);


        Intent intent = LineLoginApi.getLoginIntent(LineActivity.this, Channel);


        startActivityForResult(intent, Code);

    }

    @Override


    public void onClick(View view) {


        Intent intent = LineLoginApi.getLoginIntent(LineActivity.this, Channel);


        startActivityForResult(intent, Code);


    }

    @Override


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode != Code) {


            Log.e("ERROR", "Unsupported Request");


            return;


        }


        /** 取得回傳物件 **/


        LineLoginResult result = LineLoginApi.getLoginResultFromIntent(data);


        switch (result.getResponseCode()) {


            case SUCCESS:


                credential = result.getLineCredential();


                profile = result.getLineProfile();


                tv_DisplayName.setText(profile.getUserId());


                tv_Userid.setText(profile.getDisplayName());


                //


                //Picasso.with(MainActivity.this).load(profile.getPictureUrl()).into(faceView);
                Intent i = new Intent(LineActivity.this, ActivityLauncher.class);
                startActivity(i);
                break;


            case CANCEL:


                Log.e("ERROR", "LINE Login Canceled by user!!");


                Toast.makeText(this, "wwww", Toast.LENGTH_SHORT).show();


                break;


            default:


                Log.e("ERROR", "Login FAILED!");


                Log.e("ERROR", result.getErrorData().toString());


        }
    }
}