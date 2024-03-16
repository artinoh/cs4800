import java.awt.*;
import java.util.ArrayList;

public class FoodOptionManager {
    private static FoodOptionManager instance = null;
    private FoodOptionManager() {
        carbs = new ArrayList<>();
        proteins = new ArrayList<>();
        fats = new ArrayList<>();
    }

    public static FoodOptionManager getInstance() {
        if (instance == null) {
            instance = new FoodOptionManager();
            FoodOption.initalizeFoodOptions();
        }
        return instance;
    }

    public void addFoodOption(FoodOption foodOption) {
        MacronutrientType macronutrientType = foodOption.getMacronutrientType();
        switch (macronutrientType) {
            case Carb:
                carbs.add(foodOption);
                break;
            case Protein:
                proteins.add(foodOption);
                break;
            case Fat:
                fats.add(foodOption);
                break;
            default:
                throw new IllegalArgumentException("Unknown macronutrient type: " + macronutrientType);
        }
    }

    public ArrayList<FoodOption> getFoodOptions(MacronutrientType macronutrientType) {
        switch (macronutrientType) {
            case Carb:
                return carbs;
            case Protein:
                return proteins;
            case Fat:
                return fats;
            default:
                throw new IllegalArgumentException("Unknown macronutrient type: " + macronutrientType);
        }
    }

    ArrayList<FoodOption> carbs;
    ArrayList<FoodOption> proteins;
    ArrayList<FoodOption> fats;


}
