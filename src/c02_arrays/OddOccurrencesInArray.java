package c02_arrays;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int result = oddOccurrencesInArray.solution(new int[]{9,3,9,3,9,7,9});
        System.out.println(result);
    }

    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if(set.contains(A[i])) {
                set.remove(A[i]);
            } else {
                set.add(A[i]);
            }
        }

        if (!set.isEmpty()) {
            return set.stream().findFirst().get();
        }
        return -1;
    }
}
