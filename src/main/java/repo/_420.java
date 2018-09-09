package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _420 extends BaseProblem {

    public _420(InputStream in, PrintStream out) {
        super(in, out);
    }

    private boolean checkIfIsEqual(String base, String vem) {
        HashMap<Character, Character> dic = new HashMap<>();
        for (int i = 0; i < 43; i++)
            dic.put(vem.charAt(i), base.charAt(i));
        char[] arr = vem.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (dic.get(arr[i]) != base.charAt(i))
                return false;
        }
        return true;
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int qttestes = 0;
        scanner.nextLine();
        ArrayList<String> arr = new ArrayList<>();
        String master = "";
        String base = "the quick brown fox jumps over the lazy dog";
        scanner.nextLine();
        boolean sinal = false;
        while (qttestes < n) {
            String vem = "";
            if (scanner.hasNextLine())
                vem = scanner.nextLine();
            if (vem.equals("")) {
                sinal = false;
                qttestes++;
                if (master.isEmpty()) {
                    out.println("No solution.\n");
                    arr.clear();
                    continue;
                }
                HashMap<Character, Character> dic = new HashMap<>();
                for (int i = 0; i < 43; i++)
                    dic.put(master.charAt(i), base.charAt(i));
                for (String s : arr) {
                    for (Character c : s.toCharArray())
                        out.print(dic.get(c));
                    out.println();
                }
                out.println();
                arr.clear();
                master = "";
                continue;
            }
            arr.add(vem);
            if (base.length() == vem.length() && checkIfIsEqual(base, vem) && !sinal) {
                master = vem;
                sinal = true;
            }

        }
    }
}
