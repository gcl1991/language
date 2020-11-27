package exception;

import java.util.EmptyStackException;

public class th76 {
    public static class FailureAtomic {
        // 方法1 使用不可变对象
        private Integer[] elements = new Integer[10];

        // 方法2 执行操作前检查参数的有效性/调整计算顺序,使得可能会失败的计算部分在对象状态被修改之前发生
        public void method2(int index,Object x) {
            // 修改对象前检查参数有效性
            if (index < 0 || index >= elements.length)
                throw new EmptyStackException();
            // 可能会导致失败的计算部分放置于对象状态修改之前
            Integer ix = (Integer) x;
            elements[index] = ix;
        }
        // 方法3 建立临时拷贝
        // 方法4 做法是编写一段恢复代码，拦截操作过程中发生的失败，以便对象回滚到操作开始之前的状态上
    }
}
