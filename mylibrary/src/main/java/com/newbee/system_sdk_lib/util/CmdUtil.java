package com.newbee.system_sdk_lib.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdUtil {



    public static String execCommand(String command)  {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec(command);
            try {
                if (proc.waitFor() != 0) {
                    System.err.println("exit value = " + proc.exitValue());
                }
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        proc.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();

                String line = null;

                while ((line = in.readLine()) != null) {

                    stringBuffer.append(line+" ");

                }
                return stringBuffer.toString();

            } catch (InterruptedException e) {
                return e.toString();
            }finally{
                try {
                    proc.destroy();
                } catch (Exception e2) {

                }

            }
        }catch (Exception e){
            return e.toString();
        }
    }
}
