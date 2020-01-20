package heaps;

public class MinHeap {

    private int arr[] ;
    private int capacity ;
    private int heap_size ;

    int parent(int i ) { return (i-1)/2 ;}
    int left(int i ) { return (2*i) + 1 ;}
    int right(int i ) { return (2*i) + 2 ;}

    public MinHeap(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.heap_size = 0 ;
    }

    public void insertKey(int k ){

        heap_size++;
        int i = heap_size - 1;
        arr[i] = k;

        while( i != 0 && (arr[parent(i)] > arr[i])){
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp ;
            i = parent(i) ;
        }

    }
    public void decreaseKey(int i , int new_val){
        arr[i] = new_val;
        while (i != 0 && arr[parent(i)] > arr[i])
        {
            int temp = arr[i] ;
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }
    public int extractMin(){
        if (heap_size <= 0)
            return -1;
        if (heap_size == 1)
        {
            heap_size--;
            return arr[0];
        }


        int root = arr[0];
        arr[0] = arr[heap_size-1];
        arr[heap_size-1]=0;
        heap_size--;

        MinHeapify(0);

        return root;
    }

    private void MinHeapify(int i) {

        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && arr[l] < arr[smallest])
            smallest = l;
        if (r < heap_size && arr[r] < arr[smallest])
            smallest = r;
        if (smallest != i)
        {
            int temp = arr[i] ;
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            MinHeapify(smallest);
        }
    }

    public static void main(String[] args) {

    }
}
