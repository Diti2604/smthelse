import java.util.Random;

public class heapSort {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        for (int size : sizes) {
            System.out.println("Array size: " + size);

            int[] array = generateRandomArray(size);

            long beginningTime, finishingTime;

            int[] insertionSortArray = array.clone();
            beginningTime = System.nanoTime();
            insertionSort(insertionSortArray);
            finishingTime = System.nanoTime();
            System.out.println("Insertion Sort: " + (finishingTime - beginningTime) + " nanoseconds");

            int[] mergeSortArray = array.clone();
            beginningTime = System.nanoTime();
            mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
            finishingTime = System.nanoTime();
            System.out.println("Merge Sort: " + (finishingTime - beginningTime) + " nanoseconds");

            int[] quickSortArray = array.clone();
            beginningTime = System.nanoTime();
            quickSort(quickSortArray, 0, quickSortArray.length - 1);
            finishingTime = System.nanoTime();
            System.out.println("Quick Sort: " + (finishingTime - beginningTime) + " nanoseconds");

            int[] heapSortArray = array.clone();
            beginningTime = System.nanoTime();
            heapSort(heapSortArray);
            finishingTime = System.nanoTime();
            System.out.println("Heap Sort: " + (finishingTime - beginningTime) + " nanoseconds");

            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, l, L, 0, n1);
        System.arraycopy(array, m + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[max]) {
            max = left;
        }

        if (right < n && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            int swap = array[i];
            array[i] = array[max];
            array[max] = swap;

            heapify(array, n, max);
        }
    }
}
