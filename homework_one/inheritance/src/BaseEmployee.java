public class BaseEmployee extends Employee {
    double baseSalary;
    BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    @Override
    public String toString() {
        return String.format("Base Employee: %s Base Salary: %.2f", super.toString(), getBaseSalary());
    }
}
