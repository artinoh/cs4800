import java.util.ArrayList;

public abstract class DietPlan {
    protected final DietType dietType;
    private final ArrayList<FoodOption> foodOptions;

    DietPlan(DietType dietType) {
        this.dietType = dietType;
        this.foodOptions = new ArrayList<>();
    }

    public abstract boolean canEat(FoodOption foodOption);

    public void addFoodOption(FoodOption foodOption) {
        foodOptions.add(foodOption);
    }

    public ArrayList<FoodOption> getFoodOptions() {
        return foodOptions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dietType.toString());
        sb.append(" Food Options: ");
        for (FoodOption foodOption : getFoodOptions()) {
            sb.append(foodOption.toString());
            sb.append(", ");
        }
        if (!getFoodOptions().isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}

class NoRestrictionDietPlan extends DietPlan {
    public NoRestrictionDietPlan() {
        super(DietType.NoRestriction);
    }
    public boolean canEat(FoodOption foodOption) {
        return true;
    }

}

class PaleoDietPlan extends DietPlan {
    public PaleoDietPlan() {
        super(DietType.Paleo);
    }
    public boolean canEat(FoodOption foodOption) {
        if (foodOption.isDairy()) {
            return false;
        }


        if (foodOption.getMacronutrientType().equals(MacronutrientType.Carb)) {
            return foodOption.getName().equals("Pistachios");
        }

        if (foodOption.getMacronutrientType().equals(MacronutrientType.Protein)) {
            return !foodOption.getName().equals("Tofu");
        }
        return true;
    }
}

class VeganDietPlan extends DietPlan {
    public VeganDietPlan() {
        super(DietType.Vegan);
    }
    public boolean canEat(FoodOption foodOption) {
        return !foodOption.isMeat() && !foodOption.isDairy();
    }
}

class NutAllergyDietPlan extends DietPlan {
    public NutAllergyDietPlan() {
        super(DietType.NutAllergy);
    }
    public boolean canEat(FoodOption foodOption) {
        return !foodOption.isNut();
    }
}

