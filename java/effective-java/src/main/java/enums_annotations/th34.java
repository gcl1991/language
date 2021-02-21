package enums_annotations;

public class th34 {
    // switch的枚举
    // Enum type that switches on its own value - questionable
    // 枚举类型可自行切换值-可疑
    public enum OperationBySwitch {
        PLUS, MINUS, TIMES, DIVIDE;
        // Do the arithmetic operation represented by this constant
        // 进行此常数表示的算术运算
        public double apply(double x, double y) {
            switch(this) {
                case PLUS: return x + y;
                case MINUS: return x - y;
                case TIMES: return x * y;
                case DIVIDE: return x / y;
            }
            throw new AssertionError("Unknown op: "+ this);
        }
    }


    // 特定常量方法（抽象方法+实现）更好。
    // Enum type with constant-specific method implementations
    public enum OperationBySpecific {
        PLUS {
            @Override
            public double apply(double x, double y){return x + y;}},
        MINUS {
            @Override
            public double apply(double x, double y){return x - y;}},
        TIMES {
            @Override
            public double apply(double x, double y){return x * y;}},
        DIVIDE{
            @Override
            public double apply(double x, double y){return x / y;}};
        public abstract double apply(double x, double y);
    }


    // 如果枚举常量有一些（但不是全部）共享公共行为，请考虑策略枚举模式。
    // The strategy enum pattern
    enum PayrollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

        private final PayType payType;
        PayrollDay(PayType payType) { this.payType = payType; }
        PayrollDay() { this(PayType.WEEKDAY); } // Default

        int pay(int minutesWorked, int payRate) {
            return payType.pay(minutesWorked, payRate);
        }

        // The strategy enum type
        private enum PayType {
            WEEKDAY {
                @Override
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked <= MINS_PER_SHIFT ? 0 :(minsWorked - MINS_PER_SHIFT) * payRate / 2;
                }
            },
            WEEKEND {
                @Override
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked * payRate / 2;
                }
            };

            abstract int overtimePay(int mins, int payRate);

            private static final int MINS_PER_SHIFT = 8 * 60;

            int pay(int minsWorked, int payRate) {
                int basePay = minsWorked * payRate;
                return basePay + overtimePay(minsWorked, payRate);
            }
        }
    }
}
