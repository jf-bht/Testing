import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MealPlanServiceTest {

    @Test
    void testCalculateAdjustedCaloriesUsesMockedApiClient() {
        NutritionApiClient mockClient = Mockito.mock(NutritionApiClient.class);
        when(mockClient.fetchCalorieMultiplier("vegan")).thenReturn(0.9);

        MealPlanService service = new MealPlanService(mockClient);
        double result = service.calculateAdjustedCalories(2000, "vegan");

        assertEquals(1800.0, result, 0.01);
        verify(mockClient, times(1)).fetchCalorieMultiplier("vegan");
    }
}