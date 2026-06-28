public class Main {
    public static void main(String[] args) {
        NutritionService service = new NutritionService();
        PlanResult plan = service.generatePlan(75, 180, 28, 3, "abnehmen", "vegan");

        System.out.println("Berechneter Plan:");
        System.out.println("Kalorien: " + plan.calories());
        System.out.println("Protein: " + plan.protein() + "g");
        System.out.println("Fett: " + plan.fat() + "g");
        System.out.println("Carbs: " + plan.carbs() + "g");
    }
}
