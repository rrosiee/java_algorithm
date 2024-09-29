
// 1. 1번 배열 연산을 시작한다.
// 2. 1번 배열 연산을 할 때 2번 배열 연산을 한다.

import java.util.Arrays;

public class J120_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }


    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[][] result = new int[arr1Length][arr2[0].length];


        for (int i=0; i < arr1Length; i++) {
            for (int j=0; j< arr2[0].length; j++) {
                for (int k=0; k < arr1[0].length; k ++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }
}