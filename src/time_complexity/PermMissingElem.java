package time_complexity;

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        System.out.println(permMissingElem.solution(new int[] {2,3,1,5}));
    }

    public int solution(int[] A) {
        // Implement your solution here
        int len = A.length;
        long expected = ((long) (1 + len + 1) * (long) (len + 1)) / 2;
        long actual = 0;
        for (int i = 0; i < len; i++) {
            actual += (long) A[i];
        }

        return (int) (expected - actual);
    }
}
