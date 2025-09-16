package c07_stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
        System.out.println(fish.solution(
                new int[] {4,3,2,1,5},
                new int[] {0,1,0,0,0}
        ));
    }

    public int solution(int[] A, int[] B) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = A.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (B[i] == 0) {
                if (stack.isEmpty()) {
                    count += 1;
                } else {
                    while (!stack.isEmpty() && A[i] > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        count += 1;
                    }
                }
            } else if (B[i] == 1) {
                stack.push(A[i]);
            }

        }

        return count + stack.size();
    }
}
