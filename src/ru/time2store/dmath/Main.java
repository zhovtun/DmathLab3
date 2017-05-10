package ru.time2store.dmath;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(array[array.length-1]);

    }

    public void lexSort (int[] array) {
        int i=0;
        int m=0;
        boolean t = true;
        int temp=0;
        while (t) {
            i=array.length-2;
            do {
                m=0;
                if (array[i] < array[i+1]) {
                    while (array[array.length-1-m] > array[i]) {

                        m++;
                    }
                }
                i--;
            } while (array[i-1] < array[i] && i !=1);
        }
    }
}