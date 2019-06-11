package com.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.scenario.effect.Merge;

import java.lang.reflect.Field;

import static sun.misc.Version.print;

/**
 * Created by wh on 2019/3/26.
 */
public class sort {
    public static int[] insertSort(int[] a){
        int length=a.length;
        for(int i=1;i<length;i++){
            int j=i;
            int temp=a[i];
            while(j>0&&temp<a[j-1]){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;

        }
        return a;
    }
    public static double[] BubbleSort(double[] a){
        int i,j,last;
        int length=a.length;
        i=length-1;
        while(i>0){
            last=0;
            for(j=0;j<i;j++){
                if(a[j+1]<a[j]){
                    double temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    last=j;
                }
            }
            i=last;
        }
        return a;
    }

    public static int[] SelectSort(int[] a){
        if(a.length==0){
            return a;
        }
        int length=a.length;
        int small;
        for(int i=0;i<length-1;i++){
            small=i;
            for(int j=i+1;j<length;j++){
                if(a[small]>a[j]){
                    small=j;
                }
            }
            //swap(a[small],a[i]);
            int temp=a[small];
            a[small]=a[i];
            a[i]=temp;
        }
        return a;

    }

    public static void swap(Integer a, Integer b) {
        if (a == null || b == null) {
            return;
        }
        //获得a的class对象
        Class<Integer> integerClass = (Class<Integer>) a.getClass();
        try {
            //获得value属性
            Field value=integerClass.getDeclaredField("value");
            //设置权限为可访问
            value.setAccessible(true);
            //交换
            int temp=a;
            value.setInt(a,b);
            value.setInt(b,temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static int[] QuickSort(int[] a,int left,int right){
        int i,j;
        if(left<right){
            i=left;
            j=right+1;
            do{
                do{
                    i++;
                }while(a[i]<a[left]);
                do{
                    j--;
                }while(a[j]>a[left]);
                if(i<j){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                    for(int k=0;k<a.length;k++){
                        System.out.printf("%d,",a[k]);
                    }
                    System.out.println(",");
                }

            }while(i<j);
            int temp1=a[left];
            a[left]=a[j];
            a[j]=temp1;
            QuickSort(a,left,j-1);
            QuickSort(a,j+1,right);
        }
        return a;
    }
    public static int[] Merge(int[] a,int left1,int right1,int left2,int right2){
        int[] temp=new int[right2-left1+1];
        int left=left1,right=left2,k=0;
        while(left<=right1&&right<=right2){
            if(a[left]<=a[right]){
                temp[k++]=a[left++];
            }else{
                temp[k++]=a[right++];
            }
        }
        while(left<=right1){
            temp[k++]=a[left++];
        }
        while(right<=right2){
            temp[k++]=a[right++];
        }
        for(int i=0;i<k;i++){
            a[left1++]=temp[i];
        }
        return a;
    }
    public static int[] MergeSort(int[] a){
        if(a.length<=1){
            return a;
        }
        int length=a.length;
        int left1,right1,left2,right2;
        int size=1;
        while(size<length){
            left1=0;
            while(left1+size<length){
                left2=left1+size;
                right1=left2-1;
                if(left2+size-1>length-1){
                    right2=length-1;
                }else{
                    right2=left2+size-1;
                }
                a=Merge(a,left1,right1,left2,right2);
                left1=right2+1;
            }
            size*=2;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] arrayK={3,1,9,4,7,3,1,5};
        //arrayK=insertSort(arrayK);
        double[] arrayB={3.1,3.7,1,2,9,7,1,6,24.2};
        arrayB=BubbleSort(arrayB);
        //arrayK=SelectSort(arrayK);
        //arrayK=QuickSort(arrayK,0,arrayK.length-1);
        arrayK=MergeSort(arrayK);
        for(int i=0;i<arrayK.length;i++){
            System.out.printf("%d,",arrayK[i]);
        }
    }

}
