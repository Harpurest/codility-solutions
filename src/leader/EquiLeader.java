package leader;

import java.util.ArrayDeque;
import java.util.Deque;

public class EquiLeader {
    public static void main(String[] args) {
        EquiLeader equiLeader = new EquiLeader();
        System.out.println(equiLeader.solution(new int[] {4,3,4,4,4,2}));
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
            return 0;
        }

        int candidate = deque.pop();
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (A[i] == candidate) {
                count += 1;
            }
        }

        if (count <= len / 2) {
            return 0;
        }

        int first = 0;
        int second = count;
        int splitCount = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] == candidate) {
                first += 1;
                second -= 1;
            }
            if (first > (i + 1) / 2 && second > (len - i - 1) / 2) {
                splitCount += 1;
            }
        }

        return splitCount;
    }
}
