package ru.time2store.dmath;

import java.util.*;

public class Main
{


    public void reverseArray (int[] array, int position) {
        int temp;
        int i = 0;
        int p = position + (array.length-position)/2;
        while (position < p) {
            temp = array[position];
            array[position] = array[array.length-1-i];
            array[array.length-1-i] = temp;
            i++;
            position++;
        }
    }

    public void printArray (int[] array) {
        System.out.print("[ ");
        int i = 0;
        while (i< array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.print("] \n");
    }




    public static void main(String[] args)
    {
        Main m = new Main();
        int[] array = {1, 2, 3, 4, 5};
        m.lexSort(array);



    }



    public void lexSort (int[] array) {
        int i=array.length-2;;
        int m=array.length-1;;
        int count = 0;
        boolean t = true;
        int temp=0;
        printArray(array);
        while (t) {
            do {
                m=array.length-1;
                if (array[i] < array[i+1]) {
                    count = 0;
                    do {                            // Поиск первого с конца элемнта > array[i]
                        if (array[m] > array[i]) {
                            temp = array[m];
                            array[m] = array[i];
                            array[i] = temp;
                            m = i;
                        }
                        m--;
                    } while (m > i);
                    reverseArray(array, i+1);
                    i=array.length-1;
                    printArray(array);
                    }
                i--;
                count++;
                if (count == array.length) {t=false;}
            } while (count < array.length);
        }
    }
}