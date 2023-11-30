import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    Bun bun;
    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
        public static Object[][] makeBuns(){
        return new Object[][]{
                {"!@#$%^&*(", 1.5f},
                {"", -1.7f},
                {"well-done-bun", 1111111111.5555f},
                {"soooooooooooooooooooooooooManySymbols", Float.MAX_VALUE},
                {"         ", 0f},
                {"1111111", 1f}
        };
    }
    @Test
public void getBunNameTest(){
        bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getBunPriceTest(){
        bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
