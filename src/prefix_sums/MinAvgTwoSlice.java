package prefix_sums;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
        System.out.println(minAvgTwoSlice.solution(new int[] {4,2,2,5,1,5,8}));
    }

    public int solution(int[] A) {
        int len = A.length;
        int[] tracks = new int[len];
        tracks[0] = 0;
        for (int i = 1; i < len; i++) {
            tracks[i] = tracks[i-1] + A[i-1];
        }

        float min = Integer.MAX_VALUE;
        int minIndx = 0;
        for (int i = 0; i < len; i++) {
            // Proven to be 2 or 3
            // Can be proven with reverse truth
            for (int j = i + 1; j < i + 3 && j < len; j++) {
                float mean = (float) (tracks[j] - tracks[i] + A[j]) / (j - i + 1);
                if (mean < min) {
                    min = mean;
                    minIndx = i;
                }
            }
        }

        return minIndx;
    }
}
