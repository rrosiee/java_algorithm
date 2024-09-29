// 수포자 분석
// 1번 : 1, 2, 3, 4, 5 반복
// 2번 : 2, 1, 2, 3, 2, 4, 2, 5 반복
// 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복

// 1. answer 수만큼 1, 2, 3번의 배열을 생성한다.
// 2. 각 배열별로 몇 개 맞는지 확인한다.
// 3. 가장 많은 문제를 맞힌 사람이 누구인지 확인한다.
// 4. 여러 명이 가장 많은 문제를 맞췄을 경우 번호수를 오름차순 정렬한다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class J123_배열 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = solution(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public int[] solution(int N, int[] stages) {
        int[] players = new int[N + 2];
        Double total = (double)stages.length;
        HashMap<Integer, Double> failedPercent = new HashMap<>();

        // player 수 구하기
        for (int i=0; i < stages.length; i++) {
            players[stages[i]] += 1;
        }

        for (int i=1; i<N+1;i++) {
            if (players[i] == 0) {
                failedPercent.put(i, 0.);
            } else {
                failedPercent.put(i, players[i]/total);
            }
            total -= players[i];
        }

        return failedPercent.entrySet().stream().sorted((k, v) -> Double.compare(v.getValue(), k.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}