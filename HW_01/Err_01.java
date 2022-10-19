package HW_01;
//  Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Err_01 {
    public static int getArrElemMeaning(int[] arr, int index) { 
        return arr[index]; // NullPointerException, ArrayIndexOutOfBoundsException
    }

    public static Integer getAge(String path) throws IOException { 
        BufferedReader br = new BufferedReader(new FileReader(path)); //FileNotFoundException
        String str = "";
        if ((str = br.readLine()) != null) {
            if (Character.isDigit(str.charAt(0))) {
                Integer num = Integer.parseInt(str); // NumberFormatException
                br.close();
                return num;
            }
        }
        br.close();
        return null;
    }

    public static boolean checkPositive(int [] arr, int el1, int el2) {
        boolean checkNum = true; { 
            if (arr[el1] / arr[el2] < 0) checkNum = false; // ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException
        }
        return checkNum;
    }

    public static Double caster(int [] arr, int el1, int el2) {
        Object div = null;
            if (arr[el1] > arr[el2]) div = arr[el1] / arr[el2]; // ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException
            else div = arr[el2] / arr[el1]; // ArithmeticException
        return (Double) div; // ClassCastException
    }

    public static void main(String[] args) {
        int[] arrayAge = { 5, 7, 8, 4, 0, 2, 6, 9, 5, 7 };
        // Double checkPos = caster(arrayAge, 5, 4); // ClassCastException
        Double checkPos1 = caster(arrayAge, 3, 1); // ClassCastException
        System.out.println(checkPos1);
    }
}
