/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.security;

import java.security.MessageDigest;

/**
 *
 * @author 207163413
 */
public class PasswordEncrypt {

    public PasswordEncrypt()
    {
    }

    public String encrypt(String str){
        StringBuffer retString = new StringBuffer();
        try{
            MessageDigest alg = MessageDigest.getInstance("MD5","SUN");

            String myVar = str;

            byte bs[] = myVar.getBytes();

            byte digest[] = alg.digest(bs);
            for(int i=0;i<digest.length;++i){
                retString.append(Integer.toHexString(0x0100 +(digest[i] & 0x00FF)).substring(1));
            }
        }catch(Exception e){
            System.out.println("there appears to have been an error" + e);
        }
        return retString.toString();
    }
}


























































