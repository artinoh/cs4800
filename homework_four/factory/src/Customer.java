public class Customer {

    static class CustomerFactory {
        Customer createCustomer(String name, DietType dietType) {
            Customer customer = new Customer(name, dietType);
            DietPlanFactory dietPlanFactory = AbstractFactory.getInstance().getDietPlanFactory();
            customer.addDietPlan(dietPlanFactory.createDietPlan(dietType));
            return customer;
        }
    }

    private final String name;
    private DietPlan dietPlan;
    private final DietType dietType;

    public Customer(String name, DietType dietType) {
        this.name = name;
        this.dietType = dietType;
        this.dietPlan = null;
    }

    public void addDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    @Override
    public String toString() {
        return name + "'s Diet Plan: " + dietPlan.toString();
    }
}
