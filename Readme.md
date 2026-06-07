# Sorting Algorithm Visualizer

A console-based Java application that visualizes three popular sorting algorithms step by step.

## Features

- Visualize Bubble Sort, Selection Sort, and Insertion Sort
- User inputs custom array of numbers
- Step-by-step visualization showing comparisons and swaps
- Clean, simple console output

## Prerequisites

- Java 8 or higher
- Any terminal/command prompt

## How to Run

1. Compile the program:
```bash
javac SortingVisualizer.java
```

2. Run the program:
```bash
java SortingVisualizer
```

## How to Use

1. Enter numbers when prompted (space-separated)
   ```
   Example: 5 2 8 1 9 3 7 4 6
   ```

2. Choose a sorting algorithm:
   - 1 - Bubble Sort
   - 2 - Selection Sort  
   - 3 - Insertion Sort
   - 4 - Exit

3. Watch the step-by-step visualization:
   - Numbers are displayed with their indices
   - `^` indicates which elements are being compared
   - Program shows when swaps occur

## Sorting Algorithms

### Bubble Sort
- Repeatedly steps through the list
- Compares adjacent elements and swaps them if they're in wrong order
- Time Complexity: O(n²)

### Selection Sort
- Divides array into sorted and unsorted parts
- Repeatedly selects minimum element from unsorted part
- Time Complexity: O(n²)

### Insertion Sort
- Builds final sorted array one element at a time
- Takes each element and inserts it into correct position
- Time Complexity: O(n²)

## Sample Run

```
=========================================
     SORTING ALGORITHM VISUALIZER
=========================================

Enter numbers separated by spaces:
> 5 2 8 1 9

Array: [5, 2, 8, 1, 9]

=========================================
Array: [5, 2, 8, 1, 9]
=========================================
1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Exit
=========================================
Your choice (1-4): 1

========== BUBBLE SORT ==========

Step: Comparing position 0 and 1
--------------------------------------------------
   5   2   8   1   9
   ^   ^
   0   1   2   3   4

Comparing 5 and 2
-> Swapping
```

## Project Structure

```
SortingVisualizer/
├── SortingVisualizer.java
├── README.md
└── .gitignore
```

## Author

Your Name

## License

This project is open source and available for learning purposes.
```

These files will help you manage your project properly with Git and provide clear documentation for anyone using your sorting visualizer!
