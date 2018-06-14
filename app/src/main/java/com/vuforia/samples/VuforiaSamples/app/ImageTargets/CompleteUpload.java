package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareButton;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class CompleteUpload extends Activity
{
    String uid = "", tag = "", audioPath = "", imgPath = "",
            blessName="", blessText = "", api02URL = "", phone = "", password = "";
    String shareUrl = "http://pegamid.azurewebsites.net/get_share.html";
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_upload);

        ImageView card_send_img = (ImageView) findViewById(R.id.card_send_img);
        card_send_img.setBackgroundResource(R.drawable.card_send);

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
                Intent i = new Intent(CompleteUpload.this, AboutScreen.class);
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
                Intent i = new Intent(CompleteUpload.this, AboutScreen.class);
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
                Intent i = new Intent(CompleteUpload.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(CompleteUpload.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(CompleteUpload.this, OfflineMap.class);
                startActivity(i);
            }
        });


        Intent intent = this.getIntent();
        audioPath = intent.getStringExtra("audioPath");
        imgPath = intent.getStringExtra("imgPath");
        uid = intent.getStringExtra("uid");
        tag = intent.getStringExtra("tag");
        phone = intent.getStringExtra("phone");
        password = intent.getStringExtra("password");
        blessName = intent.getStringExtra("blessName");
        blessText = intent.getStringExtra("blessText");

        if(phone==null)
            phone = "";
        if(password==null)
            password = "";
        if(blessName==null)
            blessName = "";
        if(blessText==null)
            blessText = "";
        //first call api01
        JSONObject obj = httpGet("http://pegamid.azurewebsites.net/api/Blessing/SendBlessing?msg="+blessName+","+blessText+"&phone="+phone+"&pwd="+password);
        if(obj!=null){
            try {
                uid = (String)obj.get("uid");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                tag = (String)obj.get("tag");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        shareUrl+="?uid="+uid;
        //upload img
        String url = "http://pegamid.azurewebsites.net/api/Blessing/UploadRawDataFile/?uuid="+uid+"&img=img";
        //uploadMedia(url, imgPath);
        try {
            POST_Data(url, imgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //upload audio
        //url = "http://pegamid.azurewebsites.net/api/Blessing/UploadRawDataFile/?uuid="+uid+"&audio=audio";
        //uploadMedia(url, audioPath);
        //api02
        api02URL = "http://pegamid.azurewebsites.net/api/Blessing/ReadBlessing?uid="+uid;
        obj = httpGet(api02URL);
        TextView textView = (TextView)findViewById(R.id.complete_text);
        //try {
            //textView.setText((String)obj.get("msg")+(String)obj.get("audiourl")+","+(String)obj.get("imgurl"));
            //url = "http://pegamid.azurewebsites.net/api/Blessing/ReadBlessing?uid=";
            textView.setText("pegamid.azurewebsites.net");
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                copyMsg(shareUrl);
            }
        });
        //} catch (JSONException e) {
        //    e.printStackTrace();
        //}




        Button shareButton = (Button)findViewById(R.id.fb_btn);
        shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //LoginManager.getInstance().logOut();
                if (MessageDialog.canShow(ShareLinkContent.class)) {
                    fbShare();
                }else{
                    Toast.makeText(getApplicationContext(), "您尚未安裝Messenger，請先完成安裝", Toast.LENGTH_LONG).show();
                }

            }
        });

        Button lineShareButton = (Button)findViewById(R.id.line_btn);
        lineShareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLineMesg(shareUrl);
            }
        });
    }

    public void fbShare(){
        /*
        MessageDialog messageDialog = new MessageDialog(this);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(shareUrl))
                .build();
        messageDialog.show(CompleteUpload.this, content);
*/
        //copyMsg(uid, tag);
        MessageDialog shareDialog = new MessageDialog(this);
        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(shareUrl))
                .build();
        //shareDialog.show(linkContent);
        shareDialog.show(CompleteUpload.this, linkContent);
    }

    public void copyMsg(String msg){
        ClipboardManager _clipboard = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        _clipboard.setText(msg);
        Toast.makeText(getApplicationContext(), "已複製訊息:"+msg, Toast.LENGTH_LONG).show();
    }

    private void uploadMedia(String url, String path) {
        try {

            String charset = "UTF-8";
            File uploadFile1 = new File(path);
            if(uploadFile1.exists()){
                System.out.println(uploadFile1.getName());
            }
            String requestURL = url;

            MultipartUtility multipart = new MultipartUtility(requestURL, charset);

//            multipart.addHeaderField("User-Agent", "CodeJava");
//            multipart.addHeaderField("Test-Header", "Header-Value");

            multipart.addFilePart("uploadedfile", uploadFile1);

            List<String> response = multipart.finish();

            Log.v("rht", "SERVER REPLIED:");

            for (String line : response) {
                Log.v("rht", "Line : "+line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JSONObject httpGet(String surl) {
        JSONObject jsonObject = null;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            URL url = new URL(surl);
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

    public void sendLineMesg(String msg) {
        String test = "http://line.me/R/msg/text/?"+msg ;
        Uri uri = Uri.parse(test);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    public String POST_Data(String UPLOAD_SERVER, String filepath) throws Exception {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        InputStream inputStream = null;
        String boundary =  "*****"+Long.toString(System.currentTimeMillis())+"*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        String[] q = filepath.split("/");
        int idx = q.length - 1;
        File file = new File(filepath);
        if(!file.exists()){
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        URL url = new URL(UPLOAD_SERVER);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
        outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes("--" + boundary + "\r\n");
        outputStream.writeBytes("Content-Disposition: form-data; name=\"" + "img_upload" + "\"; filename=\"" + q[idx] +"\"" + "\r\n");
        outputStream.writeBytes("Content-Type: image/jpeg" + "\r\n");
        outputStream.writeBytes("Content-Transfer-Encoding: binary" + "\r\n");
        outputStream.writeBytes("\r\n");
        bytesAvailable = fileInputStream.available();
        bufferSize = Math.min(bytesAvailable, 1048576);
        buffer = new byte[bufferSize];
        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        while(bytesRead > 0) {
            outputStream.write(buffer, 0, bufferSize);
            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, 1048576);
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        }
        outputStream.writeBytes("\r\n");
        outputStream.writeBytes("--" + boundary + "--" + "\r\n");
        inputStream = connection.getInputStream();
        int status = connection.getResponseCode();
        if (status == 201) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            inputStream.close();
            connection.disconnect();
            fileInputStream.close();
            outputStream.flush();
            outputStream.close();
            return response.toString();
        } else {
            throw new Exception("Non ok response returned");
        }
    }
}
