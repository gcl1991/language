package learn_java.variable;

public class VariableDemo02 {
    public static void main(String[] args) {
        int x = 10;
        {
            int y = 20;
            System.out.println(x);
            // y作用域在此括号内
        }
    }
}
