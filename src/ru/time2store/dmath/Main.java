package ru.time2store.dmath;

import java.util.*;

public class Main
{


    public void reverseArray (String[] array, int position) {
        String temp;
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

    public void printArray (String[] array) {
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
        String[] array = {"a", "b", "c", "d", "e"};
        m.lexSort(array);



    }



    public void lexSort (String[] array) {
        int i=array.length-2;;
        int m=array.length-1;;
        int count = 0;
        boolean t = true;
        String temp;
        while (t) {
            do {
                m=array.length-1;
                if (array[i].compareTo(array[i+1])<0) {
                    count = 0;
                    do {                            // Поиск первого с конца элемнта > array[i]
                        if (array[m].compareTo(array[i]) > 0 ) {
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