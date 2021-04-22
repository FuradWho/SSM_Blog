package com.spoof.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author 13375
 */
public class MD5Util {

    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }

}
