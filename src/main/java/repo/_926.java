package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _926 extends BaseProblem {

    public _926(InputStream in, PrintStream out) {
        super(in, out);
    }

    private class _926Interval implements Comparable<_926Interval> {

        public int start, end;

        _926Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(_926Interval o) {
            return Integer.compare(start, o.start);
        }
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int tp = scanner.nextInt(), n = scanner.nextInt();
        ArrayList<_926Interval> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            arr.add(new _926Interval(scanner.nextInt(), scanner.nextInt()));
        });
        Collections.sort(arr);
        int cmin = arr.get(0).start, cmax = arr.get(0).end;
        for (_926Interval i : arr.subList(1, arr.size())) {
            if (i.start > cmax) {
                out.println(cmin + " " + cmax);
                cmin = i.start;
                cmax = i.end;
            } else if (i.end > cmax)
                cmax = i.end;
        }
        out.println(cmin + " " + cmax);
    }
}
