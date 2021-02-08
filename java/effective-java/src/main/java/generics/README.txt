# 不要使用原始类型
1 如果使用原始类型（如 List），就会失去类型安全性，但如果使用参数化类型（如 `List<Object>`）则不会。
2 注意Set<Object>是一个参数化类型，表示可以包含任何类型的对象的集合，Set<?>是一个通配符类型，表示只能包含某种未知类型的对象的集合，Set是一个原始类型。
  三者同属于Set类，泛型系统中保证了类型的一致性和安全性。
3 List<String>/String/List<E>/E/List<?>/List/<E extends Number>/<T extends Comparable<T>>/List<? extends Number>/static <E> List<E> asList(E[] a)/List.class

# 消除unchecked 警告
1 每次使用SuppressWarnings("unchecked")注解时,应将作用域压缩至最小，并添加一条注释，说明这样做是安全的

# List优于数组
1 数组是协变的,运行时有类型信息; 泛型是不变的,运行时没有类型信息，若Sub extend Super，则Sub[]是Super[]子类，List<Sub>和List<Super>同属于List类，二者无继承关系
  如new List<E>[]、new List<String>[]、new E[]不合法，因为其类型不安全
2 数组和泛型不能很好地混合（协变与不变的冲突），应避免混合使用数组和List<T>，优先使用List<T>，除非必要，且证明安全，否则不要使用SafeVarargs，每次使用SuppressWarnings

# 优先使用泛型
优先使用泛型系统，以保证类型的安全性和可读性，必须要混合数组与泛型时，使用以下两种方法进行数组创建，elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; @SuppressWarnings("unchecked") E result =(E) elements[--size];

# 优先使用泛型方法
使用泛型方法代替显式转换类型的方法


# 使用有界通配符增加 API 的灵活性
1 生产者使用 extends，消费者使用 super（PECS）
2 通配符类型对于类的用户应是不可见的。它们让方法接受它们应该接受的参数，拒绝应该拒绝的参数。如果类的用户必须考虑通配符类型，那么它的API可能有问题
3 不要使用有界通配符类型作为返回类型。它将强制用户在客户端代码中使用通配符类型，而不是为用户提供额外的灵活性。

# 明智地合用泛型和可变参数
1 可变参数方法和泛型不能很好地交互，用 @SafeVarargs 对其进行注释，但是必须保证安全，即满足没有在可变参数数组中存储任何东西，且不会让数组（或者其副本）出现在不可信的代码中（泄漏）。
2 用 List 参数替换可变参数
3 SafeVarargs 注释仅对不能覆盖的方法合法，因为不可能保证所有可能覆盖的方法都是安全的。静态方法/final方法/私有实例方法。

# 考虑类型安全的异构容器
