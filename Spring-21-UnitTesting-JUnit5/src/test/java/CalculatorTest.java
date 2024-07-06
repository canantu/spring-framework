import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpClass(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void tearDownClass(){
        System.out.println("AfterAll");
    }
    @BeforeEach
    void setUpTest(){
        System.out.println("Run before each test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Run after each test");
    }

    @Test
    void add(){
        int actual = Calculator.add(2,3);
        int expected= 5;
        assertEquals(expected, actual, "It is not matching with expected value.");
    }

    @Test
    void testCase1(){
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase2(){
        boolean result1 = Calculator.add(2,2) == 4;
        assertTrue(result1);

        boolean result2 = Calculator.add(2,2) == 5;
        assertFalse(result2);
    }

    @Test
    void testCase3(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase4(){

        String nullString = null;
        String notNullString = "Cydeo";
        assertNull(nullString);
        assertNotNull(notNullString);


    }

    @Test
    void testCase5(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }
    @Test
    void testCase6(){
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(10, -2));
    }
    @Test
    void testCase7(){
        System.out.println("TestCase-7 Start");
        assertThrows(AccessDeniedException.class, () -> Calculator.divide(10, -5));
        System.out.println("TestCase-7 End");

    }
    @Test
    void testCase8(){
        System.out.println("TestCase-8 Start");

    }

}