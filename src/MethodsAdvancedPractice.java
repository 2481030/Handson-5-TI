import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable untuk demonstrasi
    private static int counter = 0;

    // Instance variable untuk demonstrasi
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Methods Advanced
         */

        // ===== METHOD SIGNATURE DAN DECLARATION =====
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");

        // ===== METHOD OVERLOADING =====
        System.out.println("\n=== METHOD OVERLOADING ===");

        // ===== STATIC VS INSTANCE METHODS =====
        System.out.println("\n=== STATIC VS INSTANCE METHODS ===");

        // ===== PASS BY VALUE - PRIMITIVES =====
        System.out.println("\n=== PASS BY VALUE - PRIMITIVES ===");

        // ===== PASS BY VALUE OF REFERENCE - OBJECTS =====
        System.out.println("\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");

        // ===== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");

        // ===== VARIABLE ARGUMENTS (VARARGS) =====
        System.out.println("\n=== VARIABLE ARGUMENTS (VARARGS) ===");

        // ===== METHOD CHAINING =====
        System.out.println("\n=== METHOD CHAINING ===");

        // ===== RECURSIVE METHODS =====
        System.out.println("\n=== RECURSIVE METHODS ===");

        // ===== UTILITY STATIC METHODS =====
        System.out.println("\n=== UTILITY STATIC METHODS ===");

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
    }

    // ===== METHOD OVERLOADING EXAMPLES =====
    public static int calculate(int a, int b) { return a + b; }
    public static double calculate(double a, double b) { return a + b; }
    public static int calculate(int a, int b, int c) { return a + b + c; }
    public static String calculate(String a, String b) { return a + b; }

    public static void print(int value) { System.out.println("Integer: " + value); }
    public static void print(double value) { System.out.println("Double: " + value); }
    public static void print(String value) { System.out.println("String: " + value); }
    public static void print(int[] array) { System.out.println("Array: " + Arrays.toString(array)); }

    // ===== STATIC VS INSTANCE METHODS =====
    public static int getCounter() { return counter; }
    public static void incrementCounter() { counter++; }
    public String getInstanceName() { return instanceName; }
    public void setInstanceName(String name) { this.instanceName = name; }
    public void displayInfo() {
        System.out.println("Instance: " + instanceName + " | Counter: " + counter);
    }

    // ===== PASS BY VALUE =====
    public static void modifyPrimitive(int number) {
        number += 10;
        System.out.println("Inside modifyPrimitive: " + number);
    }

    public static void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) array[i] += 1;
    }

    public static void reassignArray(int[] array) {
        array = new int[]{9, 9, 9};
        System.out.println("Inside reassignArray: " + Arrays.toString(array));
    }

    // ===== ARRAY METHODS =====
    public static int[] sortArrayCopy(int[] original) {
        int[] copy = Arrays.copyOf(original, original.length);
        Arrays.sort(copy);
        return copy;
    }

    public static double[] getArrayStats(int[] array) {
        int min = Arrays.stream(array).min().orElse(0);
        int max = Arrays.stream(array).max().orElse(0);
        double avg = Arrays.stream(array).average().orElse(0);
        return new double[]{min, max, avg};
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] merged = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, merged, 0, a1.length);
        System.arraycopy(a2, 0, merged, a1.length, a2.length);
        return merged;
    }

    // ===== VARARGS =====
    public static int sum(int... nums) {
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }

    public static void printInfo(String title, int... values) {
        System.out.println(title + ": " + Arrays.toString(values));
    }

    // ===== RECURSION =====
    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] == target) return mid;
        if (array[mid] > target)
            return binarySearchRecursive(array, target, left, mid - 1);
        else
            return binarySearchRecursive(array, target, mid + 1, right);
    }

    // ===== INNER UTILITY CLASSES =====
    public static class MathUtils {
        public static double power(double base, int exp) {
            double res = 1;
            for (int i = 0; i < exp; i++) res *= base;
            return res;
        }

        public static boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        }

        public static int gcd(int a, int b) {
            return (b == 0) ? a : gcd(b, a % b);
        }
    }

    public static class StringUtils {
        public static String reverse(String s) {
            return new StringBuilder(s).reverse().toString();
        }

        public static boolean isPalindrome(String s) {
            return s.equalsIgnoreCase(reverse(s));
        }

        public static int countWords(String s) {
            return s.trim().split("\\s+").length;
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) System.out.println(Arrays.toString(row));
        }

        public static int[] findDuplicates(int[] array) {
            return Arrays.stream(array)
                    .filter(i -> Arrays.stream(array).filter(x -> x == i).count() > 1)
                    .distinct()
                    .toArray();
        }

        public static boolean areEqual(int[] a1, int[] a2) {
            return Arrays.equals(a1, a2);
        }
    }

    // ===== METHOD CHAINING =====
    public static class Calculator {
        private double value;
        public Calculator(double initial) { this.value = initial; }
        public Calculator add(double n) { this.value += n; return this; }
        public Calculator multiply(double n) { this.value *= n; return this; }
        public Calculator subtract(double n) { this.value -= n; return this; }
        public double getResult() { return value; }
    }
}
