import java.util.Scanner;
import java.io.*;

public class Sorting_Algorithms {

    public static void bubbleSort(int[] list){
        int exchanges = 0;
        int comparisons = 0;
        boolean cont = true;

        for(int i=1; i<list.length; i++){
            if(cont){
                cont = false;
                for(int j=0; j<list.length-i;j++){
                    comparisons++;
                    if(list[j]>list[j+1]){
                        int temp = list[j];
                        list[j] = list[j+1];
                        list[j+1] = temp;
                        exchanges++;
                        cont = true;
                    }
                }
            }
            else
                break;
        }
        System.out.println("Selected Bubble Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }
    public static void selectionSort(int[] list){
        int exchanges = 0;
        int comparisons = 0;

        for(int i=0; i<list.length-1; i++){
            int min = i;
            for(int j=i+1; j<list.length; j++){
                comparisons++;
                if(list[j]<list[min])
                    min = j;
            }
            int temp = list[min];
            list[min] = list[i];
            list[i] = temp;
            exchanges++;
        }
        System.out.println("Selected Selection Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }
    public static void insertionSort(int[] list){
        int exchanges = 0;
        int comparisons = 0;

        for(int i=1; i<list.length; i++){
            int current = list[i];
            int j = i;
            while(j > 0) {
                if (list[j - 1] > current) {
                    comparisons++;
                    list[j] = list[j - 1];
                    j = j - 1;
                    exchanges++;
                }
                else{
                    comparisons++;
                    break;
                }
            }
            list[j] = current;
        }
        System.out.println("Selected Insertion Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }

    public static void shellSort(int[] list){
        int exchanges = 0;
        int comparisons = 0;

        int h = (list.length-2)/2;
        while(h > 0){
            for(int i = h; i < list.length; i++){
                int temp = list[i];
                int j = i;
                while(j > h - 1){
                    if(list[j-h] > temp) {
                        comparisons++;
                        list[j] = list[j - h];
                        j = j - h;
                        exchanges++;
                    }
                    else{
                        comparisons++;
                        break;
                    }list[j] = temp;
                }
            }
            h = (h-2)/2;
        }
        System.out.println("Selected Shell Sort");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Exchanges: " + exchanges);
    }

    private static int quickSortComparisons = 0;
    private static int quickSortExchanges = 0;
    private static int[] quickSorted;
    public static void quickSort(int[] list, int lo, int hi){
        int pivotPoint = quickSortPartition(list, lo, hi);

        if(lo < pivotPoint)
            quickSort(list, lo, pivotPoint - 1);
        if(pivotPoint < hi)
            quickSort(list, pivotPoint + 1, hi);
        quickSorted = list;
    }
    public static int quickSortPartition(int[] list, int lo, int hi){
        int pivot = list[lo];
        while(lo < hi){
            while(pivot < list[hi] && lo < hi) {
                hi--;
                quickSortComparisons++;
            }
            if(hi != lo){
                list[lo] = list[hi];
                lo++;
                quickSortExchanges++;
            }
            while(list[lo] < pivot && lo < hi) {
                lo++;
                quickSortComparisons++;
            }
            if(hi != lo){
                list[hi] = list[lo];
                hi--;
                quickSortExchanges++;
            }
        }
        list[hi] = pivot;
        return hi;
    }

    private static int heapSortComparisons = 0;
    private static int heapSortExchanges = 0;
    public static void heapSort(int[] list){

        int n = list.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(list, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapSortExchanges++;
            heapify(list, 0, i);
        }
    }

    public static void heapify(int[] list, int i, int n){
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n){
            heapSortComparisons++;
            if(list[leftChild] > list[largest]) {
                largest = leftChild;
            }
        }

        if (rightChild < n){
            heapSortComparisons++;
            if(list[rightChild] > list[largest]) {
                largest = rightChild;
            }
        }

        if (largest != i) {
            int temp = list[i];
            list[i] = list[largest];
            list[largest] = temp;
            heapSortExchanges++;
            heapify(list, largest, n);
        }
    }

    public static void main (String[] args) throws IOException{
        Scanner k = new Scanner(System.in);

        System.out.println("Enter file name:");
        String filename = k.nextLine();
        File f = new File(filename);
        Scanner infile1 = new Scanner(f);

        int listSize = 0;
        while(infile1.hasNextInt()) {
            listSize++;
            infile1.nextInt();
        }
        infile1.close();
        int[] list = new int[listSize];
        Scanner infile2 = new Scanner(f);
        int index = 0;
        while(infile2.hasNextInt()){
            list[index] = infile2.nextInt();
            index++;
        }
        infile2.close();

        System.out.println("Enter 1, 2, 3, 4, 5, or 6:\n1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort");
        System.out.println("4. Shell Sort\n5. Quick Sort\n6. Heap Sort");
        int choice = k.nextInt();

        while(choice < 1 || choice > 6){
            System.out.println("Invalid Choice. \nEnter 1, 2, 3, 4, 5, or 6");
            choice = k.nextInt();
        }

        if(choice == 1){
            bubbleSort(list);
        }
        else if(choice == 2){
            selectionSort(list);
        }
        else if(choice == 3){
            insertionSort(list);
        }
        else if(choice == 4){
            shellSort(list);
        }
        else if(choice == 5){
            quickSort(list, 0, list.length-1);
            System.out.println("Selected Quick Sort");
            System.out.println("Comparisons: " +quickSortComparisons);
            System.out.println("Exchanges: " + quickSortExchanges);
        }
        else{
            heapSort(list);
            System.out.println("Selected Heap Sort");
            System.out.println("Comparisons: " +heapSortComparisons);
            System.out.println("Exchanges: " + heapSortExchanges);
        }

    }
}
