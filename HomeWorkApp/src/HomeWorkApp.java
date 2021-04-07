import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {


       /*
    1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
    2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек
    4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     */

    public static Scanner sc = new Scanner(System.in);

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 5;

    private static final char CHAR_X = 'X';
    private static final char CHAR_O = 'O';
    private static final char CHAR_EMPTY = '*';

    private static char humanChar;
    private static char cpuChar;
    private static int fieldSize;

    private static char[][] field;

    public static Random rand = new Random();
    private static char nextTurn;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        // write your code here
        humanSelectSide();
        fieldSize = selectFieldSize();
        createField();

        char winnerChar = game();

        if (winnerChar == humanChar) {
            printlnGreen("Поздравляем с победой");
        } else if (winnerChar == cpuChar) {
            printlnYellow("Увы, победил компьютер.");
        } else {
            printlnRed("Победитель не определен");
        }
        printCurrentFieldState();
    }

    private static char game() {
        char retWinnerChar = CHAR_EMPTY;
        System.out.println("Игра началась!");
        nextTurn = CHAR_X;
        while (canPlay()) {
            printCurrentFieldState();
            if (nextTurn == humanChar) {
                humanTurn();
            } else if (nextTurn == cpuChar) {
                cpuTurn();
            }
            retWinnerChar = checkCharWinner();
            if (retWinnerChar != CHAR_EMPTY) {
                break;
            }
        }
        return retWinnerChar;
    }

    private static char checkCharWinner() {
        char retWinnerChar = CHAR_EMPTY;

        //Проверка вертикали
        for (int x = 0; x < fieldSize; x++) {
            char xChar = field[x][0];
            boolean sameChar = true;
            for (int y = 0; y < fieldSize; y++) {
                char xyChar = field[x][y];
                if (xChar != xyChar) {
                    sameChar = false;
                    break;
                }
            }
            if (sameChar) {
                retWinnerChar = xChar;
                break;
            }
        }

        if (retWinnerChar == CHAR_EMPTY) {
            //Check горизонтали
            for (int y = 0; y < fieldSize; y++) {
                char yChar = field[0][y];
                boolean sameChar = true;
                for (int x = 0; x < fieldSize; x++) {
                    char xyChar = field[x][y];
                    if (yChar != xyChar) {
                        sameChar = false;
                        break;
                    }
                }
                if (sameChar) {
                    retWinnerChar = yChar;
                    break;
                }
            }
        }

        if (retWinnerChar == CHAR_EMPTY) {
            //Проверка диагонали прямой
            char startChar = field[0][0];
            boolean sameChar = true;
            for (int i = 1; i < fieldSize; i++) {
                char xyChar = field[i][i];
                if (startChar != xyChar) {
                    sameChar = false;
                    break;
                }

            }
            if (sameChar) {
                retWinnerChar = startChar;
            }
        }
        if (retWinnerChar == CHAR_EMPTY) {
            //Проверка диагонали обратной
            char startChar = field[0][fieldSize - 1];
            boolean sameChar = true;
            for (int x = 1; x < fieldSize; x++) {
                int y = fieldSize - x - 1;
                char xyChar = field[x][y];
                if (startChar != xyChar) {
                    sameChar = false;
                    break;
                }

            }
            if (sameChar) {
                retWinnerChar = startChar;
            }
        }

        return retWinnerChar;
    }

    private static void cpuTurn() {
        printlnYellow("Ходит компьютер.");
        while (true) {
            int x = rand.nextInt(fieldSize);
            int y = rand.nextInt(fieldSize);
            if (field[x][y] == CHAR_EMPTY) {
                field[x][y] = cpuChar;
                nextTurn = humanChar;
                printlnYellow("Компьютер походил в клетку X:" + (x + 1) + " Y:" + (y + 1));
                break;
            }
        }
    }

    private static void humanTurn() {
        printlnGreen("Ваш ход.");
        int x;
        while (true) {
            printlnSimple("Введите X координату клетки. Введите в интервале от 1 до " + fieldSize);
            x = sc.nextInt() - 1;
            if (x >= 0 && x <= fieldSize - 1) {
                break;
            } else {
                printlnRed("Ошибка ввода координаты");
            }
        }
        int y;
        while (true) {
            printlnSimple("Введите Y координату клетки. Введите в интервале от 1 до " + fieldSize);
            y = sc.nextInt() - 1;
            if (y >= 0 && y <= fieldSize - 1) {
                break;
            } else {
                printlnRed("Ошибка ввода координаты");
            }
        }
        if (field[x][y] == CHAR_EMPTY) {
            field[x][y] = humanChar;
            nextTurn = cpuChar;
            printlnGreen("Вы походили в клетку X:" + (x + 1) + " Y:" + (y + 1));
        } else {
            printlnRed("Данная координата занята. Выберите другую клетку.");
        }
    }

    private static boolean canPlay() {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                if (field[x][y] == CHAR_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printCurrentFieldState() {

        for (int y = 0; y < fieldSize; y++) {
            System.out.print(ANSI_RESET + "|");
            for (int x = 0; x < fieldSize; x++) {
                char fieldChar = field[x][y];
                if (fieldChar == cpuChar) {
                    System.out.print(ANSI_YELLOW);
                } else if (fieldChar == humanChar) {
                    System.out.print(ANSI_GREEN);
                } else {
                    System.out.print(ANSI_RESET);
                }
                System.out.print(fieldChar + "|");
            }

            System.out.println(ANSI_RESET);
        }
    }

    private static void createField() {
        field = new char[fieldSize][fieldSize];
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                field[x][y] = CHAR_EMPTY;
            }
        }
    }

    /**
     * Выбираем размер поля
     *
     * @return
     */
    private static int selectFieldSize() {
        int retFieldSize = MIN_FIELD_SIZE;

        while (true) {
            printlnSimple("Введите размер поля в интервале от " + MIN_FIELD_SIZE + " до " + MAX_FIELD_SIZE);
            retFieldSize = sc.nextInt();
            if (retFieldSize >= MIN_FIELD_SIZE && retFieldSize <= MAX_FIELD_SIZE) {
                break;
            }
            printlnRed("Ошибка выбора.");
        }
        printlnSimple("Размер игорового поля " + retFieldSize);
        return retFieldSize;
    }

    /**
     * Выбор стороны, за которую будет играть человек
     */
    private static void humanSelectSide() {
        while (true) {
            printlnSimple("Выбрите сторону. Введите X или O");
            String human = sc.next().trim();
            if (human.equalsIgnoreCase(String.valueOf(CHAR_X))) {
                humanChar = CHAR_X;
                cpuChar = CHAR_O;
                break;
            } else if (human.equalsIgnoreCase(String.valueOf(CHAR_O))) {
                humanChar = CHAR_O;
                cpuChar = CHAR_X;
                break;
            } else {
                printlnRed("Ошибка ввода");
            }
        }
        printlnSimple("Вы играете за " + humanChar + ". Компьютер играет за " + cpuChar);
    }

    private static void printlnYellow(String string) {
        System.out.println(ANSI_YELLOW + string);
    }

    private static void printlnRed(String string) {
        System.out.println(ANSI_RED + string);
    }

    private static void printlnGreen(String string) {
        System.out.println(ANSI_GREEN + string);
    }

    private static void printlnSimple(String string) {
        System.out.println(ANSI_RESET + string);
    }
}

