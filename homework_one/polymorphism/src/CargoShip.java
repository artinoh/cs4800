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
    public String toString() {
        return String.format("Cargo Ship: %s Year Built: %s Max Cargo: %d TEU", getName(), getYearBuilt(), getMaxCargo());
    }
}
