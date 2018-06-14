package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.share.model.ShareLinkContent;
import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.MainLauncher;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class ScreenPrint extends Activity
{
    //擷取畫面按鈕
    private Button mBtn;
    //截圖的畫面
    private ImageView mImg;

    String uid = "", tag = "",imgPath = "", audioPath = "", blessName="", selectImg = "", blessType="";
    String name = "";
    LinearLayout splly;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    RelativeLayout rbg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_print);

        rbg = (RelativeLayout)findViewById(R.id.rbg);
        rbg.setBackgroundResource(R.drawable.b_bless_3);

        mBtn = (Button) findViewById(R.id.screen_print_next);
        //splly = (LinearLayout)findViewById(R.id.splly);

        //splly.setVisibility(View.VISIBLE);
        mBtn.setVisibility(View.VISIBLE);

        if (Profile.getCurrentProfile() != null) {
            Profile profile = Profile.getCurrentProfile();
            Uri userPhoto = profile.getProfilePictureUri(300, 300);
            String id = profile.getId();
            name = profile.getName();
        }

        TextView fb_name = (TextView) findViewById(R.id.fb_name);
        //fb_name.setText(name+"送上祝福");
        TextView bless_name = (TextView) findViewById(R.id.bless_name);
        bless_name.setText(name+"送上祝福");
/*
        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ScreenPrint.this, AboutScreen.class);
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
                Intent i = new Intent(ScreenPrint.this, AboutScreen.class);
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
                Intent i = new Intent(ScreenPrint.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ScreenPrint.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ScreenPrint.this, OfflineMap.class);
                startActivity(i);
            }
        });
*/
        Intent intent = this.getIntent();
        uid = intent.getStringExtra("uid");
        tag = intent.getStringExtra("tag");
        audioPath = intent.getStringExtra("audioPath");
        blessName = intent.getStringExtra("blessName");
        selectImg = intent.getStringExtra("selectImg");
        blessType = intent.getStringExtra("blessType");

        TextView bless_tx = (TextView)findViewById(R.id.bless_tx);
        bless_tx.setText("給予"+blessName+"的祝福");
        //取得Button與ImageView元件
        mImg = (ImageView) findViewById(R.id.screen_print_img);

        if("A".equals(blessType)){
            //平安智慧
            if("0".equals(selectImg)){
                mImg.setImageResource(R.drawable.b1);
            }else if("1".equals(selectImg)){
                mImg.setImageResource(R.drawable.b2);
            }else if("2".equals(selectImg)){
                mImg.setImageResource(R.drawable.b3);
            }
        }else if("B".equals(blessType)){
            //生子求產
            if("0".equals(selectImg)){
                mImg.setImageResource(R.drawable.b4);
            }else if("1".equals(selectImg)){
                mImg.setImageResource(R.drawable.b5);
            }
        }else if("D".equals(blessType)){
            //考試學業
            if("0".equals(selectImg)){
                mImg.setImageResource(R.drawable.b6);
            }else if("1".equals(selectImg)){
                mImg.setImageResource(R.drawable.b7);
            }else if("2".equals(selectImg)){
                mImg.setImageResource(R.drawable.b8);
            }

        }else if("E".equals(blessType)){
            //財運事業
            if("0".equals(selectImg)){
                mImg.setImageResource(R.drawable.b9);
            }else if("1".equals(selectImg)){
                mImg.setImageResource(R.drawable.b10);
            }else if("2".equals(selectImg)){
                mImg.setImageResource(R.drawable.b11);
            }
        }else if("C".equals(blessType)){
            //戀愛婚姻
            if("0".equals(selectImg)){
                mImg.setImageResource(R.drawable.b12);
            }else if("1".equals(selectImg)){
                mImg.setImageResource(R.drawable.b13);
            }else if("2".equals(selectImg)){
                mImg.setImageResource(R.drawable.b14);
            }
        }


        TextView sc_tx = (TextView)findViewById(R.id.sc_tx);
        if("A".equals(blessType)){
            //sc_tx.setText("來自註生娘娘的祝福");
        }else if("B".equals(blessType)){

        }else if("C".equals(blessType)){

        }

        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .build();

        //點擊按鈕觸發
        mBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText screen_print_input = (EditText)findViewById(R.id.screen_print_input);
                //String url = "http://pegamid.azurewebsites.net/api/Blessing/UploadRawDataFile/?uuid="+9+"&img=img";
                //imgPath = "/storage/emulated/0/pippo.png";
                //uploadMedia(url, imgPath);
                /*
                try {
                    POST_Data(url, imgPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                */
                //mImg.setImageBitmap(getScreenShot());
                String blessText = screen_print_input.getText().toString();
                if("".equals(blessText)){
                    Toast.makeText(getApplicationContext(), "還沒有留下祝福內容喔！表達心意後再進行下一步",
                            Toast.LENGTH_LONG).show();
                }else{
                    //splly.setVisibility(View.INVISIBLE);
                    mBtn.setVisibility(View.INVISIBLE);
                    rbg.setBackgroundResource(R.drawable.look_pic_2);
                    getScreenShot();
                    Intent i = new Intent(ScreenPrint.this, PhoneAndPassword.class);
                    i.putExtra("uid",uid);
                    i.putExtra("tag",tag);
                    i.putExtra("imgPath",imgPath);
                    i.putExtra("audioPath",audioPath);
                    i.putExtra("blessName",blessName);
                    i.putExtra("blessText",blessText);
                    startActivity(i);
                }

            }
        });

        //Button screen_print_btn = (Button) findViewById(R.id.screen_print_btn);

    }

    public void play(View view) throws IllegalArgumentException,
            SecurityException, IllegalStateException, IOException{
        if(audioPath!=null && audioPath!=""){
            MediaPlayer m = new MediaPlayer();
            m.setDataSource(audioPath);
            m.prepare();
            m.start();
        }
        //Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
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


    private void uploadMedia(String url, String path) {
        try {

            String charset = "UTF-8";
            File uploadFile1 = new File(path);
            if(uploadFile1.exists()){
                System.out.println(uploadFile1.getName());
            }
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
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

    //將全螢幕畫面轉換成Bitmap
    public Bitmap getScreenShot()
    {
        //藉由View來Cache全螢幕畫面後放入Bitmap
        View mView = getWindow().getDecorView();
        mView.setDrawingCacheEnabled(true);
        mView.buildDrawingCache();
        Bitmap mFullBitmap = mView.getDrawingCache();

        //取得系統狀態列高度
        Rect mRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(mRect);
        int mStatusBarHeight = mRect.top;

        //取得手機螢幕長寬尺寸
        int mPhoneWidth = getWindowManager().getDefaultDisplay().getWidth();
        int mPhoneHeight = getWindowManager().getDefaultDisplay().getHeight();

        //將狀態列的部分移除並建立新的Bitmap
        Bitmap mBitmap = Bitmap.createBitmap(mFullBitmap, 0, mStatusBarHeight, mPhoneWidth, mPhoneHeight - mStatusBarHeight);
        //將Cache的畫面清除
        mView.destroyDrawingCache();

        imgPath = saveToInternalStorage(mBitmap, "pic");

        File f = null;
        try {
            f = File.createTempFile("img", null, getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
        String filename = "pippo.png";
        File sd = Environment.getExternalStorageDirectory();
        File dest = new File(sd, filename);

        try {
            FileOutputStream out = new FileOutputStream(dest);
            mBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        //imgPath = f.getAbsolutePath();
        //imgPath = "/sdcard/pippo.png";
        return mBitmap;
    }

    private String saveToInternalStorage(Bitmap bitmapImage, String filename){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,filename + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mypath.getAbsolutePath();
    }
}