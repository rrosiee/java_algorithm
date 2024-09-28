import java.util.Arrays;


// 교재 105쪽

public class J105_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] solution(int[] arr) {
        int[] cloneArr = arr.clone();
        Arrays.sort(cloneArr);
        return cloneArr;
    }
}