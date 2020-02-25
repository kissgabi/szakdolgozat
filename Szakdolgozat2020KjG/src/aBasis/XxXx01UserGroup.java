/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aBasis;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b6dmin
 */
public class XxXx01UserGroup {

    private final String userName;
    private final String userPw;
    private final String userMD5;

    public String getUserName() {
        return userName;
    }

    public String getUserMD5() {
        return userMD5;
    }

    public String getUserPw() {
        return md5Hex(userPw);
    }

    public String getSecret() {
        return userPw;
    }

    public XxXx01UserGroup(String un, String pw, String md5) {
        this.userName = un;
        this.userPw = pw;
        this.userMD5 = md5;
    }

    private String md5Hex(String s) {
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(XxXx01UserGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "dataBase user(" + userName + ":" + userMD5 + ")";
    }
}
