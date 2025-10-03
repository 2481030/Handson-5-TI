import java.util.Arrays;
import java.util.Random;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        // Latihan 1: Matriks 3x4
        int[][] matrix = new int[3][4];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = val++;
            }
        }
        displayMatrix(matrix);

        // Latihan 2: Papan Tic-Tac-Toe 3x3
        String[][] papan = {
                {".", ".", "."},
                {".", ".", "."},
                {".", ".", "."}
        };
        papan[0][0] = "X";
        papan[1][1] = "X";
        papan[2][2] = "X";
        papan[0][2] = "O";
        papan[1][0] = "O";
        papan[2][1] = "O";

        System.out.println("\nPapan Tic-Tac-Toe:");
        for (String[] row : papan) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED (IRREGULAR) =====
        System.out.println("\n=== ARRAY JAGGED (IRREGULAR) ===");
        int[][] jagged = new int[4][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        jagged[3] = new int[5];

        int counter = 1;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = counter++;
            }
        }

        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Row " + i + " (" + jagged[i].length + "): " + Arrays.toString(jagged[i]));
        }

        // ===== OPERASI LANJUTAN PADA ARRAY =====
        System.out.println("\n=== OPERASI LANJUTAN PADA ARRAY ===");
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] m2 = {{6, 5, 4}, {3, 2, 1}};

        int[][] added = addMatrices(m1, m2);
        int[][] multiplied = multiplyByScalar(m1, 2);

        System.out.println("Penjumlahan Matriks:");
        displayMatrix(added);

        System.out.println("Perkalian dengan Scalar:");
        displayMatrix(multiplied);

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        int[] sorted = sortArray(numbers);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        int[] reversed = reverseArray(sorted);
        System.out.println("Reversed: " + Arrays.toString(reversed));

        int[] minMax = findMinMax(numbers);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);

        // ===== UTILITY METHODS JAVA.UTIL.ARRAYS =====
        System.out.println("\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");
        int[] data = {5, 2, 8, 1, 9, 3};
        System.out.println("toString: " + Arrays.toString(data));

        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));

        int idx = Arrays.binarySearch(data, 8);
        System.out.println("Index of 8: " + idx);

        Arrays.fill(data, 7);
        System.out.println("Filled: " + Arrays.toString(data));

        int[] copy = Arrays.copyOf(data, 10);
        System.out.println("Copy: " + Arrays.toString(copy));

        int[] cmp1 = {1, 2, 3};
        int[] cmp2 = {1, 2, 3};
        System.out.println("Arrays.equals: " + Arrays.equals(cmp1, cmp2));

        // ===== ARRAY 3D DAN KOMPLEKS =====
        System.out.println("\n=== ARRAY 3D DAN KOMPLEKS ===");
        int[][][] array3D = new int[2][3][4];
        int c = 1;
        for (int i = 0; i < array3D.length; i++) {
            for (int j = 0; j < array3D[i].length; j++) {
                for (int k = 0; k < array3D[i][j].length; k++) {
                    array3D[i][j][k] = c++;
                }
            }
        }

        for (int i = 0; i < array3D.length; i++) {
            System.out.println("Layer " + i + ":");
            displayMatrix(array3D[i]);
        }

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};
        int[][] nilai = new int[5][4];

        fillRandomGrades(nilai, 60, 100);

        // Print tabel nilai
        System.out.print("Nama\t");
        for (String mk : mataKuliah) System.out.print(mk + "\t");
        System.out.println("Rata-rata");

        double maxRata = 0;
        String topStudent = "";

        for (int i = 0; i < nilai.length; i++) {
            System.out.print(namaMahasiswa[i] + "\t");
            double avg = calculateAverage(nilai[i]);
            if (avg > maxRata) {
                maxRata = avg;
                topStudent = namaMahasiswa[i];
            }
            for (int j = 0; j < nilai[i].length; j++) {
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.printf("%.2f\n", avg);
        }
        System.out.println("Mahasiswa nilai tertinggi: " + topStudent + " (" + maxRata + ")");
    }

    // ===== IMPLEMENTASI METHODS =====
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public static int[] sortArray(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    public static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static int[] findMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        return new int[]{min, max};
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void fillRandomGrades(int[][] grades, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    public static double calculateAverage(int[] values) {
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;
    }
}
