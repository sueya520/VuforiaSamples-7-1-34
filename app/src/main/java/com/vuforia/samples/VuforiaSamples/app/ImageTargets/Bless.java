package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

public class Bless extends Activity
{
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bless);

        ImageView index = (ImageView) findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Bless.this, ActivityLauncher.class);
                startActivity(i);
            }
        });

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);



        /*
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                    .build();
            shareDialog.show(linkContent);
        }
        */
        // this part is optional
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        Button blessbtn = (Button) findViewById(R.id.blessbtn);
        blessbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //sendMesg();
                Intent i = new Intent(Bless.this, BlessType.class);
                startActivity(i);
            }
        });


    }

    public void sendMesg() {
        String test = "http://line.me/R/msg/text/?"+"hello" ;
        Uri uri = Uri.parse(test);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
 /*
        ComponentName cn = new ComponentName("jp.naver.line.android"
                , "jp.naver.line.android.activity.selectchat.SelectChatActivity");
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        //Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(Bless.getContentResolver(), bitmap, null,null));
        //shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        //shareIntent.setType("image/jpeg"); //图片分享
        shareIntent.setType("text/plain"); // 纯文本
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "分享的标题");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "分享的内容");
        shareIntent.setComponent(cn);//跳到指定APP的Activity
        startActivity(Intent.createChooser(shareIntent,""));
        */
    }

}
