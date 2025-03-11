import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = -100;
    private static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Отримання розмірів матриці
        System.out.print("Введіть кількість рядків (не більше 20): ");
        int rows = getValidInput(scanner);
        System.out.print("Введіть кількість стовпців (не більше 20): ");
        int cols = getValidInput(scanner);

        // Вибір способу заповнення
        System.out.print("Оберіть спосіб заповнення (1 - вручну, 2 - випадково): ");
        int choice = getValidInput(scanner, 1, 2);

        int[][] matrix = new int[rows][cols];

        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else {
            fillMatrixRandomly(matrix);
        }

        // Вивід матриці
        printMatrix(matrix);

        // Обчислення результатів
        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        // Вивід результатів
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);

        scanner.close();
    }

    // Метод для введення коректного числа
    private static int getValidInput(Scanner scanner) {
        int value;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Будь ласка, введіть ціле число: ");
                scanner.next();
            }
            value = scanner.nextInt();
            if (value < 1 || value > MAX_SIZE) {
                System.out.print("Число повинно бути від 1 до 20. Спробуйте ще раз: ");
            }
        } while (value < 1 || value > MAX_SIZE);
        return value;
    }

    // Метод для введення коректного числа в заданому діапазоні
    private static int getValidInput(Scanner scanner, int min, int max) {
        int value;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Будь ласка, введіть ціле число: ");
                scanner.next();
            }
            value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.print("Число повинно бути " + min + " або " + max + ". Спробуйте ще раз: ");
            }
        } while (value < min || value > max);
        return value;
    }

    // Заповнення матриці вручну
    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Заповнення матриці випадковими числами
    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    // Вивід матриці на екран
    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }

    // Пошук мінімального значення
    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem < min) {
                    min = elem;
                }
            }
        }
        return min;
    }

    // Пошук максимального значення
    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem > max) {
                    max = elem;
                }
            }
        }
        return max;
    }

    // Обчислення середнього арифметичного
    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                sum += elem;
                count++;
            }
        }
        return (double) sum / count;
    }
}
