import java.lang.System;

public class Mergesort  {
    private int[] list;
    private int[] result;
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
        result = new int[length];
        count = 0;
        movement = 0;

        if (print) {
            System.out.print("Running mergeSort on list:  ");
            displayArray(0, length-1);
            System.out.print("\n");
        }   
        mergeSort(0, length-1);
        if (print) {
            System.out.print("\nFinished sort:\n");
            displayArray(0, length-1);
            System.out.print("\n");
        }
    }

    private void mergeLists(int start1, int end1, int start2, int end2) {
        int finalStart = start1;
        int finalEnd = end2;
        int indexC = 0; 
        while ((start1 <= end1) && (start2 <= end2)) {
            if (list[start1] < list[start2]) {
                result[indexC] = list[start1];
                start1++;
            } else {
                result[indexC] = list[start2];
                start2++;
            }
            indexC++;

            movement++;
            count++;
        }
        while (start1 <= end1) {
            result[indexC] = list[start1];
            start1++;
            indexC++;

            movement++;
        }
        while (start2 <= end2) {
            result[indexC] = list[start2];
            start2++;
            indexC++;

            movement++;
        }
        indexC = 0;
        for (int i = finalStart; i <= finalEnd; i++) {
            list[i] = result[indexC];
            indexC++;

            movement++;
        }
    }

    private void mergeSort(int first, int last) {
        if (print)
            displayArray(first, last);
        if (first < last) {
            if (last - first < 3) {
                insertionSort(first, last);
            } else {
                int middle = (first + last) / 2;
                mergeSort(first, middle);

                if (print) 
                    System.out.print("\n");

                mergeSort(middle+1, last);
                mergeLists(first, middle, middle+1, last);
            }
        }
        if (print) {
            System.out.print("===>");
            displayArray(0, length-1);
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


}
	
