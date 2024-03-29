import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Customer john = new Customer(
            new Order(
                new ArrayList<Food>(Arrays.asList(
                    new Burger(
                        new Toppings(
                            new ArrayList<Food>(Arrays.asList(
                                new Bacon(),
                                new Cheese(),
                                new Lettuce()
                            ))
                        )
                    ),
                    new Fries(
                        new Toppings(
                            new ArrayList<Food>(Arrays.asList(
                                new Bacon(),
                                new Cheese()
                            ))
                        )
                    )
                ))
            ),
            LoyaltyDiscount.LoyaltyStatus.Gold
        );
        Customer jane = new Customer(
            new Order(
                new ArrayList<Food>(Arrays.asList(
                    new Burger(
                        new Toppings(
                            new ArrayList<Food>(Arrays.asList(
                                new Bacon(),
                                new Lettuce(),
                                new Mayo(),
                                new Mustard(),
                                new Ketchup(),
                                new GrilledOnions()
                            ))
                        )
                    ),
                    new Fries(
                        new Toppings(
                            new ArrayList<Food>(Arrays.asList(
                                new Bacon(),
                                new Cheese()
                            ))
                        )
                    )
                ))
            ),
            LoyaltyDiscount.LoyaltyStatus.Silver
        );


        System.out.println(john.toString() + "\n");
        System.out.println(jane.toString());
    }
}