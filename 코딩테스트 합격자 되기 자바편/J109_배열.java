import java.util.Arrays;
import java.util.Collections;


// 교재 105쪽

public class J109_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] solution(int[] arr) {
        Integer[] arr2 = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());
        return Arrays.stream(arr2).mapToInt(Integer::intValue).toArray();
    }
}