import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NutritionServiceTest {

    private final NutritionService service = new NutritionService();

    @Test
    void testNormalPlanReturnsPositiveCalories() {
        PlanResult result = service.generatePlan(75, 180, 28, 3, "abnehmen", "vegan");
        assertTrue(result.calories() > 0);
    }

    @Test
    void testZunahmeIncreasesCalories() {
        PlanResult abnehmen = service.generatePlan(75, 180, 28, 3, "abnehmen", "omni");
        PlanResult zunehmen = service.generatePlan(75, 180, 28, 3, "zunehmen", "omni");
        assertTrue(zunehmen.calories() > abnehmen.calories());
    }

    @Test
    void testActivityLevelAffectsCalories() {
        PlanResult low  = service.generatePlan(75, 180, 28, 1, "halten", "omni");
        PlanResult high = service.generatePlan(75, 180, 28, 5, "halten", "omni");
        assertTrue(high.calories() > low.calories());
    }

    @Test
    void testNegativeCarbsThrowsException() {
        assertThrows(IllegalStateException.class, () ->
                service.generatePlan(200, 180, 28, 1, "abnehmen", "omni")
        );
    }
}