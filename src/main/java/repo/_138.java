package repo;

import java.util.Scanner;

public class _138 extends BaseProblem {

    private class Car {
        public int id, comp, pos;

        public Car(int id, int comp) {
            this.id = id;
            this.comp = comp;
        }
    }

    private boolean parkCarInParkingLotIfAnySpaceIsAvailable(Car[] carros, Car carro) {
        for (int i = 0; i < carros.length; i++) {
            int pos = i;
            int vagas = 0;
            while (i < carros.length && carros[i++] == null) {
                vagas++;
                if (vagas >= carro.comp) {
                    carro.pos = pos;
                    for (int j = pos; j < pos + carro.comp; j++)
                        carros[j] = carro;
                    return true;
                }
            }
            i--;
        }
        return false;
    }

    private Car findCarById(Car[] carros, int id) {
        for (Car c : carros)
            if (c != null && c.id == id)
                return c;
        return null;
    }

    private void byeCar(Car[] carros, int id) {
        Car carro = findCarById(carros, id);
        if (carro == null)
            return;
        int start = carro.pos, end = carro.pos + carro.comp;
        for (int i = start; i < end; i++)
            carros[i] = null;
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int c = scanner.nextInt(), eventos = scanner.nextInt();
        while (c != -1 || eventos != -1) {
            Car[] carros = new Car[c];
            int ganhos = 0;
            while (eventos-- != 0) {
                String com = scanner.next();
                if (com.equals("C")) {
                    if (parkCarInParkingLotIfAnySpaceIsAvailable(carros, new Car(scanner.nextInt(), scanner.nextInt())))
                        ganhos += 10;
                } else if (com.equals("S"))
                    byeCar(carros, scanner.nextInt());
            }
            out.println(ganhos);
            c = scanner.nextInt();
            eventos = scanner.nextInt();
        }
    }
}
