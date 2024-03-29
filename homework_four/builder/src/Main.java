
public class Main {
    public static void main(String[] args) {
        //---Pizza Hut
        System.out.println("************* Part 1 *************");
        Pizza pizzaHutThreeToppings = new Pizza.PizzaBuilder(
            "Pizza Hut Three Toppings",
            Pizza.PizzaSize.SMALL
        ).addPepperoni().addSausage().addMushrooms().build();

        pizzaHutThreeToppings.eat();

        Pizza pizzaHutSixToppings = new Pizza.PizzaBuilder(
            "Pizza Hut Six Toppings",
            Pizza.PizzaSize.MEDIUM
        ).addBacon().addOnions().addExtraCheese().addPeppers().addChicken().addBeef().build();

        pizzaHutSixToppings.eat();

        Pizza pizzaHutNineToppings = new Pizza.PizzaBuilder(
            "Pizza Hut Nine Toppings",
            Pizza.PizzaSize.LARGE
        ).addPepperoni().addSausage().addMushrooms().addBacon().addOnions().addExtraCheese().addPeppers().addChicken().addBeef().build();

        pizzaHutNineToppings.eat();

        System.out.println("\n\n************* Part 2 *************");

        //---Pizza Hut Two
        Pizza pizzaHutLargeThreeToppings = new Pizza.PizzaBuilder(
            "Pizza Hut Large Three Toppings",
            Pizza.PizzaSize.LARGE
        ).addPepperoni().addSausage().addMushrooms().build();

        pizzaHutLargeThreeToppings.eat();

        Pizza pizzaHutSmallTwoToppings = new Pizza.PizzaBuilder(
            "Pizza Hut Small Two Toppings",
            Pizza.PizzaSize.SMALL
        ).addBacon().addOnions().build();

        //---Little Ceasers

        Pizza littleCeasersMediumEightToppings = new Pizza.PizzaBuilder(
            "Little Ceasers Medium Eight Toppings",
            Pizza.PizzaSize.MEDIUM
        ).addExtraCheese().addPeppers().addChicken().addBeef().addPepperoni().addSausage().addMushrooms().addOnions().build();

        littleCeasersMediumEightToppings.eat();

        Pizza littleCeasersSmallSixToppings = new Pizza.PizzaBuilder(
            "Little Ceasers Small Six Toppings",
            Pizza.PizzaSize.SMALL
        ).addOlives().addBacon().addOnions().addExtraCheese().addPeppers().addChicken().build();

        littleCeasersSmallSixToppings.eat();

        //---Dominos

        Pizza dominosSmallOneTopping = new Pizza.PizzaBuilder(
            "Dominos Small One Topping",
            Pizza.PizzaSize.SMALL
        ).addOlives().build();

        dominosSmallOneTopping.eat();

        Pizza dominosLargeThreeToppings = new Pizza.PizzaBuilder(
            "Dominos Large Three Toppings",
            Pizza.PizzaSize.LARGE
        ).addPepperoni().addOlives().addSausage().build();

        dominosLargeThreeToppings.eat();


    }
}