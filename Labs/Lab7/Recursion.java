package Lab7;

import java.util.Scanner;
class RecursionOrder {
    public static void printAscending(int n) {
        if (n == 0) return;
        printAscending(n - 1);
        System.out.print(n + " ");
    }
    public static void printDescending(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printDescending(n - 1);}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.println("Numbers in ascending order:");
        printAscending(n);
        System.out.println("\nNumbers in descending order:");
        printDescending(n);
    }}
