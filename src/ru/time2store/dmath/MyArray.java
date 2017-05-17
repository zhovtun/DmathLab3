package ru.time2store.dmath;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

public class MyArray
{
    /*
    * Массив строк
    * представляет собой 3 множества.
    * Множество А = arr1;
    * множество В = arr2;
    * множество С = arr3;
    */
    private String[] arr1;
    private String[] arr2;
    private String[] arr3;


    /* Конструктор для создания мссивов  */
    MyArray () {
        arr1 = new String[1];
        arr2 = new String[1];
        arr3 = new String[1];
    }

    /*
    * Метод для задания множеств из
    * из произвольно введенных символов
    */
    public void setArray (String str1, String str2) {
        arr1 = buildArray (str1);
        arr2 = buildArray (str2);
        arr3 = new String[arr1.length + arr2.length];
    }

    /*
    *  Метод для конструирования массива строк.
    *  Метод включает в себя: разделение строки на символя,
    *                         выбор из символов только символы латинского алфавита, только строчных букв
    *                         удаление повторяющихся символов.
    */
    private String[] buildArray (String str) {
        int i =0, j=0, k=0;
        String simbol = "0";
        String[] ch = str.split("");
        String[] array = new String[ch.length];
        String[] result;

        sort(ch);

        while (i < ch.length) {
            if (simbol.compareTo(ch[i])>-72 && simbol.compareTo(ch[i])<1) {
                array[j] = ch[i];
                j++;
                i++;
            }
            else{i++;}
        }
        if (ch.length == j) {
            result = deleteDoubleChar(array);
            return result;
            }
        else {
            result = cutArray(array);
            array = deleteDoubleChar(result);
            return array;
        }
    }

    /*
    * Метод для удаления повторяющихся символов.
    * Для этого используется метод compareTo класса String.
    * Он сравнивает 2 строки, и возвращает разность значения символов в unicode
    */
    private String[] deleteDoubleChar (String[] array) {
        String[] result;
        int i = 0, j = 0, k = 0;
        while (i < array.length-1) {
            if (array[i].compareTo(array[i + 1]) == 0) {
                i++;
            } else {k++; i++;}
        }

        i = 0;
        result = new String[k+1];
        while (i < array.length-1) {
            if (array[i].compareTo(array[i + 1]) == 0) {
                i++;
            } else {
                result[j] = array[i];
                j++;
                i++;
            }
        }
        result[j] = array[i];
        return result;
    }

    /*
    * Метод осуществляет уменьшение массива, если в нем есть значение null
    */
    private String[] cutArray (String[] array) {
        int k=0, i=0;
        while (array[k] != null) {
            k++;
        }
        String[] result = new String[k];
        while (i != k) {
            result[i] = array[i];
            i++;
        }
        return result;
    }

    /*
    * Метод сортировки пузырьком
    */
    private void sort (String[] array) {
        String temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[i].compareTo(array[j]) < 0) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

    }

    /*
    *  Метод для обнуления значения массива
    *  для работы с ним в нескольких методах
    */
    private void reset (String[] arr) {
        int i = 0;
        while(i<arr.length) {
            arr[i] = null;
            i++;
        }
    }

    /*
    *  Метод вывода массива в отформатированном виде типа { a v d g }
    */
    private String printArray (String[] arr) {
        int i=0;
        String result = "{ ";
        while (i < arr.length  && arr[i] != null) {
            result += arr[i] + " ";
            i++;
        }
        result += "}\n";
        return result;
    }


    /*
    *  Метод для отображения исходных множеств
    */
    public String showSubset () {
        String result = "Множество А = " + printArray(arr1) + '\n' + "Множество B = " + printArray(arr2);
        return result;
    }


    /*
    *  Метод для определения вхождения множеств "а является подмножеством в"
    */
    public String aIsSubsetB () {
        int i=0, j=0, k=0;
        String result;

        while (i!=arr1.length && j!= arr2.length && arr1[i] != null && arr2[j] != null) {
            if (arr1[i].compareTo(arr2[j]) == 0) {
                i++;
                j++;
                k++;
            }
            else if (arr1[i].compareTo(arr2[j]) > 0) {
                j++;
            }
            else {
                i++;
            }
        }

        if (k == arr1.length) {
            return result = "Множество А является подмножеством В";
        }
        else {
            return result = "Множество А не является подмножеством В";
        }
    }


    /*
    *  Метод для определения объединения множеств
    *  для организации алгоритма "Слияние", используется метод compareTo класса String
    */
    public String sum () {
        int i=0, j=0, k=0;
        String result = " ";
        reset(arr3);

        if (aIsSubsetB() == "Множество А является подмножеством В") {
            result = "Результат объединения A \u22C3 B - множество С = " + printArray(arr2);
        }
        else {
            while (i!=arr1.length && j!= arr2.length && arr1[i] != null && arr2[j] != null) {
                if (arr1[i].compareTo(arr2[j]) == 0) {   // если разность символов равна 0, значит символы равны
                    arr3[k] = arr1[i];
                    i++;                // каретка массива arr1
                    j++;                // каретка массива arr2
                    k++;                // каретка массива arr3
                }
                else if (arr1[i].compareTo(arr2[j]) > 0) { // если выражение >0, значит arr2[j] находится далеше по алфавиту чем arr1[i]
                    arr3[k] = arr2[j];
                    j++;
                    k++;
                }
                else {                                     // и наоборот
                    arr3[k] = arr1[i];
                    i++;
                    k++;
                }
            }
            while (i<arr1.length) {  // если в конце массива arr1 остались элементы - дописываются в конец массива arr3
                arr3[k] = arr1[i];
                k++;
                i++;
            }
            while (j<arr2.length) {  // если в конце массива arr2 остались элементы - дописываются в конец массива arr3
                arr3[k] = arr2[j];
                k++;
                j++;
            }
            result = "Результат объединения A \u22C3 B - множество С = " + printArray(arr3);
        }

        return result;
    }


    /*
    * Метод для определения пересечения (умножения) множеств
    */
    public String intersection () {
        int i=0, j=0, k=0;
        String result = " ";
        reset(arr3);

        while (i!=arr1.length && j!= arr2.length && arr1[i] != null && arr2[j] != null) {
            if (arr1[i].compareTo(arr2[j]) == 0) {
                arr3[k] = arr1[i];
                i++;
                j++;
                k++;
            }
            else if (arr1[i].compareTo(arr2[j]) > 0) {
                j++;
            }
            else {
                i++;
            }
        }
        if (k == 0) {result = "Результат пересечения A \u2229 B - множества не пересакаются";}
        else {result = "Результат пересечения A \u2229 B - множество С = " + printArray(arr3);}
        return result;
    }

    /*
    *   Метод для определения разности множеств
    */
    public String diff () {  //разность множеств
        int i=0, j=0, k=0;
        String result = " ";
        reset(arr3);

        while (i!=arr1.length && j!= arr2.length && arr1[i] != null && arr2[j] != null) {
            if (arr1[i].compareTo(arr2[j]) == 0) {
                i++;
                j++;
            }
            else if (arr1[i].compareTo(arr2[j]) > 0) {

                j++;
            }
            else {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
        while (i<arr1.length) {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        if (k == 0) {result = "Результат разности A \\ B - множества не вычитаются";}
        else {result = "Результат разности A \\ B - множество С = " + printArray(arr3);}
        return result;
    }

    /*
    *   Метод для определения симметрической разности множеств
    */
    public String simmetricDiff () {  //симметрическая разность
        int i=0, j=0, k=0;
        String result = " ";
        reset(arr3);

        while (i<arr1.length && j< arr2.length && arr1[i] != null && arr2[j] != null) {
            if (arr1[i].compareTo(arr2[j]) == 0) {
                i++;
                j++;
            }
            else if (arr1[i].compareTo(arr2[j]) > 0) {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
            else {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
        while (i<arr1.length) {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        while (j<arr2.length) {
            arr3[k] = arr2[j];
            k++;
            j++;
        }
        if (k == 0) {result = "Результат симметрической разности A \u2206 B - множества не вычитаются";}
        else {result = "Результат симметрической разности A \u2206 B - множество С = " + printArray(arr3);}
        return result;
    }


    public void lexSort (TextArea textArea) throws IOException {

        int i=arr1.length-2;;
        int m;
        int fact = factorial();
        int count = 0;
        boolean t = true;
        String temp;
        File file = new File("./", "~temp");
        if (file.exists()) {file.delete();}
        else {file.createNewFile();}

        FileWriter ifstream = new FileWriter("~temp");

        if (fact< 5041) {textArea.setText(printArray(arr1));}
        else {
            textArea.setText("При количестве элементов множества > 7 программа выводит данные с большой задержкой,\n" +
                    "поэтому для вывода данных используется внешний редактор текстовых файлов AkelPad.exe.");
            ifstream.write(printArray(arr1));
        }

        while (t) {
            do {
                m=arr1.length-1;
                if (arr1[i].compareTo(arr1[i+1])<0) { // Если arr1[i] < arr1[i+1]
                    count = 0;
                    do {                            // Поиск первого с конца элемнта arr1[m]  > arr1[i]
                        if (arr1[m].compareTo(arr1[i]) > 0 ) {
                            temp = arr1[m];        // Меняем местами  arr1[i] и arr1[m]
                            arr1[m] = arr1[i];
                            arr1[i] = temp;
                            m = i;                  // Выход из цикла
                        }
                        m--;
                    } while (m > i);
                    reverseArray(arr1, i+1);  // Переписываем в порядке возрастания
                    i=arr1.length-1;

                    if (fact < 5041) {textArea.appendText(printArray(arr1));} //Печать набора
                    else {ifstream.write(printArray(arr1));}
                    
                }
                i--;
                count++;
                if (count == arr1.length) {t=false;}
            } while (count < arr1.length);
        }
        ifstream.close();
        if (fact > 5100) {Runtime.getRuntime().exec("./AkelPad.exe ~temp");}
    }

    public int factorial () {
        int result = 1;
        for (int i = 2; i <= arr1.length; i++) {
            result *= i;
        }
        return result;
    }

    private void reverseArray (String[] array, int position) {
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
}