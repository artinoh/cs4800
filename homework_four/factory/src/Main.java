import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Customer.CustomerFactory customerFactory = new Customer.CustomerFactory();
        Customer customer1 = customerFactory.createCustomer("John", DietType.NoRestriction);
        Customer customer2 = customerFactory.createCustomer("Jane", DietType.Paleo);
        Customer customer3 = customerFactory.createCustomer("Jack", DietType.Vegan);
        Customer customer4 = customerFactory.createCustomer("Jill", DietType.NutAllergy);
        Customer customer5 = customerFactory.createCustomer("Jerry", DietType.NutAllergy);
        Customer customer6 = customerFactory.createCustomer("Jenny", DietType.NoRestriction);
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());
        System.out.println(customer4.toString());
        System.out.println(customer5.toString());
        System.out.println(customer6.toString());
    }
}