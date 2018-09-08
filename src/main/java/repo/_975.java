package repo;

import java.util.Scanner;

public class _975 extends BaseProblem {

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        String line = scanner.nextLine();
        String decode = line.replace("4", "a").replace("5", "e").replace("1", "i").replace("0", "o").replace("2", "u");
        int pos = 0;
        boolean capitalize = true;
        StringBuilder sb = new StringBuilder(decode);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        while (pos < sb.length()) {
            if (sb.charAt(pos) == '.') {
                capitalize = true;
            } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
                sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
                capitalize = false;
            }
            pos++;

        }
        out.println(sb.toString());
    }
}
