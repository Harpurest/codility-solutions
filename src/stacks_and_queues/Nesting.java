package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {
    public static void main(String[] args) {
        Nesting nesting = new Nesting();
        System.out.println(nesting.solution("(()(())())"));
        System.out.println(nesting.solution("())"));
    }
    public int solution(String S) {
        char[] chars = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                if ((chars[i] == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }
}
