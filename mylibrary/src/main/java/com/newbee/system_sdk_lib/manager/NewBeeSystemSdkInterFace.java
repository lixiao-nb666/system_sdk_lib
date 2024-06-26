package com.newbee.system_sdk_lib.manager;

import android.content.Context;

public interface NewBeeSystemSdkInterFace {

    public void cmd(String cmd);

    public void powerOff();

    public void reboot();

    public void setUiResolution(int w, int h);

    public void setShowDensity(int density);

    public void setFontSize(float size);

    public boolean systemVolumeUp();

    public boolean systemVolumeDown();

    public boolean volumeUp(boolean showUi);

    public boolean volumeDown(boolean showUi);

    public boolean volumeLoop(boolean showUi);

    public int getVolumeNowNumb();

    public int getVolumeMaxNumb();

    public boolean setVolume(int v,boolean showUi);

    public boolean setVolumeByPercentage(int v,boolean showUi);


    public boolean luminanceUp();

    public boolean luminanceDown();

    public boolean luminanceLoop();

    public int getLuminanceNowNumb();

    public int getLuminanceMaxNumb();

    public void setLuminance(int v);


}
