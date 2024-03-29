public class Customer {
    private Order order;
    private LoyaltyDiscount.LoyaltyStatus status;

    public Customer(Order order, LoyaltyDiscount.LoyaltyStatus status) {
        this.order = order;
        this.status = status;
    }

    public double getCost() {
        return LoyaltyDiscount.applyLoyaltyDiscount(order.getCost(), status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer with ").append(status).append(" status\n");
        sb.append(order.toString());
        return sb.toString();
    }
}
