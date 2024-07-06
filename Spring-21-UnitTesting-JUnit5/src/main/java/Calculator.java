public class Calculator {
    public static String operator = "add";

    public static int add(int num1, int num2){
        return num1+num2;
    }

    public static float divide(int num1, int num2){
        if (num2 <= 0 ){
            throw new IllegalArgumentException();
        }
        return (float) num1 /num2;
    }
}
