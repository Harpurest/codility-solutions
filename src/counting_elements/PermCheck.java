package counting_elements;

public class PermCheck {
    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int result = permCheck.solution(new int[] {4, 1, 3, 2});
        System.out.println(result);
        result = permCheck.solution(new int[] {4, 1, 3});
        System.out.println(result);
    }

    public int solution(int[] A) {
        // Implement your solution here
        int len = A.length;
        int max = A[0];

        for (int i = 1; i < len; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        if (max > len) {
            return 0;
        }

        int[] tracks = new int[max + 1];

        for (int i = 0; i < len; i++) {
            if (A[i] > max) {
                continue;
            }
            if (tracks[A[i]] < 1) {
                tracks[A[i]] = 1;
            } else {
                return 0;
            }
        }
        return 1;
    }
}
