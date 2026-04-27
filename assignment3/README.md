Assignment 3:
Project Overview
This project compares the practical performance of three algorithms:
- Insertion Sort
- Merge Sort
- Binary Search

The goal is to analyze algorithm efficiency using "System.nanoTime()" across different input sizes and input structures.

Repository Structure:
assignment3/
    src/
        Sorter.java
        Searcher.java
        Experiment.java
        Main.java
    docs/
        screenshots/
        results/
    README.md

Algorithm Descriptions
1) Insertion Sort (Basic)
Insertion Sort builds a sorted portion of the array one element at a time by inserting each new element into its correct place.
- Best case: O(n) (already sorted input)
- Average case: O(n^2)
- Worst case: O(n^2)

2) Merge Sort (Advanced)
Merge Sort is a divide-and-conquer algorithm. It splits the array into halves, recursively sorts each half, then merges them.
- Best case: O(n log n)
- Average case: O(n log n)
- Worst case: O(n log n)

3) Binary Search (Searching)
Binary Search repeatedly checks the middle element and discards half of the remaining elements each step.
- Best case: O(1)
- Average case: O(log n)
- Worst case: O(log n)

How to Run
From the project root(terminal):
**javac -d out src/*.java**
**java -cp out Main**

Experimental Results
Execution Time Tables:
1)Random Arrays
Array Size  |   Insertion Sort (ns) |   Merge Sort (ns)
    10      |          4,041        |       11,000
    100     |         107,583       |       86,958
    1000    |        2,173,042      |       506,084
    5000    |        22,397,292     |       622,125
2)Sorted Arrays
Array Size  |   Insertion Sort (ns) |   Merge Sort (ns)
    10      |           667         |        5,917
    100     |          4,083        |       71,750
    1000    |          5,834        |       214,333
    5000    |         261,459       |       261,625
3)Binary Search (on Sorted Arrays)
Array Size  |   Existing Target (ns)    |   Missing Target (ns)
    10      |          1,667            |          375
    100     |          1,125            |          375
    1000    |          3,416            |         1,000
    5000    |          2,125            |          541


Analysis Questions
1)Which sorting algorithm performed faster? Why?
Merge Sort is generally faster for medium and large arrays because `O(n log n)` grows much slower than `O(n^2)`.

2)How does performance change with input size?
As input size increases, execution time increases for all algorithms, but Insertion Sort grows much faster than Merge Sort.

3)How does sorted vs unsorted data affect performance?
Insertion Sort improves significantly on sorted input (close to best case `O(n)`), while Merge Sort remains relatively consistent.

4)Do results match expected Big-O complexity?
They should generally match complexity expectations, though small arrays may show noise due to JVM overhead and system activity.

5)Which searching algorithm is more efficient? Why?
Binary Search is efficient for sorted arrays because it reduces the search space by half each step (`O(log n)`).

6)Why does Binary Search require a sorted array?
Without sorted order, the algorithm cannot safely discard half of the data after each comparison.


Reflection
This assignment showed how implementation details and input characteristics affect practical runtime, even when asymptotic complexity is known in theory. Insertion Sort can be very competitive on small or already sorted arrays, but Merge Sort scales much better as array size increases. I also learned that performance measurements can vary between runs due to system state and JVM behavior. This reinforced the importance of running multiple trials and interpreting timing data as trends instead of absolute constants.