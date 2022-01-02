package com.zjgsu.utils;

public class checkInt {
    public static boolean check(String num)
    {
        if(num==null) return false;
        for(int i=0;i<num.length();i++)
        {
            if(num.charAt(i)<'0'||num.charAt(i)>'9')
                return false;
        }
        return true;
    }

}
