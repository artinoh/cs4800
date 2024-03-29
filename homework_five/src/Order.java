import java.util.ArrayList;

public class Order {
    private ArrayList<Food> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(ArrayList<Food> items) {
        this.items = items;
    }

    public ArrayList<Food> getItems() {
        return items;
    }

    public double getCost() {
        double totalCost = 0;
        for (Food item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public void addItem(Food item) {
        items.add(item);
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (Food item : items) {
            sb.append(item.toString())
                    .append(" : Cost: $")
                    .append(item.getCost())
                    .append("\n");
        }
        sb.append("\n")
            .append("TotalCost: $")
            .append(getCost());
        return sb.toString();
    }

}
