package c08_leader;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dominator {

    public static void main(String[] args) {
        Dominator dominator = new Dominator();
        System.out.println(dominator.solution(new int[] {3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(dominator.solution(new int[] {2, 1, 1, 3, 4}));
    }

    public int solution(int[] A) {
        int len = A.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (deque.isEmpty()) {
                deque.push(A[i]);
            } else {
                if (A[i] != deque.peek()) {
                    deque.pop();
                } else {
                    deque.push(A[i]);
                }
            }
        }
        if (deque.isEmpty()) {
            return -1;
        }
        int candidate = deque.pop();
        int candidateIndex = -1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] == candidate) {
                count += 1;
                candidateIndex = i;
            }
        }
        if (count > len / 2) {
            return candidateIndex;
        }

        return -1;
    }
}
