package HW_01;

/**
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете
 * получить?
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив,
 * каждый элемент которого равен разности элементов двух входящих массивов в той
 * же ячейке. Если длины массивов не равны,
 * необходимо как-то оповестить пользователя.
 * 
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив,
 * каждый элемент которого равен частному элементов двух входящих массивов в той
 * же ячейке. Если длины массивов не равны,
 * необходимо как-то оповестить пользователя. Важно: При выполнении метода
 * единственное исключение, которое пользователь может
 * увидеть - RuntimeException, т.е. ваше.
 */
public class Err_0101 {

    public static int[] arrayElemDiff(int[] arrayFirst, int[] arraySecond) {
        if (arrayFirst.length != arraySecond.length) throw new RuntimeException("Not equal lengths");
        int[] arrayDiff = new int[arrayFirst.length];
        for (int i = 0; i < arrayDiff.length; i++) {
            arrayDiff[i] = arrayFirst[i] + arraySecond[i];
        }
        return arrayDiff;
    }

    public static double[] arrayElemDiv(int[] arrayFirst, int[] arraySecond) {
        if (arrayFirst.length != arraySecond.length) throw new RuntimeException("Not equal lengths");
        double[] arrayDiv = new double[arrayFirst.length];
        for (int i = 0; i < arrayDiv.length; i++) {
            if (arraySecond[i]==0) {
                throw new RuntimeException("Devision by zero");
            }
            arrayDiv[i] = arrayFirst[i] / arraySecond[i] / 1.0;
        }
        return arrayDiv;
    }

    public static void main(String[] args) {

    }
}