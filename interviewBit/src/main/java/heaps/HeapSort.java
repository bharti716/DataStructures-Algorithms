package heaps;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = new int[]{10 ,9 ,8 ,7 ,6 ,5 ,4 ,3 ,2 ,1};
        int n = 10;

        heap_sort(arr, n);
        printArray(arr);
    }

    private static void printArray(int arr[]) {
        for (int anArr : arr) System.out.print(anArr + " ");
        System.out.println();
    }

    private static void heap_sort(int[] arr, int n) {

        buildMaxHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void buildMaxHeap(int[] arr, int n) {

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
