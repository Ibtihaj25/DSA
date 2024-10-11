package Lab7;

import java.util.Scanner;
class RecursionCharArray {
    public static void printForward(char[] arr, int index) {
        if (index == arr.length) return;
        System.out.print(arr[index] + " ");
        printForward(arr, index + 1);
    }
    public static void printReverse(char[] arr, int index) {
        if (index < 0) return;
        System.out.print(arr[index] + " ");
        printReverse(arr, index - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] arr = input.toCharArray();

        System.out.println("Array in forward direction:");
        printForward(arr, 0);
        System.out.println("\nArray in reverse direction:");
        printReverse(arr, arr.length - 1);
    }}