import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if(1 <= a && a <= 100) {
            System.out.print(a +2);
        }

        sc.close();
    }
}