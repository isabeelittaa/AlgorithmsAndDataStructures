import java.util.Random;

public class Sorter {
    private final Random random = new Random();

    // Category A: Basic sorting algorithm (Insertion Sort).
    public void basicSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Category B: Advanced sorting algorithm (Merge Sort).
    public void advancedSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftHalf = new int[mid - left + 1];
        int[] rightHalf = new int[right - mid];

        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = arr[left + i];
        }
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            } else {
                arr[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            arr[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            arr[k++] = rightHalf[j++];
        }
    }

    public void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10 + 1);
        }
        return arr;
    }
}
