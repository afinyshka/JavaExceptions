package HW_02;

/*
1. Если необходимо, исправьте данный код (задание 2 
https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
   int [] intArray = new int[8];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }
 */
public class Err02 {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        try {
            int d = 0;
            double catchedRes1 = (double)intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1); // catchedRes1 = NaN , if cast to double line 20. WHY?
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException | ClassCastException e) {
            System.out.println("Catching exception: " + e);
        }
        System.out.println("...The end...");
    }
}
