
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GetHeightTest
{
    @Test
    public void getHeightTest1()
    {
        final List<Integer> rodsA = Arrays.asList(1, 2, 3, 6);

        int result = Application.getHeight(rodsA);

        assertEquals(6, result);
    }


    @Test
    public void getHeightTest2()
    {
        final List<Integer> rodsB = Arrays.asList(1, 2);

        int result = Application.getHeight(rodsB);

        assertEquals(0, result);
    }


    @Test
    public void getHeight3()
    {
        final List<Integer> rodsC = Arrays.asList(5, 7, 17);

        int result = Application.getHeight(rodsC);

        assertEquals(0, result);
    }


    @Test
    public void getHeight4()
    {
        final List<Integer> rodsD = Arrays.asList(4, 5, 3, 6);

        int result = Application.getHeight(rodsD);

        assertEquals(9, result);
    }
}
