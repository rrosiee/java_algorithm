import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


// 교재 105쪽

public class J113_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public int[] solution(int[] numbers) {
        // 1. 두 개의 수를 뽑는 경우의 수를 구한다.
        int size = numbers.length;

        ArrayList<Integer> sum_numbers = new ArrayList<>();

        for (int i=0; i < size - 1; i++) {
            for (int j=i + 1; j < size; j++) {
                // 2. 구한 수를 더한다.
                sum_numbers.add(i + j);
            }
        }

        // 3. 중복을 제거한다.
        Integer[] distinct_numbers = sum_numbers.stream().distinct().toArray(Integer[]::new);

        // 4. 오름차순으로 정렬한다.
        Arrays.sort(distinct_numbers);
        int[] answer = Arrays.stream(distinct_numbers).mapToInt(Integer::intValue).toArray();

        return answer;
    }
}