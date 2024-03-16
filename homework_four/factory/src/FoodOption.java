public enum FoodOption {
    Cheese("Cheese", MacronutrientType.Carb, false, true, false),
    Bread("Bread", MacronutrientType.Carb, false, false, false),
    Lentils("Lentils", MacronutrientType.Carb, false, false, false),
    Pistachios("Pistachios", MacronutrientType.Carb, false, false, true),
    Fish("Fish", MacronutrientType.Protein, true, false, false),
    Chicken("Chicken", MacronutrientType.Protein, true, false, false),
    Beef("Beef", MacronutrientType.Protein, true, false, false),
    Tofu("Tofu", MacronutrientType.Protein, false, false, false),
    Avocado("Avocado", MacronutrientType.Fat, false, false, false),
    SourCream("Sour Cream", MacronutrientType.Fat, false, true, false),
    Tuna("Tuna", MacronutrientType.Fat, true, false, false),
    Peanuts("Peanuts", MacronutrientType.Fat, false, false, true);

    private FoodOption(String name, MacronutrientType macronutrientType, boolean isMeat, boolean isDairy, boolean isNut) {
        this.name = name;
        this.isMeat = isMeat;
        this.isDairy = isDairy;
        this.isNut = isNut;
        this.macronutrientType = macronutrientType;
        FoodOptionManager.getInstance().addFoodOption(this);
    }

    public static void initalizeFoodOptions() {
        FoodOption[] foodOptions = FoodOption.values();
    }

    @Override
    public String toString() {
        return getName() + " (" + getMacronutrientType().toString() + ")";
    }

    private final String name;
    private final boolean isMeat;
    private final boolean isDairy;
    private final boolean isNut;
    private final MacronutrientType macronutrientType;

    public String getName() {
        return name;
    }

    public boolean isMeat() {
        return isMeat;
    }

    public boolean isDairy() {
        return isDairy;
    }

    public boolean isNut() {
        return isNut;
    }

    public MacronutrientType getMacronutrientType() {
        return macronutrientType;
    }
}
