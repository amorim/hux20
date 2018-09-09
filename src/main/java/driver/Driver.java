package driver;

import repo.BaseProblem;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            BaseProblem bp = (BaseProblem) Class.forName("repo._" + scanner.nextInt())
                    .getConstructor(InputStream.class, PrintStream.class).newInstance(System.in, System.out);
            scanner.nextLine();
            bp.solve();
        } catch (ClassNotFoundException e) {
            System.out.println("Problema não encontrado no repositório");
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
