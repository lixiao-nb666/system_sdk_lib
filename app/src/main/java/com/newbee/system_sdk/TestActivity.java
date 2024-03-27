package com.newbee.system_sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.newbee.bulid_lib.mybase.activity.BaseCompatActivity;
import com.newbee.system_sdk_lib.manager.NewBeeSystemSdkManager;
import com.newbee.system_sdk_lib.util.CmdUtil;

public class TestActivity extends BaseCompatActivity {

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            newBeeSystemSdkManager.reboot();
        }
    };
    NewBeeSystemSdkManager newBeeSystemSdkManager;

    @Override
    public int getViewLayoutRsId() {
        return 0;
    }

    @Override
    public void initView() {
        newBeeSystemSdkManager=new NewBeeSystemSdkManager(this);
        newBeeSystemSdkManager.setUiResolution(this,1920,1080);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        String str1=CmdUtil.execCommand("wm size 854x480");
//        newBeeSystemSdkManager.reboot();
//        Log.i("kankanzhi","kankandaodishiduoshao:1-"+str1);
        String str2=CmdUtil.execCommand("wm density 240");

//        String str3=CmdUtil.execCommand("wm size 1708x960");
//        String str4=CmdUtil.execCommand("wm density 240");
        Log.i("kankanzhi","kankandaodishiduoshao:2-"+str2);
        handler.sendEmptyMessageDelayed(1,3000);
//        newBeeSystemSdkManager.reboot();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initControl() {

    }

    @Override
    public void closeActivity() {

    }

    @Override
    public void viewIsShow() {

    }

    @Override
    public void viewIsPause() {

    }

    @Override
    public void changeConfig() {

    }


}
