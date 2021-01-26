package classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 使类和成员的可访问性最小化:适用封装隔离API（抽象公共/受保护）和实现（私有/包私有）
public class th15 {
    // 1 API的分割线为包级私有,类或接口应尽可能为包级私有，若包级私有类或接口只被一个类使用，那么可以考虑这个类作为私有静态嵌套类。
    // 2 成员应设计为私有，只有当同一个包中其他类真的需要访问成员时，需要删除私有修饰符变为包私有。如果发现经常这样做，你应该检查类是否需要重新设计
    // 3 除静态变量之外（必须不可变,使用不可变视图或Clone以避免可变对象和数组造成的对象间接逸出），实例字段和静态字段不应是共有或受保护的，
    // 4 用于测试目的，私有成员指定为包级私有是可以接受的，更高则不行。


    // 数组漏洞:可能的安全漏洞
    public static final int[] VALUES1 = {1,2,3};
    // 修复数组漏洞，方式1
    private static final Integer[] PRIVATE_VALUES2 = {1,2,3};
    public static final List<Integer> VALUES2 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES2));
    // 修复数组漏洞，方式2
    private static final Integer[] PRIVATE_VALUES3 = {1,2,3};
    public static final Integer[] values() {return PRIVATE_VALUES3.clone();}
}