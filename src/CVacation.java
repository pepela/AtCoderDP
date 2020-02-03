import java.util.Scanner;

public class CVacation {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int N = stdIn.nextInt();
        Activity[] days = new Activity[N];

        for (int i = 0; i < N; i++) {
            int a = stdIn.nextInt();
            int b = stdIn.nextInt();
            int c = stdIn.nextInt();
            days[i] = new Activity(a, b, c);
        }

        Activity[] best = new Activity[N];
        best[0] = days[0];

        for (int i = 1; i < days.length; i++) {
            Activity prev = best[i - 1];
            Activity today = days[i];

            best[i] = new Activity(
                    Math.max(today.a + prev.b, today.a + prev.c),
                    Math.max(today.b + prev.a, today.b + prev.c),
                    Math.max(today.c + prev.a, today.c + prev.b));
        }

        Activity last = best[best.length - 1];
        System.out.println(Math.max(Math.max(last.a, last.b), last.c));
    }

    static class Activity {
        int a;
        int b;
        int c;

        public Activity(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
