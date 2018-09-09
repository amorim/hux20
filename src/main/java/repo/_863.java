package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class _863 extends BaseProblem {

    public _863(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Stack<Integer> back = new Stack<>(), forward = new Stack<>();
        Scanner scanner = new Scanner(in);
        int navigationNow = -1;
        while (scanner.hasNextLine()) {
            String vem = scanner.nextLine();
            if (vem.equals("ENTER")) {
                if (navigationNow != -1) {
                    back.push(1);
                    forward.clear();
                }
                else
                    navigationNow = 1;
            }
            else if (vem.equals("BACK"))
                forward.push(back.pop());
            else
                back.push(forward.pop());

        }
        out.println("BACK: " + back.size() + "\n" + "FORWARD: " + forward.size());
    }
}
