import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
   // @Mock
    Ingredient notIngredient;
    @Before
    public void burger(){
        burger = new Burger();
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest(){
        int expected = 1;
        burger.addIngredient(ingredient);
        Assert.assertEquals(expected, burger.ingredients.size());
    }
    @Test
    public void removeIngredientTest(){
        int expected = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(expected, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        burger.ingredients.addAll(Arrays.asList(ingredient, notIngredient));
        List<Ingredient> expected = new ArrayList<>(Arrays.asList(notIngredient, ingredient));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(expected, burger.ingredients);
    }
    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Assert.assertEquals(700f, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("White bun");
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("sausage");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        String expected = String.format("(==== %s ====)%n", bun.getName()) + String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
