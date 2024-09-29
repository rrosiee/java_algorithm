// 수포자 분석
// 1번 : 1, 2, 3, 4, 5 반복
// 2번 : 2, 1, 2, 3, 2, 4, 2, 5 반복
// 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복

// 1. answer 수만큼 1, 2, 3번의 배열을 생성한다.
// 2. 각 배열별로 몇 개 맞는지 확인한다.
// 3. 가장 많은 문제를 맞힌 사람이 누구인지 확인한다.
// 4. 여러 명이 가장 많은 문제를 맞췄을 경우 번호수를 오름차순 정렬한다.

import java.util.Arrays;
import java.util.ArrayList;

public class J117_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public int[] solution(int[] answers) {
        // 1. answer 수만큼 1, 2, 3번의 배열을 생성한다.
        int size = answers.length;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] arrCount = new int[3];
        ArrayList<Integer> result = new ArrayList<>();


        for (int i=0; i<size; i++) {
            if (answers[i] == arr1[i%arr1.length]) {
                arrCount[0] += 1;
            }
        }
        for (int i=0; i<size; i++) {
            if (answers[i] == arr2[i%arr2.length]) {
                arrCount[1] += 1;
            }
        }
        for (int i=0; i<size; i++) {
            if (answers[i] == arr3[i%arr3.length]) {
                arrCount[2] += 1;
            }
        }

        // 3. 가장 많은 문제를 맞힌 사람이 누구인지 확인한다.
        int maxNum = Arrays.stream(arrCount).max().getAsInt();
        for (int i=0; i<3;i++){
            if (arrCount[i] == maxNum) {
                result.add(i+1);
            }
        }

        int[] answer = result.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}