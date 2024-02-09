public class Main {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];
        ships[0] = new Ship("HMS Victory", "1765");
        ships[1] = new CruiseShip("Titanic", "1912", 2453);
        ships[2] = new CargoShip("OOCL Hong Kong", "2017", 241888);

        for (Ship ship : ships) {
            System.out.println(ship);
        }

    }
}