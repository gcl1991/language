package exception;

import java.util.ListIterator;
import java.util.NoSuchElementException;

// 抛出与抽象对应的异常/如何处理异常
public class th73 {
    // 0 首先通过参数检查避免不可控异常——>不可避免则捕获并记录异常——>不可捕获异常转译/异常链

    // 1 异常转译:高层的实现应该捕获低层的异常，同时抛出可以按照高层抽象进行解释的异常，以尽量符合开闭原则。

    /**
     * 例子1 可控异常
     *
     * @throws HigherLevelException if ***
     */
    void m1(boolean x) throws HigherLevelException {
        try {
            if (x) {
                throw new LowerLevelException();
            }
        } catch (LowerLevelException e) {
            throw new HigherLevelException();
        }
    }

    /**
     * 例子2 不可控异常
     * Returns the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()}).
     */
    public static <E> E m2(int index) {
        ListIterator<E> i = listIterator(index);
        try {
            return (i.next());
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    static <E> ListIterator<E> listIterator(int x) {
        return null;
    }

    static class LowerLevelException extends Exception {
    }

    static class HigherLevelException extends Exception {
        HigherLevelException(){
            super();
        }
        HigherLevelException( Throwable cause ) {
            super(cause);
        }
    }

    // 2 异常链(受抑制异常同理)，如果低层的异常对于调试导致高层异常的问题非常有帮助，使用异常链就很合适。
    static void m3(boolean flag) throws HigherLevelException {
        try {
            if(flag)
                throw new LowerLevelException();
        } catch (LowerLevelException cause) {
            throw new HigherLevelException(cause);
        }
    }

}
