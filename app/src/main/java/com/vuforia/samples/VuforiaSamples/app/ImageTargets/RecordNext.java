package com.vuforia.samples.VuforiaSamples.app.ImageTargets;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import android.provider.ContactsContract.Data;
import android.view.ViewGroup.LayoutParams;

public class RecordNext extends Activity {

    Socket socket;

    //從手機裡的"我的檔案"選張照片，準備傳到電腦，
    //因不同的手機路徑可能不同，可自行修改。
    public String file_name = "", uid = "", tag="", blessName ="",blessType ="", selectImg="0";
    private ViewPager viewPager;
      private PagerAdapter adapter;
      private List<View> viewPages = new ArrayList<>();
    private String mClassToLaunch;
    private String mClassToLaunchPackage;

              //包裹點點的LinearLayout
              private ViewGroup group;
      private ImageView imageView;
      //定義一個ImageVIew數組，來存放生成的小園點
              private ImageView[] imageViews;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordnext);

        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(RecordNext.this, AboutScreen.class);
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
                Intent i = new Intent(RecordNext.this, AboutScreen.class);
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
                Intent i = new Intent(RecordNext.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(RecordNext.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(RecordNext.this, OfflineMap.class);
                startActivity(i);
            }
        });

        Intent intent = this.getIntent();
        file_name = intent.getStringExtra("path");
        uid = intent.getStringExtra("uid");
        tag = intent.getStringExtra("tag");
        blessType = intent.getStringExtra("blessType");
        blessName = intent.getStringExtra("blessName");

        Button uploadbtn = (Button)findViewById(R.id.uploadbtn);
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //String url = "http://pegamid.azurewebsites.net/api/Blessing/UploadRawDataFile/?uuid="+uid+"&audio=audio";
                //uploadMedia(url, file_name);
                //httpConnectionPost("http://pegamid.azurewebsites.net/api/Blessing/UploadRawDataFile/", params, file_name);
                Intent i = new Intent(RecordNext.this, ScreenPrint.class);
                i.putExtra("uid",uid);
                i.putExtra("tag",tag);
                i.putExtra("audioPath",file_name);
                i.putExtra("blessName",blessName);
                i.putExtra("selectImg",selectImg);
                i.putExtra("blessType",blessType);
                startActivity(i);
            }
        });

        initView();
        initPageAdapter();
        initPointer();
        initEvent();
    }




    private void uploadMedia(String url, String path) {
        try {

            String charset = "UTF-8";
            File uploadFile1 = new File(path);
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

    public static String getJSONString(Map<String, String> params){
        JSONObject json = new JSONObject();
        for(String key:params.keySet()) {
            try {
                json.put(key, params.get(key));
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return json.toString();
    }

    //為控制項綁定事件,綁定適配器
      private void initEvent() {
                 viewPager.setAdapter(adapter);
                 viewPager.addOnPageChangeListener(new GuidePageChangeListener());
             }

              //初始化ViewPager
              private void initPageAdapter() {
                 /**
                   * 對於這幾個想要動態載入的page頁面，使用LayoutInflater.inflate()來找到其佈局文件，並實例化為View對象
                   */
                 LayoutInflater inflater = LayoutInflater.from(this);
                 View page1 = inflater.inflate(R.layout.pagebless1, null);
                 View page2 = inflater.inflate(R.layout.pagebless2, null);
                 View page3 = inflater.inflate(R.layout.pagebless3, null);
                  View page4 = inflater.inflate(R.layout.pagebless4, null);
                  View page5 = inflater.inflate(R.layout.pagebless5, null);
                  View page6 = inflater.inflate(R.layout.pagebless6, null);
                  View page7 = inflater.inflate(R.layout.pagebless7, null);
                  View page8 = inflater.inflate(R.layout.pagebless8, null);
                  View page9 = inflater.inflate(R.layout.pagebless9, null);
                  View page10 = inflater.inflate(R.layout.pagebless10, null);
                  View page11 = inflater.inflate(R.layout.pagebless11, null);
                  View page12 = inflater.inflate(R.layout.pagebless12, null);
                  View page13 = inflater.inflate(R.layout.pagebless13, null);
                  View page14 = inflater.inflate(R.layout.pagebless14, null);

                 //添加到集合中
                  if("A".equals(blessType)){
                      //平安智慧
                      viewPages.add(page1);
                      viewPages.add(page2);
                      viewPages.add(page3);
                  }else if("B".equals(blessType)){
                      //生子求產
                      viewPages.add(page4);
                      viewPages.add(page5);
                  }else if("D".equals(blessType)){
                      //考試學業
                      viewPages.add(page6);
                      viewPages.add(page7);
                      viewPages.add(page8);

                  }else if("E".equals(blessType)){
                      //財運事業
                      viewPages.add(page9);
                      viewPages.add(page10);
                      viewPages.add(page11);
                  }else if("C".equals(blessType)){
                      //戀愛婚姻
                      viewPages.add(page12);
                      viewPages.add(page13);
                      viewPages.add(page14);
                  }











                 adapter = new PagerAdapter() {
              //獲取當前界面個數
                      @Override
              public int getCount() {
                                 return viewPages.size();
                             }

                      //判斷是否由對象生成頁面
                      @Override
              public boolean isViewFromObject(View view, Object object) {
                                 return view == object;
                             }

                      @Override
              public void destroyItem(ViewGroup container, int position, Object object) {
                                 container.removeView(viewPages.get(position));
                             }

                      //返回一個對象，這個對象表明瞭PagerAdapter適配器選擇哪個對象放在當前的ViewPager中
                      @Override
              public Object instantiateItem(ViewGroup container, int position) {
                                 View view = viewPages.get(position);
                                 container.addView(view);
                                 return view;
                             }
          };
             }

              //綁定控制項
              private void initView() {
                 viewPager = (ViewPager) findViewById(R.id.viewPager);
                 group = (ViewGroup) findViewById(R.id.viewGroup);
             }

              //初始化下麵的小圓點的方法
              private void initPointer() {
                 //有多少個界面就new多長的數組
                 imageViews = new ImageView[viewPages.size()];
                 for (int i = 0; i < imageViews.length; i++) {
                         imageView = new ImageView(this);
                         //設置控制項的寬高
                         imageView.setLayoutParams(new LayoutParams(25, 25));
                         //設置控制項的padding屬性
                         imageView.setPadding(20, 0, 20, 0);
                         imageViews[i] = imageView;
                         //初始化第一個page頁面的圖片的原點為選中狀態

                         if (i == 0) {
                                 //表示當前圖片
                                 //imageViews[i].setBackgroundResource(R.drawable.iicon);
                                 /**
                                   * 在java代碼中動態生成ImageView的時候
                                   * 要設置其BackgroundResource屬性才有效
                                   * 設置ImageResource屬性無效
                                   */

                             } else {
                                 //imageViews[i].setBackgroundResource(R.drawable.iicon2);
                             }

                         group.addView(imageViews[i]);
                     }
             }

             //ViewPager的onPageChangeListener監聽事件，當ViewPager的page頁發生變化的時候調用
             public class GuidePageChangeListener implements ViewPager.OnPageChangeListener {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                     }

                 //頁面滑動完成後執行
                 @Override
         public void onPageSelected(int position) {
                     selectImg = position+"";
                         //判斷當前是在那個page，就把對應下標的ImageView原點設置為選中狀態的圖片
                         for (int i = 0; i < imageViews.length; i++) {
                                 //imageViews[position].setBackgroundResource(R.drawable.iicon);
                                 if (position != i) {
                                         //imageViews[i].setBackgroundResource(R.drawable.iicon2);
                                     }
                             }
                     }

                 //監聽頁面的狀態，0--靜止  1--滑動   2--滑動完成
                 @Override
         public void onPageScrollStateChanged(int state) {

                     }
     }


}