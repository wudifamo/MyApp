package com.kk.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private CardSlidePanel.CardSwitchListener cardSwitchListener;

    private List<CardDataItem> dataList = new ArrayList<CardDataItem>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        CardSlidePanel slidePanel = (CardSlidePanel) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {

            @Override
            public void onShow(int index) {
              //  Log.d("CardFragment", "正在显示-" + dataList.get(index).userName);
            }

            @Override
            public void onCardVanish(int index, int type) {
             //   Log.d("CardFragment", "正在消失-" + dataList.get(index).userName + " 消失type=" + type);
            }

            @Override
            public void onItemClick(View cardView, int index) {
             //   Log.d("CardFragment", "卡片点击-" + dataList.get(index).userName);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.fillData(dataList);
    }

    private void prepareDataList() {

        CardDataItem dataItem=new CardDataItem();
        dataItem.language = "Android";
        StringBuffer sb = new StringBuffer();
        sb.append("编程工具:Android Studio Eclipse\n");
        sb.append("网络通信:HttpResponse,基于HttpUrlConnection的断点续传下载,Socket\n");
        sb.append("数据库:Sqlite sharedpreferences\n" +
                "推送:xmpp,腾讯信鸽,百度云推送\n" +
                "数据解析:String解析,json解析,html解析\n" +
                "图片缓存:SDWebImage\n" +
                "媒体:相机Camera,AlarmManager\n" +
                "其他实用功能:Badgeview,微信分享,自定义View,锁屏悬浮窗,电话查询(字母排序、右侧导航索引),弹窗多选单选");
        dataItem.content=sb.toString();
        dataItem.imgId=R.mipmap.l_bg5;

        CardDataItem dataItem1=new CardDataItem();
        dataItem1.language = "IOS";
        dataItem1.content="编程语言:Objective-c、swift 2.0\n" +
                "编程工具:Xcode,Interface Builder\n" +
                "网络通信:http协议 Socket\n" +
                "数据库:Coredata, NSUserDefaults\n" +
                "推送:APNS,腾讯信鸽\n" +
                "数据解析:String解析,json解析,html解析\n" +
                "图片缓存:SDWebImage\n" +
                "媒体:相机Camera,闹钟AlarmManager\n" +
                "其他实用功能:Badgeview,微信分享,自定义View,电话查询(字母排序、右侧导航索引),弹窗多选单选,自定义pagingview\n";

        dataItem1.imgId=R.mipmap.l_bg3;

        CardDataItem dataItem2=new CardDataItem();
        dataItem2.language = "PC端BS";
        dataItem2.content="编程语言:JAVA  \n" +
                "编程工具:MyEclipse\n" +
                "数据库:MySql\n" +
                "架构:基于Struts2 spring的MVC\n" +
                "其他实用功能:Ajax 表格导出excel";

        dataItem2.imgId=R.mipmap.l_bg4;

        CardDataItem dataItem3=new CardDataItem();
        dataItem3.language = "其他技能包";
        dataItem3.content="Photoshop:可抵半个美工  \n" +
                "AfterEffects:会做Dota Top10集锦\n"+
        "Github:星星数多达1个(- -)\n"+
        "stackoverflow:英文版百度知道";

        dataItem3.imgId=R.mipmap.l_bg1;

        for (int i = 0; i < 10; i++) {
            dataList.add(dataItem);
            dataList.add(dataItem1);
            dataList.add(dataItem2);
            dataList.add(dataItem3);

        }

    }



}
