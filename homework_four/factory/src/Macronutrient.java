import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

abstract class MacronutrientFactory {
    abstract MacronutrientType getMacronutrientType();

    public FoodOption createFood(DietPlan dietPlan) {
        MacronutrientType macronutrientType = getMacronutrientType();
        assert macronutrientType != null;
        ArrayList<FoodOption> foodOptions = FoodOptionManager.getInstance().getFoodOptions(macronutrientType);
        Collections.shuffle(foodOptions);

        for (FoodOption foodOption : foodOptions) {
            if (dietPlan.canEat(foodOption)) {
                return foodOption;
            }
        }
        return null;
    }
}

class CarbFactory extends MacronutrientFactory {
    public MacronutrientType getMacronutrientType() {
        return MacronutrientType.Carb;
    }
}

class ProteinFactory extends MacronutrientFactory {
    public MacronutrientType getMacronutrientType() {
        return MacronutrientType.Protein;
    }
}

class FatFactory extends MacronutrientFactory {
    public MacronutrientType getMacronutrientType() {
        return MacronutrientType.Fat;
    }
}




