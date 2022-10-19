package HW_01;

import java.util.Arrays;
import java.util.Random;

/*
 Реализуйте метод, принимающий в качестве аргументов два целочисленных
 массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той
 же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
 
 Реализуйте метод, принимающий в качестве аргументов два целочисленных
 массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той
 же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. 
 Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */
public class Err_0304 {

    public static int[] arrayElemDiff(int[] arrayFirst, int[] arraySecond) {
        if (arrayFirst.length != arraySecond.length)
            throw new RuntimeException("Not equal lengths");
        int[] arrayDiff = new int[arrayFirst.length];
        for (int i = 0; i < arrayDiff.length; i++) {
            arrayDiff[i] = arrayFirst[i] + arraySecond[i];
        }
        return arrayDiff;
    }

    public static double[] arrayElemDiv(int[] arrayFirst, int[] arraySecond) {
        if (arrayFirst.length != arraySecond.length)
            throw new RuntimeException("Not equal lengths");
        double[] arrayDiv = new double[arrayFirst.length];
        for (int i = 0; i < arrayDiv.length; i++) {
            if (arraySecond[i] == 0) {
                throw new RuntimeException("Devision by zero");
            }
            arrayDiv[i] = arrayFirst[i] / arraySecond[i] / 1.0;
        }
        return arrayDiv;
    }

    public static void main(String[] args) {
        // int [] arrOne = new int [new Random().nextInt(5)];
        int[] arrOne = new int[4];
        for (int index = 0; index < arrOne.length; index++) {
            arrOne[index] = new Random().nextInt(10);
        }
        // int [] arrTwo = new int [new Random().nextInt(5)];
        int[] arrTwo = new int[4];
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = new Random().nextInt(10);
        }
        int[] arrDiffer = arrayElemDiff(arrOne, arrTwo);
        double[] arrDivider = arrayElemDiv(arrOne, arrTwo);
        System.out.println(Arrays.toString(arrDiffer));
        System.out.println(Arrays.toString(arrDivider));

    }
}