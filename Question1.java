import java.util.Arrays;
import java.util.Scanner;

public class ArraySwap {

    public static boolean canSwapArrays(int m, int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        // If the sums are not equal, no swap can make them equal
        if (sumA != sumB) {
            return false;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int diff = sumA - A[i] + B[j];

            if (diff == sumB) {
                return true;
            } else if (diff < sumB) {
                i++;
            } else {
                j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of m: ");
        int m = scanner.nextInt();

        System.out.print("Enter the size of arrays A and B: ");
        int n = scanner.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        System.out.println("Enter the elements of array A:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Enter the elements of array B:");
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        boolean result = canSwapArrays(m, A, B);
        System.out.println("Can swap arrays to make sums equal: " + result); //Returns true or false
    }
}

/* 

Complexity Analysis:

Time Complexity: O(n log n) due to sorting, where n is the length of the arrays A or B.
Space Complexity: O(1) as the sorting is done in-place without using any extra space.

*/