package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class _778 extends BaseProblem {

    public _778(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String vem = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] arrayzin = vem.toCharArray();
            for (int i = 0; i < vem.length(); i++) {
                int cont = 0;
                if (arrayzin[i] == '[' && i + 1 < vem.length()) {
                    i++;
                    while (i < vem.length() && arrayzin[i] != ']' && arrayzin[i] != '[') {
                        sb.insert(cont++, arrayzin[i++]);
                    }
                    i--;
                }
                else if (arrayzin[i] == ']' && i + 1 < vem.length()) {
                    i++;
                    while (i < vem.length() && arrayzin[i] != ']' && arrayzin[i] != '[') {
                        sb.append(arrayzin[i++]);
                    }
                    i--;
                }
                else if (arrayzin[i] != ']' && arrayzin[i] != '[')
                    sb.append(arrayzin[i]);
            }
            out.println(sb.toString());
        }
    }
}
