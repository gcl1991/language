package lambdasinaction.chap13;
import org.junit.Test;


public class RecursionTest {
   int n = 10000000;
   @Test
   public void factorialIterative(){
       Recursion.factorialIterative(n);
   }

   @Test
   public void factorialRecursive(){
       Recursion.factorialRecursive(n);
   }

   @Test
   public void factorialStreams(){
       Recursion.factorialStreams(n);
   }

   @Test
   public void factorialTailRecursive(){
       Recursion.factorialTailRecursive(n);
   }
}
