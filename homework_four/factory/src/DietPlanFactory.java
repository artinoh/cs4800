public class DietPlanFactory {

    public DietPlan createDietPlan(DietType dietType) {
        DietPlan dietPlan;
        switch (dietType) {
            case NoRestriction:
                dietPlan = new NoRestrictionDietPlan();
                break;
            case Paleo:
                dietPlan = new PaleoDietPlan();
                break;
            case Vegan:
                dietPlan = new VeganDietPlan();
                break;
            case NutAllergy:
                dietPlan = new NutAllergyDietPlan();
                break;
            default:
                throw new IllegalArgumentException("Unknown diet type: " + dietType);
        }

        MacronutrientFactory carbFactory = AbstractFactory.getInstance().getCarbFactory();
        FoodOption carb = carbFactory.createFood(dietPlan);
        if (carb != null) {
            dietPlan.addFoodOption(carb);
        }
        else {
            System.out.println("No carb found for " + dietType.toString());
        }

        MacronutrientFactory proteinFactory = AbstractFactory.getInstance().getProteinFactory();
        FoodOption protein = proteinFactory.createFood(dietPlan);
        if (protein != null) {
            dietPlan.addFoodOption(protein);
        }
        else {
            System.out.println("No protein found for " + dietType.toString());
        }

        MacronutrientFactory fatFactory = AbstractFactory.getInstance().getFatFactory();
        FoodOption fat = fatFactory.createFood(dietPlan);
        if (fat != null) {
            dietPlan.addFoodOption(fat);
        }
        else {
            System.out.println("No fat found for " + dietType.toString());
        }



        return dietPlan;
    }


}
