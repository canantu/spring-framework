import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc1", "abc2", "abc3"})
    void testCase1(String args){
        Assertions.assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,10})
    void testCase2(int args){
        Assertions.assertEquals(0, args % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1", "abc2", "abc3"})
    @EmptySource
    void testCase3(String args){
        Assertions.assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1", "abc2", "abc3"})
    @NullSource
    void testCase4(String args){
        Assertions.assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1", "abc2", "abc3"})
    @NullAndEmptySource
    void testCase5(String args){
        Assertions.assertFalse(args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase6(String args){

    }

    static String[] stringProvider(){
        return new String[]{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({"10, 20, 30", "20, 20, 40", "30, 20, 100"})
    void testCase7(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase8(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }





}
