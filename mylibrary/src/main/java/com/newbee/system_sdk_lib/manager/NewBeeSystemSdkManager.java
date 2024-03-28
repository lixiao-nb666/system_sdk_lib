package com.newbee.system_sdk_lib.manager;

import android.content.Context;
import android.provider.Settings;
import android.view.KeyEvent;

import com.newbee.audio_manager_lib.NewBeeAudioUtil;
import com.newbee.system_key_lib.system_key_input.SystemKeyCodeInput;
import com.newbee.system_key_lib.systemkey.SystemKeyEventListen;
import com.newbee.system_sdk_lib.util.CmdUtil;

public abstract class NewBeeSystemSdkManager  {

    public abstract Context getContext();


    private SystemKeyCodeInput systemKeyCodeInput=new SystemKeyCodeInput();



    public NewBeeSystemSdkManager(){

    }

    public NewBeeSystemSdkInterFace getSdkInterFace(){
        return sdkInterFace;
    }

    private NewBeeAudioUtil newBeeAudioUtil;
    private NewBeeAudioUtil getNewBeeAudioUtil(){
        if(null==newBeeAudioUtil){
            synchronized (NewBeeSystemSdkManager.class){
                if(null==newBeeAudioUtil){
                    newBeeAudioUtil=new NewBeeAudioUtil(getContext());
                }
            }
        }
        return newBeeAudioUtil;
    }


    private NewBeeSystemSdkInterFace sdkInterFace=new NewBeeSystemSdkInterFace() {
        @Override
        public void cmd(String cmd) {
            CmdUtil.execCommand(cmd);
        }

        @Override
        public void powerOff() {
            CmdUtil.execCommand("reboot -p");
        }

        @Override
        public void reboot() {
            CmdUtil.execCommand("reboot");
        }

        @Override
        public void setUiResolution(int w, int h) {
            String DISPLAY_SIZE_FORCED = "display_size_forced";
            Settings.Global.putString(getContext().getContentResolver(), DISPLAY_SIZE_FORCED, w + "," + h);
        }

        @Override
        public void setShowDensity(int density) {
            CmdUtil.execCommand("wm density "+density);
        }

        @Override
        public void setFontSize(float size) {
            Settings.System.putFloat(getContext().getContentResolver(), Settings.System.FONT_SCALE, 1.0f);//设置字体大小
        }

        @Override
        public boolean systemVolumeUp() {
            systemKeyCodeInput.inputKeyCode(KeyEvent.KEYCODE_VOLUME_UP);
            return true;
        }

        @Override
        public boolean systemVolumeDown() {
            systemKeyCodeInput.inputKeyCode(KeyEvent.KEYCODE_VOLUME_DOWN);
            return true;
        }

        @Override
        public boolean volumeUp(boolean showUi) {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.valueUp(showUi);
            }
            return false;
        }

        @Override
        public boolean volumeDown(boolean showUi) {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.valueDown(showUi);
            }
            return false;
        }

        @Override
        public boolean volumeLoop(boolean showUi) {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.valueLoop(showUi);
            }
            return false;
        }

        @Override
        public int getVolumeNowNumb() {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.getVolume();
            }
            return -1;
        }

        @Override
        public int getVolumeMaxNumb() {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.getMaxVolume();
            }
            return -1;
        }

        @Override
        public boolean setVolume(int v, boolean showUi) {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.setVolume(v,showUi);
            }
            return false;
        }

        @Override
        public boolean setVolumeByPercentage(int v, boolean showUi) {
            if(null!=newBeeAudioUtil){
                return newBeeAudioUtil.setVolumeByPercentage(v,showUi);
            }
            return false;
        }

    };




}
