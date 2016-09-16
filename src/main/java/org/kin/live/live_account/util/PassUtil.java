package org.kin.live.live_account.util;

/**
 * Created by kingsir on 16-9-16.
 */
public class PassUtil {

    public static String getPass(String userId,String pass){
        String str = userId + pass.length() + pass;
        String md5pass = MD5Util.encryptMD5(str);
        System.out.println(md5pass);
        return md5pass;
    }
}
