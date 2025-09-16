package c01_iterations;

class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(328 ));
    }
    public int solution(int N) {
        int maxDistance = 0;
        boolean foundOne = false;
        int currentDistance = 0;
        while (N > 0) {
            int mod = N % 2;
            if (mod == 1) {
                if (!foundOne) {
                    foundOne = true;
                    N /= 2;
                    continue;
                } else {
                    if (currentDistance > maxDistance) {
                        maxDistance = currentDistance;
                    }
                    currentDistance = 0;
                }
            } else {
                if (foundOne) {
                    currentDistance += 1;
                }
            }
            N /= 2;
        }
        return maxDistance;
    }
}
