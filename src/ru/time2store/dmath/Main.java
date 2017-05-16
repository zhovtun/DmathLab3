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











}