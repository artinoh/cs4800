import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EntreeTest {
    @Test
    @DisplayName("Test getToppings")
    void testGetToppings() {
        Burger burger = new Burger();
        assertEquals(0, burger.getToppings().toppings.size());

        burger.addTopping(new Lettuce());

        assertEquals(1, burger.getToppings().toppings.size());
        assertEquals(Lettuce.class, burger.getToppings().toppings.getFirst().getClass());
    }
    @Test
    void testAddTopping() {
        Burger burger = new Burger();
        assertEquals(0, burger.getToppings().toppings.size());

        burger.addTopping(new Lettuce());

        assertEquals(1, burger.getToppings().toppings.size());
        assertEquals(Lettuce.class, burger.getToppings().toppings.getFirst().getClass());
    }

    @Test
    void testGetCost() {
        Burger burger = new Burger();
        assertEquals(burger.getBaseCost(), burger.getCost());

        Lettuce lettuce = new Lettuce();
        double lettuceCost = lettuce.getCost();
        burger.addTopping(lettuce);
        assertEquals(burger.getBaseCost() + lettuceCost, burger.getCost());

        Cheese cheese = new Cheese();
        double cheeseCost = cheese.getCost();
        burger.addTopping(cheese);
        assertEquals(burger.getBaseCost() + lettuceCost + cheeseCost, burger.getCost());
    }

    @Test
    void testGetBaseCost() {
        Burger burger = new Burger();
        assertEquals(5.0, burger.getBaseCost());
    }
}