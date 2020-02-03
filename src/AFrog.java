import java.util.Scanner;

public class AFrog {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            int h = stdIn.nextInt();
            heights[i] = h;
        }

        System.out.println(solve(heights));
    }

    private static int solve(int[] h) {
        int[] w = new int[h.length];

        w[0] = 0;
        w[1] = Math.abs(h[1] - h[0]);

        for (int i = 2; i < h.length; i++) {
            w[i] = Math.min(w[i - 1] + Math.abs(h[i - 1] - h[i]), w[i - 2] + Math.abs(h[i - 2] - h[i]));
        }

        return w[w.length - 1];
    }
}
