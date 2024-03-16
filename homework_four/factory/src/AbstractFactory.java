//make a singleton abstract factory
public class AbstractFactory {
    private static AbstractFactory instance = null;

    public static AbstractFactory getInstance() {
        if (instance == null) {
            instance = new AbstractFactory();
        }
        return instance;
    }

    public CarbFactory getCarbFactory() {
        return new CarbFactory();
    }

    public ProteinFactory getProteinFactory() {
        return new ProteinFactory();
    }

    public FatFactory getFatFactory() {
        return new FatFactory();
    }

    public Customer.CustomerFactory getCustomerFactory() {
        return new Customer.CustomerFactory();
    }

    public DietPlanFactory getDietPlanFactory() {
        return new DietPlanFactory();
    }

}

