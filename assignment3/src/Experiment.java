import java.util.Arrays;

public class Experiment {
    private final Sorter sorter;
    private final Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] workingCopy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();

        if ("basic".equalsIgnoreCase(type)) {
            sorter.basicSort(workingCopy);
        } else if ("advanced".equalsIgnoreCase(type)) {
            sorter.advancedSort(workingCopy);
        } else {
            throw new IllegalArgumentException("Unknown sort type: " + type);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000, 5000};

        System.out.println("=== Assignment 3: Sorting and Searching Analysis ===");
        System.out.println("Algorithms selected:");
        System.out.println("- Basic Sort: Insertion Sort");
        System.out.println("- Advanced Sort: Merge Sort");
        System.out.println("- Search: Binary Search");
        System.out.println();

        for (int size : sizes) {
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);

            long basicRandomTime = measureSortTime(randomArray, "basic");
            long advancedRandomTime = measureSortTime(randomArray, "advanced");
            long basicSortedTime = measureSortTime(sortedArray, "basic");
            long advancedSortedTime = measureSortTime(sortedArray, "advanced");

            int targetExisting = sortedArray[sortedArray.length / 2];
            int targetMissing = -1;
            long searchExistingTime = measureSearchTime(sortedArray, targetExisting);
            long searchMissingTime = measureSearchTime(sortedArray, targetMissing);

            printSectionHeader(size);
            printSortResults("Random input", basicRandomTime, advancedRandomTime);
            printSortResults("Sorted input", basicSortedTime, advancedSortedTime);
            printSearchResults(searchExistingTime, searchMissingTime);
        }
    }

    private void printSectionHeader(int size) {
        System.out.println("--------------------------------------------");
        System.out.println("Array size: " + size);
    }

    private void printSortResults(String inputType, long basicTime, long advancedTime) {
        System.out.println(inputType + " sort timings:");
        System.out.println("  Insertion Sort (basic): " + basicTime + " ns");
        System.out.println("  Merge Sort (advanced):  " + advancedTime + " ns");
    }

    private void printSearchResults(long existingTargetTime, long missingTargetTime) {
        System.out.println("Binary Search timings (sorted array):");
        System.out.println("  Existing target: " + existingTargetTime + " ns");
        System.out.println("  Missing target:  " + missingTargetTime + " ns");
        System.out.println();
    }
}
