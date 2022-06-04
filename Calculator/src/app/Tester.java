package app;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class Tester {
    Evaluate eval = new Evaluate();
    @Test
   public void testadd(){//test add
        assertEquals(6,eval.evaluate("3+3"));
        assertEquals(5,eval.evaluate("2+3"));
    }
    @Test
    public void testsubtract(){//test subtract
        assertEquals(0,eval.evaluate("3-3"));
        assertEquals(-1,eval.evaluate("2-3"));
    }
    @Test
    public void testmultiply(){//test multiply
        assertEquals(9,eval.evaluate("3x3"));
        assertEquals(6,eval.evaluate("2x3"));
    }
    @Test
    public void testdivide(){//test divide
        assertEquals(1,eval.evaluate("3÷3"));
        assertEquals(0,eval.evaluate("2÷3"));
    }
    @Test
    public void testrandom(){//test with mix
        assertEquals(7,eval.evaluate("3x3-4+10÷5"));
        assertEquals(18,eval.evaluate("2÷2-1+6x3"));
    }
}
