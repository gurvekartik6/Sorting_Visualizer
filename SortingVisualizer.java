import java.util.*;
import java.util.concurrent.TimeUnit;

public class SortingVisualizer {
    private static int[] array;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n=========================================");
        System.out.println("     SORTING ALGORITHM VISUALIZER");
        System.out.println("=========================================\n");
        
        getArrayFromUser();
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Your choice (1-4): ", 1, 4);
            
            int[] originalArray = array.clone();
            
            switch (choice) {
                case 1:
                    bubbleSort();
                    break;
                case 2:
                    selectionSort();
                    break;
                case 3:
                    insertionSort();
                    break;
                case 4:
                    System.out.println("\nThank you!\n");
                    System.exit(0);
            }
            
            array = originalArray.clone();
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void getArrayFromUser() {
        System.out.println("Enter numbers separated by spaces:");
        System.out.print("> ");
        String input = scanner.nextLine();
        String[] parts = input.trim().split("\\s+");
        
        array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        
        System.out.println("\nArray: " + Arrays.toString(array));
        System.out.println("\nPress Enter to start...");
        scanner.nextLine();
    }

    private static void displayMenu() {
        System.out.println("\n=========================================");
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("=========================================");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Exit");
        System.out.println("=========================================");
    }

    private static void displayArray(String message, int pos1, int pos2) {
        System.out.println("\n" + message);
        System.out.println("--------------------------------------------------");
        
        // Display values
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", array[i]);
        }
        System.out.println();
        
        // Display highlight indicators
        for (int i = 0; i < array.length; i++) {
            if (i == pos1 || i == pos2) {
                System.out.print("  ^ ");
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
        
        // Display indices
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        
        // Show comparison info
        if (pos1 != -1 && pos2 != -1 && pos1 != pos2) {
            System.out.println("\nComparing " + array[pos1] + " and " + array[pos2]);
            if (array[pos1] > array[pos2]) {
                System.out.println("-> Swapping");
            } else {
                System.out.println("-> No swap");
            }
        }
    }
    
    private static void displayArray(String message) {
        displayArray(message, -1, -1);
    }
    
    private static void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void bubbleSort() {
        System.out.println("\n========== BUBBLE SORT ==========");
        sleep();
        
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                displayArray("Step: Comparing position " + j + " and " + (j+1), j, j+1);
                sleep();
                
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    displayArray("Swapped!", j, j+1);
                    sleep();
                }
            }
            displayArray("Pass " + (i+1) + " complete");
            sleep();
        }
        
        displayArray("FINAL SORTED ARRAY!");
        System.out.println("\nResult: " + Arrays.toString(array));
    }

    private static void selectionSort() {
        System.out.println("\n========== SELECTION SORT ==========");
        sleep();
        
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            displayArray("Finding minimum from position " + i, i, -1);
            sleep();
            
            for (int j = i + 1; j < n; j++) {
                displayArray("Checking position " + j, minIndex, j);
                sleep();
                
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    displayArray("New minimum at position " + minIndex, minIndex, -1);
                    sleep();
                }
            }
            
            if (minIndex != i) {
                displayArray("Swapping position " + i + " and " + minIndex, i, minIndex);
                sleep();
                
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                
                displayArray("Swap complete", i, minIndex);
                sleep();
            }
        }
        
        displayArray("FINAL SORTED ARRAY!");
        System.out.println("\nResult: " + Arrays.toString(array));
    }

    private static void insertionSort() {
        System.out.println("\n========== INSERTION SORT ==========");
        sleep();
        
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            
            displayArray("Key = " + key + " at position " + i, i, -1);
            sleep();
            
            while (j >= 0 && array[j] > key) {
                displayArray("Shifting " + array[j] + " to right", j, j+1);
                sleep();
                
                array[j+1] = array[j];
                j--;
            }
            
            if (j+1 != i) {
                array[j+1] = key;
                displayArray("Placed " + key + " at position " + (j+1), j+1, -1);
                sleep();
            }
        }
        
        displayArray("FINAL SORTED ARRAY!");
        System.out.println("\nResult: " + Arrays.toString(array));
    }

    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Enter number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }
}