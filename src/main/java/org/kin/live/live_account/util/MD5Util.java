package org.kin.live.live_account.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kingsir on 16-9-16.
 */
public class MD5Util {
    public static String encryptMD5(String params){
        char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] byteArray = params.getBytes();
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(byteArray);
            byteArray = digest.digest();
            int i = byteArray.length;
            char[] charArray2 = new char[i*2];
            int j = 0;
            for(int k = 0;k<byteArray.length;++k){
                int l = byteArray[k];
                charArray2[(j++)] = charArray[(l >>> 4 & 0xF)];
                charArray2[(j++)] = charArray[(l & 0xF)];
            }
            return new String(charArray2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
