# 不要使用原始类型
1 如果使用原始类型（如 List），就会失去类型安全性，但如果使用参数化类型（如 `List<Object>`）则不会。
2 注意Set<Object>是一个参数化类型，表示可以包含任何类型的对象的集合，Set<?>是一个通配符类型，表示只能包含某种未知类型的对象的集合，Set是一个原始类型。
  三者同属于Set类，泛型系统中保证了类型的一致性和安全性。
3 List<String>/String/List<E>/E/List<?>/List/<E extends Number>/<T extends Comparable<T>>/List<? extends Number>/static <E> List<E> asList(E[] a)/List.class

# 消除unchecked 警告
1 每次使用SuppressWarnings("unchecked")注解时,应将作用域压缩至最小，并添加一条注释，说明这样做是安全的

# list优于数组
1 数组是协变的，泛型是不变的，若Sub extend Super，则Sub[]是Super[]子类，List<Sub>和List<Super>同属于List类，二者无继承关系
2 数组运行时有类型信息，而泛型则没有
3 数组和泛型不能很好地混合（协变与不变的冲突），如new List<E>[]、new List<String>[]、new E[]不合法，因为其类型不安全
