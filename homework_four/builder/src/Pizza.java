import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



public class Pizza {

    public enum PizzaSize {
        SMALL, MEDIUM, LARGE
    }

    private final String name;
    private final PizzaSize size;
    private ArrayList<String> pizzaToppings;

    public Pizza(String name, PizzaSize size, ArrayList<String> pizzaToppings) {
        this.name = name;
        this.size = size;
        this.pizzaToppings = pizzaToppings;
    }

    public String getName() {
        return name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public ArrayList<String> getToppings() {
        return pizzaToppings;
    }

    public void clearToppings() {
        pizzaToppings.clear();
    }

    public void addTopping(String topping) {
        pizzaToppings.add(topping);
    }

    public void removeTopping(String topping) {
        pizzaToppings.remove(topping);
    }

    public boolean hasTopping(String topping) {
        return pizzaToppings.contains(topping);
    }

    private String getSizeString() {
        return switch (size) {
            case SMALL -> "Small";
            case MEDIUM -> "Medium";
            case LARGE -> "Large";
            default -> "Unknown";
        };
    }

    public String toString() {
        return "Name: " + name + ", Size: " + getSizeString() + ", Toppings: " + String.join(", ", pizzaToppings);
    }

    public void eat() {
        System.out.println(toString());
    }

    public static class PizzaBuilder {
        private final String name;
        private final PizzaSize size;
        private ArrayList<String> pizzaToppings;

        public PizzaBuilder addPepperoni() {
            pizzaToppings.add("Pepperoni");
            return this;
        }

        public PizzaBuilder addSausage() {
            pizzaToppings.add("Sausage");
            return this;
        }

        public PizzaBuilder addMushrooms() {
            pizzaToppings.add("Mushrooms");
            return this;
        }

        public PizzaBuilder addBacon() {
            pizzaToppings.add("Bacon");
            return this;
        }

        public PizzaBuilder addOnions() {
            pizzaToppings.add("Onions");
            return this;
        }

        public PizzaBuilder addExtraCheese() {
            pizzaToppings.add("Extra Cheese");
            return this;
        }

        public PizzaBuilder addPeppers() {
            pizzaToppings.add("Peppers");
            return this;
        }

        public PizzaBuilder addChicken() {
            pizzaToppings.add("Chicken");
            return this;
        }

        public PizzaBuilder addOlives() {
            pizzaToppings.add("Olives");
            return this;
        }

        public PizzaBuilder addSpinach() {
            pizzaToppings.add("Spinach");
            return this;
        }

        public PizzaBuilder addTomatoAndBasil() {
            pizzaToppings.add("Tomato and Basil");
            return this;
        }

        public PizzaBuilder addBeef() {
            pizzaToppings.add("Beef");
            return this;
        }

        public PizzaBuilder addHam() {
            pizzaToppings.add("Ham");
            return this;
        }

        public PizzaBuilder addPesto() {
            pizzaToppings.add("Pesto");
            return this;
        }

        public PizzaBuilder addSpicyPork() {
            pizzaToppings.add("Spicy Pork");
            return this;
        }

        public PizzaBuilder addHamAndPineapple() {
            pizzaToppings.add("Ham and Pineapple");
            return this;
        }

        public PizzaBuilder(String name, PizzaSize size) {
            this.name = name;
            this.size = size;
            this.pizzaToppings = new ArrayList<>();
        }

        public Pizza build() {
            return new Pizza(name, size, pizzaToppings);
        }
    }

}
