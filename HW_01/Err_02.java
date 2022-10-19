package HW_01;

// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможетеполучить?

public class Err_02 {
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) { // ArrayOutOfBoundExeption. The right line: (int j = 0; j < arr[i].length; j++)             
                int val = Integer.parseInt(arr[i][j]); // NumberFormatException. Make try/catch.
               sum+=val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        
    }

    
}
