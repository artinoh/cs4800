import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyDiscountTest {

    @Test
    @DisplayName("Test applyLoyaltyDiscount")
    void applyLoyaltyDiscount() {
        double cost = 10.0;
        LoyaltyDiscount.LoyaltyStatus bronze = LoyaltyDiscount.LoyaltyStatus.Bronze;

        assertEquals(9.5, LoyaltyDiscount.applyLoyaltyDiscount(cost, bronze));

        LoyaltyDiscount.LoyaltyStatus silver = LoyaltyDiscount.LoyaltyStatus.Silver;
        assertEquals(9.0, LoyaltyDiscount.applyLoyaltyDiscount(cost, silver));

        LoyaltyDiscount.LoyaltyStatus gold = LoyaltyDiscount.LoyaltyStatus.Gold;
        assertEquals(8.5, LoyaltyDiscount.applyLoyaltyDiscount(cost, gold));

        LoyaltyDiscount.LoyaltyStatus platinum = LoyaltyDiscount.LoyaltyStatus.Platinum;
        assertEquals(8.0, LoyaltyDiscount.applyLoyaltyDiscount(cost, platinum));

    }
}