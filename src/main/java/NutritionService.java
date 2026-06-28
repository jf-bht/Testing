public class NutritionService {

    public PlanResult generatePlan(double weight, double height, int age, int activityLevel, String goal, String dietType) {
        // BMR berechnen
        double bmr = getBmr(weight, height, age);

        // Aktivitätsfaktor bestimmen
        double activityFactor;
        activityFactor = getActivityFactor(activityLevel);

        double tdee = bmr * activityFactor;

        // Zielfaktor anwenden
        double calories;
        calories = getCalories(goal, tdee);

        // Makros berechnen
        Result result = getResult(weight, calories);

        // Validierung
        validateMacros(result);

        return new PlanResult(calories, result.protein(), result.fat(), result.carbs());
    }

    private static void validateMacros(Result result) {
        if (result.carbs() < 0) {
            throw new IllegalStateException("Negative Kohlenhydrate berechnet — Kalorienziel zu niedrig");
        }
    }

    private static Result getResult(double weight, double calories) {
        double protein = weight * 1.5;
        double fat = weight * 1.0;
        double carbs = (calories - protein * 4 - fat * 9) / 4;
        Result result = new Result(protein, fat, carbs);
        return result;
    }

    private record Result(double protein, double fat, double carbs) {
    }

    private static double getCalories(String goal, double tdee) {
        double calories;
        if (goal.equals("abnehmen")) calories = tdee * 0.8;
        else if (goal.equals("zunehmen")) calories = tdee * 1.15;
        else calories = tdee;
        return calories;
    }

    private static double getActivityFactor(int activityLevel) {
        double activityFactor;
        if (activityLevel == 1) activityFactor = 1.2;
        else if (activityLevel == 2) activityFactor = 1.375;
        else if (activityLevel == 3) activityFactor = 1.55;
        else if (activityLevel == 4) activityFactor = 1.725;
        else activityFactor = 1.9;
        return activityFactor;
    }

    private static double getBmr(double weight, double height, int age) {
        double bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        return bmr;
    }
}
