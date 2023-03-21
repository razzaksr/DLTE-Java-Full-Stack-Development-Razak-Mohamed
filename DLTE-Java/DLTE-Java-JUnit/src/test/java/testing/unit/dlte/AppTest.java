package testing.unit.dlte;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private Moderator moderator=new Moderator();

    @Test
    public void testFind(){
        assertEquals(12900,moderator.findBondValue("FD"));
    }

    @Test
    public void testFinding(){
        assertNull(moderator.findBondValue("QUICK"));
    }
}
