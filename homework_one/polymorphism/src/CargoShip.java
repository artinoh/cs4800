public class CargoShip extends Ship {
    int maxCargo;

    CargoShip(String name, String yearBuilt, int maxCargo) {
        super(name, yearBuilt);
        this.maxCargo = maxCargo;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;
    }

    @Override
    public void print() {
        System.out.println("Cargo Ship: " + name + " built in " + yearBuilt + " with max cargo of " + maxCargo);
    }
}
