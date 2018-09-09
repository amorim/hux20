package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class _771 extends BaseProblem {

    public _771(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in).useLocale(Locale.US);
        int x = scanner.nextInt(), y = scanner.nextInt();
        int rets = 0, circles = 0;
        int vem = scanner.nextInt();
        scanner.nextLine();
        while (vem-- != 0) {
            String forma = scanner.nextLine();
            if (forma.equalsIgnoreCase("circulo")) {
                double xcentro = scanner.nextDouble(), ycentro = scanner.nextDouble(), raio = scanner.nextDouble();
                raio = Math.abs(raio);
                if ((x - xcentro) * (x-xcentro) + (y - ycentro) * (y - ycentro) <= raio * raio)
                    circles++;
            }
            else {
                double xmin = scanner.nextDouble(), ymin = scanner.nextDouble(), xmax = scanner.nextDouble(), ymax = scanner.nextDouble();
                if (x >= xmin && x <= xmax && y >= ymin && y <= ymax)
                    rets++;
            }
            if (scanner.hasNextLine())
                scanner.nextLine();
        }
        out.println("Retangulos: " + rets);
        out.println("Circulos: " + circles);
    }
}
