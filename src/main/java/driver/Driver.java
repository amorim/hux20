package driver;

import repo.BaseProblem;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //File file = new File("4372.in");
            BaseProblem bp = (BaseProblem) Class.forName("repo._" + scanner.nextInt()).newInstance();
            //bp.setInputStream(new FileInputStream(file));
            scanner.nextLine();
            bp.solve();

        } catch (ClassNotFoundException e) {
            System.out.println("Problema não encontrado no repositório");
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }// catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
    }
}
