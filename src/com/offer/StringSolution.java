package com.offer;

/**
 * Created by wh on 2019/6/11.
 */
public class StringSolution {
    /*

     */
    public static String replaceSpace(StringBuffer str) {
        if(str==null||str.length()<=0){
            return "";
        }
        char[] chrCharArray = str.toString().toCharArray();
        int originalLength = 0;
        int numberOfBlank = 0;
        int i=0;
        while(i<chrCharArray.length){
            ++originalLength;
            if(Character.isSpaceChar(chrCharArray[i])){
                ++numberOfBlank;
            }
            ++i;
        }
        int newLength = originalLength+numberOfBlank*2;
        int indexOfOriginal = originalLength-1;
        int indexOfNew = newLength-1;
        char[] result = new char[newLength];
        while(indexOfOriginal>=0&&indexOfNew>=0){
            if(Character.isSpaceChar(chrCharArray[indexOfOriginal])){
                result[indexOfNew--]='0';
                result[indexOfNew--]='2';
                result[indexOfNew--]='%';
            }else{
                result[indexOfNew--]=chrCharArray[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        String s = new String(result);
        return s;
    }
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hell worl");
        String s = replaceSpace(str);
        System.out.print(s);
    }
}
