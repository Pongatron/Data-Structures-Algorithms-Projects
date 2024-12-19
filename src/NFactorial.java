import java.util.Scanner;

public class NFactorial {

    public static int nFactorial(int n)
    {
        if(n==0 || n==1)
            return 1;
        else
            return n * nFactorial(n - 1);
    }

    public static void main (String[] args) {
        Scanner k = new Scanner(System.in);

        System.out.println("Enter number:");
        int n = k.nextInt();
        System.out.println(n+"! = "+nFactorial(n));



    }
}
