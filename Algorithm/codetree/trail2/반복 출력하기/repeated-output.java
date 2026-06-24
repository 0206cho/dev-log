import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        printNStarts(n);
    }

    public static void printNStarts(int n){
        for(int i=0; i<n; i++){
            System.out.println("12345^&*()_");
        }
    }
}