import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class Tests {

    @Test
    void testStandard() {
        int total = Integer.decode("453626327");
        assertEquals(453626327, total);
    }

    @Test
    void testEmpty() {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            int i = Integer.decode("");
        });
    }
    @Test
    void testPlus(){
        int total=Integer.decode("+2564546");
        assertEquals(2564546,total);
    }
    @Test
    void testMinus(){
        int total=Integer.decode("-231482346");
        assertEquals(-231482346,total);
    }
    @Test
    void testRadixSpecifier1(){
        int total=Integer.decode("0x10a6b7");
        assertEquals(0x10a6b7,total);
    }
    @Test
    void testRadixSpecifier2(){
        int total=Integer.decode("0X11A7BF7");
        assertEquals(0X11A7BF7,total);
    }
    @Test
    void testRadixSpecifier3(){
        int total=Integer.decode("#108BE7");
        assertEquals(0X108BE7,total);
    }
    @Test
    void testRadixSpecifier4(){
        int total=Integer.decode("0107");
        assertEquals(0107,total);
    }
    @Test
    void testDoubleSign(){
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("--123");
        });
        Throwable thrown1 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("-+123");
        });
        Throwable thrown2 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("+-123");
        });
        Throwable thrown3 = assertThrows(NumberFormatException.class, () -> {
            int i=Integer.decode("++123");
        });
    }
    @Test
    void testMinValue(){
        int total=Integer.decode(""+Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE,total);
    }
}
