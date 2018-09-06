package driver;

import repo.BaseProblem;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            BaseProblem bp = (BaseProblem) Class.forName("repo._" + scanner.nextInt()).newInstance();
            bp.solve();
        } catch (ClassNotFoundException e) {
            System.out.println("Problema não encontrado no repositório");
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
