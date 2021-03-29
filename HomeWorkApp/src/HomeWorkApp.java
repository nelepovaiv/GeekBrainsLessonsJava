public class HomeWorkApp {

    public static void main(String[] args) {
        /*
          Задание 1
          Написать метод, принимающий на вход два целых числа и проверяющий,
          что их сумма лежит в пределах от 10 до 20 (включительно),
          если да – вернуть true, в противном случае – false.
        */
        boolean resultM1 = method1(3, 6);
        System.out.println("Задание 1:" + resultM1);

        /*
           Задание 2
           Написать метод, которому в качестве параметра передается целое число,
           метод должен напечатать в консоль, положительное ли число передали или отрицательное.
           Замечание: ноль считаем положительным числом.
         */
        String resultM2 = method2(-9);
        System.out.println("Задание 2:" + resultM2);
        /*
           Задание 3
           Написать метод, которому в качестве параметра передается целое число.
           Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
         */
        boolean resultM3 = method3(5);
        System.out.println("Задание 3:" + resultM3);
        /*
           Задание 4
           Написать метод, которому в качестве аргументов передается строка и число,
           метод должен отпечатать в консоль указанную строку, указанное количество раз;
         */
        method4("Hello", 4);
        /*
           Задание 5
           * Написать метод, который определяет, является ли год високосным,
           и возвращает boolean (високосный - true, не високосный - false).
           Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
        method5(2020);
    }

    private static void method5(int year) {
        System.out.print("Задание 5:");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println(year + " г. не високосный");
        } else {
            System.out.println(year + " г. високосный");
        }
    }

    private static void method4(String str, int c) {
        for (int i = 0; i < c; i++) {
            System.out.println("Задание 4:" + str);
        }
    }

    private static boolean method3(int i) {
        if (i >= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static String method2(int i) {
        if (i >= 0) {
            return "положительное";
        } else {
            return "отрицательное";
        }
    }

    private static boolean method1(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }


}