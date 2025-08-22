package time_complexity;

public class FrogJmp {
    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10, 85, 30));
    }

    public int solution(int X, int Y, int D) {
        int dis = Y - X;
        if (dis % D == 0) {
            return dis / D;
        } else {
            return dis / D + 1;
        }
    }
}
