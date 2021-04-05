import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {
        /*
          1. Задать целочисленный массив, состоящий из элементов 0 и 1.
          Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        */
        array1Replacement(new int[]{0, 1, 0, 1, 0, 0, 1, 1, 0, 1});

        /*
           Задание 2
           Задать пустой целочисленный массив длиной 100.
           С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
         */
        array2MakeArray();

        /*
           Задание 3
           Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        array3Multiply(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});

        /*
           Задание 4
           Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
           и с помощью цикла(-ов) заполнить его диагональные элементы единицами
           (можно только одну из диагоналей, если обе сложно).
           Определить элементы одной из диагоналей можно по следующему принципу:
           индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */
        array4Diagonal(4);

        /*
           Задание 5
           Написать метод, принимающий на вход два аргумента: len и initialValue,
           и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
         */
        int[] array5 = array5WithLen(5, 3);
        System.out.println("Задание 5. Массив:" + Arrays.toString(array5));

    }

    private static int[] array5WithLen(int len, int initialValue) {
        int[] retArray = new int[len];
        System.out.println("Задание 5. Создать массив длинной " + len + " значениями " + initialValue);
        Arrays.fill(retArray, initialValue);
        return retArray;
    }

    /*
               Задание 4
               Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
               и с помощью цикла(-ов) заполнить его диагональные элементы единицами
               (можно только одну из диагоналей, если обе сложно).
               Определить элементы одной из диагоналей можно по следующему принципу:
               индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
             */
    private static void array4Diagonal(int size) {
        int[][] array = new int[size][size];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (x == y) {
                    array[x][y] = 1;
                }

            }
        }

    }

    /*
              Задание 3
              Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
            */
    private static void array3Multiply(int[] givenArray) {
        System.out.println("Задание 3.Получен массив:" + Arrays.toString(givenArray));
        for (int i = 0; i < givenArray.length; i++) {
            int givenInt = givenArray[i];
            if (givenInt < 6) {
                givenArray[i] = givenInt * 2;
            }
        }
        System.out.println("Задание 3.Новый массив:" + Arrays.toString(givenArray));
    }

    /*
   Задание 2
   Задать пустой целочисленный массив длиной 100.
   С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
 */
    private static void array2MakeArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("Задание 2.Создан массив:" + Arrays.toString(array));
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

     */
    private static void array1Replacement(int[] givenArray) {
        System.out.println("Задание 1.Получен массив:" + Arrays.toString(givenArray));

        for (int i = 0; i < givenArray.length; i++) {
            int givenInt = givenArray[i];

            if (givenInt == 0) {
                givenArray[i] = 1;
            } else if (givenInt == 1) {
                givenArray[i] = 0;
            }
        }
        System.out.println("Задание 1.Инвертированный массив:" + Arrays.toString(givenArray));
    }


}