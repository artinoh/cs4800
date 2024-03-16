public enum MacronutrientType {
    Carb("Carbohydrate"),
    Protein("Protein"),
    Fat("Fat");

    private final String name;
    private MacronutrientType(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }
}