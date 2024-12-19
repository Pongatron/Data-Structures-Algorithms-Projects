import java.util.Scanner;

public class NFibonacci {

    public static int nFibonacci(int n)
    {
        if(n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else{
            return nFibonacci(n-1) + nFibonacci(n-2);
        }
    }

    public static void main (String[] args) {
        Scanner k = new Scanner(System.in);

        System.out.println("Enter number:");
        int n = k.nextInt();
        System.out.println("The "+n+" fibonacci number is "+nFibonacci(n));



    }
}
