import java.util.ArrayList;


public interface Food {
    double getCost();
}

class Toppings implements Food {
    final ArrayList<Food> toppings;

    public Toppings() {
        this.toppings = new ArrayList<>();
    }

    public Toppings(ArrayList<Food> toppings) {
        this.toppings = toppings;
    }

    ArrayList<Food> getToppings() {
        return toppings;
    }

    public void addTopping(Food topping) {
        toppings.add(topping);
    }

    @Override
    public double getCost() {
        double totalCost = 0;
        for (Food topping : toppings) {
            totalCost += topping.getCost();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Food topping : toppings) {
            sb.append(topping.getClass().getSimpleName()).append(", ");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() -2);
        }
        return sb.toString();
    }
}

class Bacon implements Food {
    @Override
    public double getCost() {
        return 1.0;
    }
}

class Cheese implements Food {
    @Override
    public double getCost() {
        return 0.5;
    }
}

class Lettuce implements Food {
    @Override
    public double getCost() {
        return 0.25;
    }
}

class Tomato implements Food {
    @Override
    public double getCost() {
        return 0.75;
    }
}

class Pickles implements Food {
    @Override
    public double getCost() {
        return 0.5;
    }
}

class GrilledOnions implements Food {
    @Override
    public double getCost() {
        return 0.25;
    }
}

class Ketchup implements Food {
    @Override
    public double getCost() {
        return 0.1;
    }
}

class Mustard implements Food {
    @Override
    public double getCost() {
        return 0.1;
    }
}

class Mayo implements Food {
    @Override
    public double getCost() {
        return 0.1;
    }
}