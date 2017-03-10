package com.cmy.util;

public class ChineseChecker {

    public static void main(String[] args){
       System.out.println(isChinese("陈梦宇"));
       System.out.println(isChinese("张三"));
       System.out.println(isChinese("，大"));
       System.out.println(isChinese("dfasdf"));
       System.out.println(isChinese("やめて"));
       System.out.println(isChinese("發阿斯蒂芬1"));
       System.out.println(isChinese("發阿斯蒂芬"));
       System.out.println(isChinese("發阿3423radsfg"));
       System.out.println(isChinese(",.!"));
       System.out.println(isChinese("陈，"));
       System.out.println(isChinese("陈,4 "));
    }
    
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
//                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
//                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
//                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                ){
            return true;
        }
        return false;
    }
    
 // 完整的判断中文汉字和符号
    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }
}
