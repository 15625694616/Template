package com.template.demos.utils;

import cn.hutool.crypto.digest.DigestUtil;

import java.util.Random;

public class CharUtil {


    /**
     * 根据手机号 密码生成token
     */
    public static String createToken(String phone,String pass){
        String salt="abc";
        String token = DigestUtil.md5Hex(phone+salt+pass);
        System.out.println(token);
        return token;
    }
    /**
     * *（后台用）
     * 根据用户名 密码生成token
     */
    public static String createTokenByUserName(String username,String pass){
        String randomNum = getRandomNum(2);
        String token = DigestUtil.md5Hex(username+randomNum+pass);
        return token;
    }


    public static void main(String[] args) {
        while (true) {
            String token = createToken("15819949269","123");
            System.out.println(token);
        }
    }
    /**
     * 隐藏手机号或用户名 用*代替
     * @param phoneNo
     * @return
     */
    public static String hidePhoneNo(String phoneNo) {
        if (phoneNo==null){
            return "";
        }
        int length = phoneNo.length();
        int beforeLength = 1;
        int afterLength = 1;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++) {
            if(i < beforeLength || i >= (length - afterLength)) {
                sb.append(phoneNo.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }

        return sb.toString();
    }
    /**
     * 获取随机字符串
     *
     * @param num
     * @return
     */
    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机字符串
     *
     * @param num
     * @return
     */
    public static String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 特殊要求 不要包含0
     * @param num
     * @return
     */
    public static String getRandomNum2(Integer num) {
        String base = "123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 右补位，左对齐
     *
     * @param oriStr   原字符串
     * @param len      目标字符串长度
     * @param fillChar 补位字符
     * @return 目标字符串
     */
    public static String padRight(String oriStr, int len, char fillChar) {
        String str = "";
        int strlen = oriStr.length();
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + fillChar;
            }
        }
        str = str + oriStr;
        return str;
    }

    /**
     * 左补位，右对齐
     *
     * @param oriStr   原字符串
     * @param len      目标字符串长度
     * @param fillChar 补位字符
     * @return 目标字符串
     */
    public static String padLeft(String oriStr, int len, char fillChar) {
        int strlen = oriStr.length();
        String str = "";
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + fillChar;
            }
        }
        str = oriStr + str;
        return str;
    }
}
