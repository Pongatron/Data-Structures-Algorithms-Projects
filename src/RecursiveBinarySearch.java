import java.util.Scanner;
public class RecursiveBinarySearch {

    public static boolean binarySearch (int[] list, int target, int low, int high) {

        int middle = (low + high)/2;
        if (list[middle] == target) {
            return true; // termination case for successful search
        }
        else if (low > high) {
            return false; // termination case for unsuccessful search;
        }
        else if (list[middle] < target) {
            return binarySearch(list, target, middle + 1, high);
        }
        else {
            return binarySearch(list, target, low, middle - 1);
        }

    }

    public static void main (String[] args) {

        int[] list = {1, 2, 5, 7, 9, 11, 15};

        System.out.print("List: ");
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();

        Scanner k = new Scanner(System.in);
        System.out.println("Enter desired target:");
        int target = k.nextInt();

        boolean result = binarySearch(list, target, 0, list.length - 1);

        System.out.println("Target: "+target);
        if (!result)
            System.out.println("Target not found -- unsuccessful search.");
        else
            System.out.println("Target found -- successful search.");

    }
}
