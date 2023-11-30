import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;
    public IngredientTest(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] makeIngredients(){
        return new Object[][]{
                {FILLING, "cutlet", 100f},
                {SAUCE, "sour cream", 200000000000000000000f },
                {FILLING, "!@#$%^&*(", -1f },
                {FILLING, "", 0f},
                {FILLING, "     ", Float.MAX_VALUE},
               {FILLING, "soooooooooooooooooooooooManySymbols", 1f}
    };
}
@Test
    public void getPriceTest(){
        ingredient = new Ingredient(type, name, price);
    Assert.assertEquals(price, ingredient.getPrice(), 0);
}
@Test
    public void getNameTest(){
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
}
@Test
    public void getTypeTest(){
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
}
}

