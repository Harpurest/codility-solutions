package counting_elements;

public class MaxCounters {
    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int[] res = maxCounters.solution(5, new int[] {3,4,4,6,1,4,4});
        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] solution(int N, int[] A) {
        int[] res = new int[N];
        int currentMin = 0;
        int trackingMax = 0;
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value >= N + 1) {
                currentMin = trackingMax;
            } else {
                if (res[value - 1] < currentMin) {
                    res[value - 1] = currentMin;
                }
                res[value - 1] += 1;
                if (res[value - 1] > trackingMax) {
                    trackingMax = res[value - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (res[i] < currentMin) {
                res[i] = currentMin;
            }
        }
        return res;
    }
}
