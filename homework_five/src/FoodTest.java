import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {

    @Test
    void testAddTopping() {
        Toppings toppings = new Toppings();
        assertEquals(0, toppings.toppings.size());
        Food lettuce = new Lettuce();
        toppings.addTopping(lettuce);
        assertEquals(1, toppings.toppings.size());
    }

    @Test
    void testGetCost() {
        Toppings toppings = new Toppings();
        assertEquals(0, toppings.getCost());
        Food lettuce = new Lettuce();
        toppings.addTopping(lettuce);
        assertEquals(lettuce.getCost(), toppings.getCost());

        Food cheese = new Cheese();
        toppings.addTopping(cheese);
        assertEquals(lettuce.getCost() + cheese.getCost(), toppings.getCost());
    }

    @Test
    void testGetToppings() {
        Toppings toppings = new Toppings();
        assertEquals(0, toppings.toppings.size());
        Food lettuce = new Lettuce();
        toppings.addTopping(lettuce);
        assertEquals(1, toppings.toppings.size());
        assertEquals(Lettuce.class, toppings.toppings.getFirst().getClass());
    }
}