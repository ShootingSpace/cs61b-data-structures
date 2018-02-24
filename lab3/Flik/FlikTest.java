import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public  void testisSameNumber(){
        int a1 = 129;
        int a2 = 129;
        int c1 = 128;
        int c2 = 128;
        int d1 = 127;
        int d2 = 127;

        assertTrue(Flik.isSameNumber(d1,d2));
        assertTrue(Flik.isSameNumber(c1,c2));
        assertTrue(Flik.isSameNumber(a1,a2));

    }

}
