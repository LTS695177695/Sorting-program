import java.lang.System;

public class Quicksort  {
    private int[] list;
    private int length;
    private int count;
    private int movement;
    private boolean print;

    public int getCount() {
        return count;
    }

    public int getMovement() {
        return movement;
    }

    public void sort(int[] list, boolean print) {
        this.list = list;
        this.length = list.length;
        this.print = print;
        count = 0;
        movement = 0;

        if (print) {
            System.out.print("Running quickSort on list:  ");
            displayArray(0, length-1);
            System.out.print("\n");
        }   
        quicksort(0, length-1);
        if (print) {
            System.out.print("\nFinished sort:\n");
            displayArray(0, length-1);
            System.out.print("\n");
        }
    }

    private void displayArray(int low, int high) {
        System.out.print("[ ");
        for (int i = low; i <= high; i++) {
            System.out.print(list[i]);
            System.out.print(" ");
        }
        System.out.print("]\n");
    }

    private int medianIndex(int low, int high) {
        int a = list[low], b = list[high];
        int c = list[(low+high)/2];
        if ((a-b)*(c-a) >= 0)
            return low;
        else if ((b-a)*(c-b) >= 0)
            return high;
        else 
            return (low+high)/2;
    }

    private void insertionSort(int low, int high) {
        for (int i = low+1; i <= high; i++) {
            for (int j = i-1; j >= low; j--) {
                if (list[i] < list[i-1]) {
                    swap(i, i-1);
                }
                count++;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
        movement++;
    }

    private int partition(int low, int high) {
        int p = medianIndex(low, high);
        swap(p,low);

        int pivot = list[low];
        int i = low+1, j = high;
        while (i <= j) {
            while (list[i] <= pivot){
                i++;
                count++;
            }
            while (list[j] > pivot){
                j--;
                count++;
            }
            if (i < j){
                swap(i, j);   
            }
        }
        swap(low,j);
        return j;
    }

    private void quicksort(int low, int high) {
        
        if (print)
            displayArray(low,high);

        if (low < high) {
            if (high - low < 3) {
                insertionSort(low, high);
            } else {
                int p = partition(low, high);
                quicksort(low, p-1);

                if (print) 
                    System.out.print("\n");

                quicksort(p+1, high);
            }
        }

        if (print) {
            System.out.print("===>");
            displayArray(0,length-1);
        }
    }

    
}
	
