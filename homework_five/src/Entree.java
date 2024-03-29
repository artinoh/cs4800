abstract class Entree implements Food {
    protected Toppings toppings;

    public Entree() {
        this.toppings = new Toppings();
    }

    public Entree(Toppings toppings) {
        this.toppings = toppings;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public void addTopping(Food topping) {
        toppings.addTopping(topping);
    }

    public double getCost() {
        return toppings.getCost() + getBaseCost();
    }

    public abstract double getBaseCost();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with " + toppings.toString();
    }
}

class Burger extends Entree {
    public Burger() {
        super();
    }

    public Burger(Toppings toppings) {
        super(toppings);
    }

    @Override
    public double getBaseCost() {
        return 5.0;
    }
}

class Fries extends Entree {
    public Fries() {
        super();
    }

    public Fries(Toppings toppings) {
        super(toppings);
    }

    @Override
    public double getBaseCost() {
        return 2.0;
    }
}

class HotDog extends Entree {
    public HotDog() {
        super();
    }

    public HotDog(Toppings toppings) {
        super(toppings);
    }

    @Override
    public double getBaseCost() {
        return 3.0;
    }
}
