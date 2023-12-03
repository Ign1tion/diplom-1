import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100f);
        float expected = 100f;
        Assert.assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "sausage", 1000000f);
        String expected = "sausage";
        Assert.assertEquals(expected, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(FILLING, "bacon", 500f);
        IngredientType expected = FILLING;
        Assert.assertEquals(expected, ingredient.getType());
    }
}

