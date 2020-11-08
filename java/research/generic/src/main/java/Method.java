import java.time.LocalDate;
import java.util.Arrays;

public class Method {
    static class A<T>{
        protected T first;
        A(T f){
          first = f;
        }
        public void setFirst(T x){
            first = x;
        }

        public T getFirst() {
            return first;
        }
    }

    static class B extends A<LocalDate>{

        B(LocalDate f) {
            super(f);
        }

        @Override
        public void setFirst(LocalDate x){
            first = x;
        }

        @Override
        public LocalDate getFirst() {
            return super.getFirst();
        }
    }
}
