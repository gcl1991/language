import java.util.Arrays;

// 盗用者
public class ElvisStealer {
    static Elvis impersonator; //模仿者
    private static final long serialVersionUID = 0;
    private Elvis payload; // 有效载荷


    private Object readResolve() {
        impersonator = payload;    // Save a reference to the "unresolved" Elvis instance保存对“未解决的” Elvis实例的引用
        return new String[]{"A Fool Such as I"};
    } //Return object of correct type for favoriteSongs field返回“喜欢的歌曲”字段的正确类型的对象
}