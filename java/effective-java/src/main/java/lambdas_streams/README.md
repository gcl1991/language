1 lambda表达式优于匿名类
（1）省略所有 lambda 表达式参数的类型，除非它们的存在使你的程序更清晰。
（2）lambda 表达式缺少名称和文档；需要不言自明且1~3行，多于此则使用方法引用
（3）lambda 表达式仅限于函数式接口。如果想创建抽象类的实例或创建具有多个抽象方法的接口实例，则使用匿名类，
（4）lambda 表达式无法获得对自身的引用。lambda表达式this关键字指的是封闭实例，匿名类中this关键字引用匿名类实例。
（5）lambda 性能高于匿名类，lambda不会创建class文件和类

2 方法引用优于lambda表达式：如果方法引用更短、更清晰，则使用它们；如果没有仍然使用lambda表达式。

3 优先使用标准函数式接口
（1） 牢记5种基本标准接口：Operator结果和参数类型相同的操作，Predicate谓词，Function转换，Supplier生产者，Consumer消费者。
（2） 5种基本标准接口的变体：
    3种基本类型的变体（int/long/double），
    9种Function变体：6种基本类型to基本类型（SrcToResultFunction），3种基本类型to对象SrcToObjFunction
    双参数版本： BiPredicate<T,U>、BiFunction<T,U,R>、BiConsumer<T,U>
              ToIntBiFunction<T,U>、ToLongBiFunction<T,U>、ToDoubleBiFunction<T,U>
              ObjDoubleConsumer<T>、ObjIntConsumer<T>、ObjLongConsumer<T>
（3）何时使用自定义函数式接口：
    它将被广泛使用，并且可以从描述性名称中获益。它有一个强有力的约定,它将受益于自定义默认方法，此时进行自定义函数式接口。并使用@FunctionalInterface注释进行标记
    如Comparator<T>之于ToIntBiFunction<T,T>
    不要提供具有多个重载的方法，这些方法在相同参数位置具有不同函数式接口，这会造成无法使用lambda自动匹配，如ExecutorService的submit方法需要类型转换以区别Callable和Runnable

4 明智地使用流:综合使用流和迭代
（1） 流（表示有限或无限的数据元素序列）和流管道（表示对这些元素的多阶段计算）,流函数对象表示重复计算，而迭代代码使用代码块表示重复计算。
（2）从代码块中，可以读取或修改作用域中的任何局部变量；在lambda表达式中，只能读取final或事实的final变量，不能修改任何局部变量。
（3）从代码块中，可以从内部方法return、break或continue，或抛出的任何受检异常；在lambda表达式中，你不能做这些事情。
（4）流适合：转换/过滤/分组/搜索（匹配）/单个操作组合元素序列（join，max，min）/将元素序列累积到一个集合中
（5）使用流很难做到的一件事是从管道的多个阶段同时访问相应的元素,可以使用反向求值以获取原始数据。

5 在流中使用无副作用的函数
（1）流代码应为函数式，便于转化并行操作，流中forEach只用于打印
（2）收集到容器：toList()、toSet()和toCollection(),toMap的3种形式及Concurrent变体
（3）收集到多组：groupingBy的3种形式及Concurrent变体,布尔分区partitioningBy
（5）收集到单值：求和、平均和汇总,minBy,maxBy,join,allMatch
（6）中间操作：过滤、映射，截断
（7）Comparator的comparing快捷方式

6 优先选择 Collection 而不是流作为返回类型
(1) Collection 接口是 Iterable 的一个子类型，它有一个流方法，因此它提供了迭代和流两种访问方式
(2) 首先返回集合，如果不可行，则返回流或iterable

7 谨慎使用并行流
不适当地并行化流的代价可能是程序失败或性能灾难。
如果你认为并行性是合理的，那么请确保你的代码在并行运行时保持正确，并在实际情况下进行仔细的性能度量。
否则不要使用并行流
