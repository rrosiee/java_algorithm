import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


// 교재 105쪽

public class J113_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] solution(int[] numbers) {

        int size = numbers.length;
        HashSet<Integer> distinct_set = new HashSet<>();

        for (int i=0; i < size-1; i++) {
            for (int j=i+1; j < size; j++) {
                distinct_set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = distinct_set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}