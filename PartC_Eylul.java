import java.util.*;

public class partC_Eylul {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("=== HIGH SCHOOL MENU ===");
            System.out.println("[A] Statistical Information about an Array");
            System.out.println("[B] Distance between Two Arrays");
            System.out.println("[C] Return to Main Menu");
            System.out.print("Select an option: ");

            String choice = input.next().toUpperCase();
            input.nextLine(); // buffer temizleme

            switch (choice) {
                case "A":
                    clearScreen();
                    statisticalInformationMenu(input);
                    break;
                case "B":
                    clearScreen();
                    distanceBetweenArraysMenu(input);
                    break;
                case "C":
                    clearScreen();
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    clearScreen();
                    System.out.println("Invalid selection! Try again.\n");
            }
        }
    }

    // A: Statistical Information
    public static void statisticalInformationMenu(Scanner input) {
        System.out.println("--- Statistical Information about an Array ---");

        int n = getValidArraySize(input);
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = getValidDouble(input, i + 1);
        }

        Arrays.sort(arr);

        double median = calculateMedian(arr);
        double arithmetic = calculateArithmeticMean(arr);
        double geometric = calculateGeometricMean(arr);
        double harmonic = arr.length / harmonicSum(arr, 0);

        System.out.println("\n--- Results ---");
        System.out.printf("Median: %.4f%n", median);
        System.out.printf("Arithmetic Mean: %.4f%n", arithmetic);
        System.out.printf("Geometric Mean: %.4f%n", geometric);
        System.out.printf("Harmonic Mean: %.4f%n", harmonic);

        System.out.println("\nPress Enter to return...");
        input.nextLine();
        clearScreen();
    }

    // B: Distance between Arrays
    public static void distanceBetweenArraysMenu(Scanner input) {
        System.out.println("--- Distance between Two Arrays ---");

        int n = getValidArraySize(input);

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.println("Enter elements of the FIRST array (0–9):");
        for (int i = 0; i < n; i++) {
            arr1[i] = getValidInteger(input, i + 1);
        }

        System.out.println("Enter elements of the SECOND array (0–9):");
        for (int i = 0; i < n; i++) {
            arr2[i] = getValidInteger(input, i + 1);
        }

        double manhattan = calculateManhattanDistance(arr1, arr2);
        double euclidean = calculateEuclideanDistance(arr1, arr2);
        double cosine = calculateCosineSimilarity(arr1, arr2);

        System.out.println("\n--- Results ---");
        System.out.printf("Manhattan Distance: %.4f%n", manhattan);
        System.out.printf("Euclidean Distance: %.4f%n", euclidean);
        System.out.printf("Cosine Similarity: %.4f%n", cosine);

        System.out.println("\nPress Enter to return...");
        input.nextLine();
        clearScreen();
    }

    // Helper Methods

    public static int getValidArraySize(Scanner input) {
        while (true) {
            try {
                System.out.print("Enter array size: ");
                int n = Integer.parseInt(input.nextLine());
                if (n <= 0) {
                    clearScreen();
                    System.out.println("Array size must be greater than 0.\n");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid value! Please enter a valid integer for size.\n");
            }
        }
    }

    public static double getValidDouble(Scanner input, int index) {
        while (true) {
            System.out.print("Enter element " + index + ": ");
            String userInput = input.nextLine();
            try {
                userInput = userInput.replace(",", ".");
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid value! Please enter a valid number (use . or , for decimals).\n");
                System.out.println("Re-enter element " + index + ": ");
            }
        }
    }

    public static int getValidInteger(Scanner input, int index) {
        while (true) {
            System.out.print("Element " + index + ": ");
            String userInput = input.nextLine();

            try {
                if (userInput.contains(".") || userInput.contains(",")) {
                    clearScreen();
                    System.out.println("Invalid value! Please enter an integer between 0 and 9.\n");
                    System.out.println("Re-enter element " + index + ": ");
                    continue;
                }

                int value = Integer.parseInt(userInput);
                if (value >= 0 && value <= 9) return value;
                else {
                    clearScreen();
                    System.out.println("Value must be between 0 and 9!\n");
                    System.out.println("Re-enter element " + index + ": ");
                }
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid input! Please enter an integer between 0 and 9.\n");
                System.out.println("Re-enter element " + index + ": ");
            }
        }
    }

    // Mathematical Methods
    public static double calculateMedian(double[] arr) {
        int n = arr.length;
        if (n % 2 == 1)
            return arr[n / 2];
        else
            return (arr[(n / 2) - 1] + arr[n / 2]) / 2.0;
    }

    public static double calculateArithmeticMean(double[] arr) {
        double sum = 0;
        for (double x : arr) sum += x;
        return sum / arr.length;
    }

    public static double calculateGeometricMean(double[] arr) {
        double product = 1;
        for (double x : arr) product *= x;
        return Math.pow(product, 1.0 / arr.length);
    }

    public static double harmonicSum(double[] arr, int i) {
        if (i == arr.length - 1)
            return 1.0 / arr[i];
        return (1.0 / arr[i]) + harmonicSum(arr, i + 1);
    }

    // Distance Methods
    public static double calculateManhattanDistance(int[] a, int[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += Math.abs(a[i] - b[i]);
        return sum;
    }

    public static double calculateEuclideanDistance(int[] a, int[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += Math.pow(a[i] - b[i], 2);
        return Math.sqrt(sum);
    }

    public static double calculateCosineSimilarity(int[] a, int[] b) {
        double dot = 0, normA = 0, normB = 0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    // Clear screen method
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
