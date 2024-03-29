import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testGetCost() {
        Order order = new Order();
        Assertions.assertEquals(0, order.getCost());
        Burger burger = new Burger();
        double burgerCost = burger.getCost();
        order.addItem(burger);
        Assertions.assertEquals(burgerCost, order.getCost());
        Customer customer = new Customer(order, LoyaltyDiscount.LoyaltyStatus.Gold);
        Assertions.assertEquals(customer.getCost(), LoyaltyDiscount.applyLoyaltyDiscount(order.getCost(), LoyaltyDiscount.LoyaltyStatus.Gold));
    }
}