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
    public void print() {
        System.out.println("Cruise Ship: " + name + " built in " + yearBuilt + " with max passengers of " + maxPassengers);
    }
}
