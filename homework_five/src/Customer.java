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
        sb.append("Customer Details:\n")
                .append("Loyalty Status: ").append(status).append("\n")
                .append("Order Details:\n").append(order.toString())
                .append("\nTotal Cost after ").append(status).append(" discount: $")
                .append(String.format("%.2f", getCost()))
                .append("\n");
        return sb.toString();
    }
}
