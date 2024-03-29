public class LoyaltyDiscount {

    enum LoyaltyStatus {
        Bronze, Silver, Gold, Platinum
    }

    public static double applyLoyaltyDiscount(double cost, LoyaltyStatus status) {
        return switch (status) {
            case Bronze -> cost * 0.95;
            case Silver -> cost * 0.9;
            case Gold -> cost * 0.85;
            case Platinum -> cost * 0.8;
            default -> cost;
        };
    }
}
