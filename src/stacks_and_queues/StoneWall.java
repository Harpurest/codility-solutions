package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {

    public static void main(String[] args) {
        StoneWall stoneWall = new StoneWall();
        System.out.println(stoneWall.solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

    public int solution(int[] H) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = H.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(H[i]);
                count += 1;
            } else {
                if (H[i] == stack.peek()) {
                    continue;
                } else if (H[i] > stack.peek()) {
                    stack.push(H[i]);
                    count += 1;
                } else if (H[i] < stack.peek()) {
                    while (!stack.isEmpty() && H[i] < stack.peek()) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && H[i] == stack.peek()) {
                        continue;
                    }
                    stack.push(H[i]);
                    count += 1;
                }
            }
        }

        return count;
    }
}
