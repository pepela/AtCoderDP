import java.util.Scanner;

public class BFrog {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        int K = stdIn.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            int h = stdIn.nextInt();
            heights[i] = h;
        }

        System.out.println(solve(heights, K));
    }

    private static int solve(int[] h, int k) {
        int[] w = new int[h.length];

        w[0] = 0;

        for (int i = 1; i < h.length; i++) {
            int o = Math.min(k, i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= o; j++) {
                min = Math.min(min, w[i - j] + Math.abs(h[i - j] - h[i]));
            }

            w[i] = min;
        }

        return w[w.length - 1];
    }
}
