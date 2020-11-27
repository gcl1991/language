package exception;

public class th75 {
    // 在细节消息中包含失败一捕获信息
    // 1 包含由价值的字段和参数，不可包含敏感信息，同时应精简，内容大于可读性。
    // 2 异常的细节消息与用户层次的错误消息不同,前者面向程序员，且一般不会本地化，后者对于最终用户而言必须时可理解的。

    public static class IndexOutOfBoundsException extends RuntimeException {
        int lowerBound;
        int upperBound;
        int index;
        /**
         * Constructs an IndexOutOfBoundsException.
         *
         * @param lowerBound the lowest legal index value
         * @param upperBound the highest legal index value plus one
         * @param index      the actual index value
         */
        public IndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
            // Generate a detail message that captures the failure
            super(String.format("Lower bound: %d, Upper bound: %d, Index: %d",lowerBound, upperBound, index));
            // Save failure information for programmatic access
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.index = index;
        }
    }
}
