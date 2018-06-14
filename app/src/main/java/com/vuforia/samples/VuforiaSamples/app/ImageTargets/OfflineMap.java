package com.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.vuforia.samples.VuforiaSamples.R;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.AboutScreen;
import com.vuforia.samples.VuforiaSamples.ui.ActivityList.ActivityLauncher;

import java.util.ArrayList;

public class OfflineMap extends Activity {
    ImageView border_2f;
    ImageView ju_mon;
    ImageView offline_map;
    private String mClassToLaunch;
    private String mClassToLaunchPackage;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_map);

        border_2f = (ImageView) findViewById(R.id.border_2f);
        border_2f.setVisibility(View.INVISIBLE);

        ju_mon = (ImageView) findViewById(R.id.ju_mon);
        ju_mon.setVisibility(View.INVISIBLE);

        ImageView btn1 = (ImageView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OfflineMap.this, AboutScreen.class);
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
                Intent i = new Intent(OfflineMap.this, AboutScreen.class);
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
                Intent i = new Intent(OfflineMap.this, BlessType.class);
                startActivity(i);
            }
        });

        ImageView btn4 = (ImageView) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OfflineMap.this, Traffic.class);
                startActivity(i);
            }
        });

        ImageView btn5 = (ImageView) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OfflineMap.this, OfflineMap.class);
                startActivity(i);
            }
        });


        offline_map = (ImageView)findViewById(R.id.offline_map);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //spinner.getBackground().setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_ATOP);
/*
        ArrayAdapter<CharSequence> lunchList = ArrayAdapter.createFromResource(OfflineMap.this,
                R.array.offline_map,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(lunchList);
*/
        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("想要去哪裡",R.drawable.bg00));
        //服務單位
        list.add(new ItemData("服務處",R.drawable.bg00));//1
        list.add(new ItemData("會議室",R.drawable.bg00));//2
        list.add(new ItemData("解籤室",R.drawable.bg00));//3
        //公共設施
        list.add(new ItemData("洗淨台",R.drawable.bg00));//4
        list.add(new ItemData("金亭",R.drawable.bg00));//5
        list.add(new ItemData("化妝室",R.drawable.bg00));//6
        list.add(new ItemData("點香處",R.drawable.bg00));//7
        list.add(new ItemData("籤筒",R.drawable.bg00));//8
        list.add(new ItemData("大悲咒水",R.drawable.bg00));//9
        //一樓廟埕
        list.add(new ItemData("舊寺古蹟",R.drawable.bg00));//10
        list.add(new ItemData("電梯",R.drawable.bg00));//11
        //二樓佛祖殿
        list.add(new ItemData("南海觀音佛祖",R.drawable.bg00));//12
        list.add(new ItemData("送子觀音",R.drawable.bg00));
        list.add(new ItemData("文殊菩薩 普賢菩薩",R.drawable.bg00));
        //二樓福德宮
        list.add(new ItemData("荷蘭降鄭圖",R.drawable.bg00));
        list.add(new ItemData("延平郡王",R.drawable.bg00));//16
        list.add(new ItemData("天上聖母",R.drawable.bg00));//17
        list.add(new ItemData("註生娘娘",R.drawable.bg00));//18
        list.add(new ItemData("中壇元帥",R.drawable.bg00));//19
        list.add(new ItemData("福德正神",R.drawable.bg00));//20
        list.add(new ItemData("電梯",R.drawable.bg00));
        //二樓功德堂
        list.add(new ItemData("功德堂",R.drawable.bg00));//22
        list.add(new ItemData("地藏菩薩",R.drawable.bg00));
        list.add(new ItemData("包府千歲",R.drawable.bg00));
        list.add(new ItemData("開山祖師",R.drawable.bg00));
        //四樓玉皇殿
        list.add(new ItemData("玉皇大帝",R.drawable.bg00));//26
        list.add(new ItemData("三官大帝",R.drawable.bg00));
        list.add(new ItemData("文昌帝君",R.drawable.bg00));//28
        list.add(new ItemData("魁星爺",R.drawable.bg00));//29
        list.add(new ItemData("關聖帝君",R.drawable.bg00));//30
        list.add(new ItemData("電梯",R.drawable.bg00));

        list.add(new ItemData("金觀音",R.drawable.bg00));//32
        list.add(new ItemData("月老星君",R.drawable.bg00));//33
        list.add(new ItemData("文武財神",R.drawable.bg00));//34
        list.add(new ItemData("阿彌陀佛",R.drawable.bg00));//35
        list.add(new ItemData("藥師佛",R.drawable.bg00));//36
        list.add(new ItemData("釋迦牟尼",R.drawable.bg00));//37

        Spinner sp=(Spinner)findViewById(R.id.spinner);
        SpinnerAdapter adapter=new SpinnerAdapter(this,
                R.layout.row,R.id.txt,list);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //ImageView offline_map = (ImageView)findViewById(R.id.offline_map);
                border_2f.setVisibility(View.INVISIBLE);
                ju_mon.setVisibility(View.INVISIBLE);
                offline_map.setVisibility(View.INVISIBLE);
                if(position==0){
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map2f);
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                }else if(position==9){
                    //大悲咒水
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.bwater);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==19){
                    //中壇元帥
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.chung_shui);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==6){
                    //化妝室
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.wc_2f);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==17){
                    //天上聖母
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.sky_mon);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==22){
                    //功德堂
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.work_room);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==16){
                    //延平郡王
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.yun_king);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==1){
                    //服務處
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.sv);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==7){
                    //點香處
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.dot);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==8){
                    //籤筒
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.ton);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==2){
                    //會議室
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.meet);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==3){
                    //解籤室
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.read);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==20){
                    //福德正神
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.fu_god);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==5){
                    //金亭
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.gold);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==4){
                    //洗淨台
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.wash);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==18){
                    //註生娘娘
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.ju_mon);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==12){
                    //南海觀音佛祖
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.na_hi);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_2f);
                }else if(position==28){
                    //文昌帝君
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.wn_chen);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==32){
                    //金觀音
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.gold_god);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==33){
                    //月老星君
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.moon_god);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==34){
                    //文武財神
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.wn_wu);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==26){
                    //玉皇大帝
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.ubig);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==35){
                    //阿彌陀佛
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.amtf);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==29){
                    //魁星爺
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.star);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==36){
                    //藥師佛
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.med);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==37){
                    //釋迦牟尼
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.shu_mo);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else if(position==30){
                    //關聖帝君
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_4f);
                    ju_mon.setVisibility(View.VISIBLE);
                    ju_mon.setImageResource(R.drawable.gun_god);
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map_4f);
                }else{
                    offline_map.setVisibility(View.VISIBLE);
                    offline_map.setImageResource(R.drawable.map2f);
                    border_2f.setVisibility(View.VISIBLE);
                    border_2f.setImageResource(R.drawable.border_2f);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
