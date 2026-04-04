package timus;

import java.util.Scanner;

public class task_1787 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();

        int leftCars = 0;

        for (int i = 0; i < n; i++){
            leftCars = leftCars + in.nextInt() - k;
            if (leftCars < 0){
                leftCars = 0;
            }
        }

        System.out.println(leftCars);
    }
}
