public class MealPlanService {
    private final NutritionApiClient apiClient;

    public MealPlanService(NutritionApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public double calculateAdjustedCalories(double baseCalories, String dietType) {
        double multiplier = apiClient.fetchCalorieMultiplier(dietType);
        return baseCalories * multiplier;
    }
}

