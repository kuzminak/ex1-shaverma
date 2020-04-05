
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TakeMyMoneyTest {
    final List<Integer> pricesA = Arrays.asList(350, 250, 100, 1600, 500, 150, 150);

    final List<Integer> pricesB = Arrays.asList(350);

    final List<Integer> pricesC = Arrays.asList(350, 250, 100, 1600, 500, 150, 150, 300, 400, 450, 550, 600, 650, 700, 750);

    @Test
    public void takeMyMoneyTest_N2_PA() {
        int N = 2;
        int budget = 1672;
        int result = Application.takeMyMoney(pricesA, N, budget);

        assertEquals(850, result);
    }

    @Test
    public void takeMyMoneyTest_N2_PB() {
        int N = 2;
        int budget = 1672;
        int result = Application.takeMyMoney(pricesB, N, budget);

        assertEquals(0, result);
    }

    //Если на M рублей невозможно купить N шаверм, то функция должна вернуть 0
    @Test
    public void takeMyMoneyTest_N10_PA() {
        int N = 10;
        int budget = 10;
        int result = Application.takeMyMoney(pricesB, N, budget);

        assertEquals(0, result);
    }

    @Test
    public void takeMyMoneyTest_N10_PC() {
        int N = 4;
        int budget = 3000;
        int result = Application.takeMyMoney(pricesC, N, budget);

        assertEquals(3000, result);
    }
}

