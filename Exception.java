import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double x = sc.nextInt();
        double y = sc.nextInt();

        if (y < 2 * x){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        sc.close();
    }
}

