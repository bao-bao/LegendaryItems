/* Created by AMXPC on 2017/3/31. */

import java.util.Scanner;

public class LegendaryItems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();      // Item number
        int Q = scanner.nextInt();      // Q% increase when fail
        int P = scanner.nextInt();      // (P/power(2, has))% when has 'has' Item
        double result = getItems(P, Q, N, 0, 0, 0);
        System.out.println(result);
    }

    private static double getItems(int P, int Q, int N, int has, int deep, int step) {
        double temp = ((double)P / 100) / Math.pow(2, has) + ((double)Q / 100) * deep;
        if(temp >= 1) {
            temp = 1.0;
            return temp * getItems(P, Q, N, has + 1, 0, step + 1);
    }
        if(has == N) {
            return step;
        }
        return temp * getItems(P, Q, N, has + 1, 0, step + 1) + (1 - temp) * getItems(P, Q, N, has, deep + 1, step + 1);
    }
}
