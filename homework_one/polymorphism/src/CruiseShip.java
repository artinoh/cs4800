public class CruiseShip extends Ship {
    int maxPassengers;

    CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return String.format("Cruise Ship: %s Year Built: %s Max Passengers: %d", getName(), getYearBuilt(), getMaxPassengers());
    }
}
