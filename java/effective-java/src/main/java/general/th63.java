package general;

// 当心字符串连接引起的性能问题
// 不要使用字符串连接操作符合并多个字符串
public class th63 {
    private static final int LINE_WIDTH = 1;
    // Inappropriate use of string concatenation - Performs poorly!
    // 字符串连接使用不当-性能不佳！
    public String statementSlow() {
        String result = "";
        for (int i = 0; i < numItems(); i++) {
            // String concatenation
            result += lineForItem(i);
        }
        return result;
    }

    public String statementFast() {
        StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
        for (int i = 0; i < numItems(); i++) {
            b.append(lineForItem(i));
        }
        return b.toString();
    }

    public int numItems(){
        return 1000;
    }
    public String lineForItem(int i){
        return String.valueOf(i);
    }
}
