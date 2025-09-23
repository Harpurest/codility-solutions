package c15_caterpillar_method;

public class CountDistinctSlices {

    public static void main(String[] args) {
        CountDistinctSlices countDistinctSlices = new CountDistinctSlices();
        int res;
        res = countDistinctSlices.solution(6, new int[] {3, 4, 5, 5, 2});
        System.out.println(res);
    }

    public int solution(int M, int[] A) {
        int[] tracks = new int[M + 1];
        int len = A.length;
        int count = 0;
        int head = 0;
        for (int i = 0; i < len; i++) {
            int target = A[i];
            if (tracks[target] == 0) {
                tracks[target] = 1;
            } else {
                while(tracks[target] == 1) {
                    tracks[A[head]] = 0;
                    head += 1;
                }
                tracks[target] = 1;
            }
            count += (i - head + 1);

            if (count > 1000000000) {
                return 1000000000;
            }
        }

        return count;
    }
}
