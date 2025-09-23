package c15_caterpillar_method;

import java.util.Arrays;

public class CountTriangles {

    public static void main(String[] args) {
        CountTriangles countTriangles = new CountTriangles();
        int res;

        res = countTriangles.solution(new int[] {10, 2, 5, 1, 8, 12});
        System.out.println(res);

        res = countTriangles.solution(new int[] {3, 3, 5, 6});
        System.out.println(res);
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);

        return count;
    }
}
