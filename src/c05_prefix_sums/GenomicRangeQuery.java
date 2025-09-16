package c05_prefix_sums;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        /*
        int[] res = genomicRangeQuery.solution(
                "CAGCCTA",
                new int[] {2, 5, 0},
                new int[] {4, 5, 6});
         */

        int[] res1 = genomicRangeQuery.solution(
                "AC",
                new int[] {0, 0, 1},
                new int[] {0, 1, 1});
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int sLen = S.length();
        int[][] tracks = new int[sLen][4];

        int resLen = P.length;
        int[] res = new int[resLen];

        char[] chars = S.toCharArray();
        for (int i = 1; i < sLen; i++) {
            int index = getIndex(chars[i-1]);
            for (int j = 0; j < 4; j++) {
                tracks[i][j] = tracks[i-1][j];
            }
            tracks[i][index] += 1;
        }

        for (int i = 0; i < resLen; i++) {
            int start = P[i];
            int end = Q[i];
            int[] pointTracks = new int[4];
            for (int j = 0; j < 4; j++) {
                pointTracks[j] = tracks[end][j] - tracks[start][j];
            }
            char endChar = chars[end];
            int endIndex = getIndex(endChar);
            pointTracks[endIndex] += 1;

            for (int j = 0; j < 4; j++) {
                if (pointTracks[j] > 0) {
                    res[i] = j + 1;
                    break;
                }
            }
        }

        return res;
    }

    private int getIndex (char c) {
        return switch (c) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'G' -> 2;
            case 'T' -> 3;
            default -> -1;
        };
    }
}
