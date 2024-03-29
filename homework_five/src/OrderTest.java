import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OrderTest {

    @Test
    @DisplayName("Test getCost")
    void getCost() {
        Order order = new Order();
        Assertions.assertEquals(0, order.getCost());
        Burger burger = new Burger();
        double burgerCost = burger.getCost();
        order.addItem(burger);
        Assertions.assertEquals(burgerCost, order.getCost());
    }

    @Test
    @DisplayName("Test addItem")
    void addItem() {
        Order order = new Order();
        ArrayList<Food> items = order.getItems();
        Assertions.assertEquals(0, items.size());

        Burger burger = new Burger();
        order.addItem(burger);
        Assertions.assertEquals(1, items.size());
    }
}