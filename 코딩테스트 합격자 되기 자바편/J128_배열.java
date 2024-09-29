// 목표 : O(N) 으로 풀기
// 1. 움직였다고 가정했을 때, 좌표 평면을 벗어나는지 확인한다.
// 2. 만약 좌표평면을 벗어나지 않는다면 움직인다.
// 3. 움직인 경로를 기록한다.(HashSet으로..!!)

import java.util.HashMap;
import java.util.HashSet;

public class J128_배열 {
    private static boolean isValidMove(int nx, int ny) {
        System.out.println("nx : " + nx + ", ny: " + ny);
        return nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5;
    }

    private static final HashMap<String, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put("U", new int[]{0, 1});
        location.put("D", new int[]{0, -1});
        location.put("R", new int[]{1, 0});
        location.put("L", new int[]{-1, 0});
    }

    public int solution(String dirs) {
        initLocation();

        int nx = 0;
        int ny = 0;
        int x = 0;
        int y = 0;
        HashSet<String> movedLocations = new HashSet<>();

        for (String dir : dirs.split("")) {
            nx = x + location.get(dir)[0];
            ny = y + location.get(dir)[1];
            if (!isValidMove(nx, ny)) {
                continue;
            }

            movedLocations.add(x + " " + y + " " + nx + " "+ ny);
            movedLocations.add(nx + " " + ny + " " + x + " "+ y);

            x = nx;
            y = ny;
        }
        System.out.println(movedLocations.toString());
        return movedLocations.size()/2;
    }
}