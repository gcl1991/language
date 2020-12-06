public class Equals {
    public static void main(String[] args) {
        Byte aB=10;
        Short aS=10;
        Integer aI=10;
        Long aL=10L;
        Character aC=10;
        // == 不能应用于Byte/Short/Integer/Long/Character之间
        // 而equals仅进行同类对象比较，不处理数据转型关系，以下皆为false
        System.out.println(aB.equals(aS));
        System.out.println(aS.equals(aI));
        System.out.println(aI.equals(aL));
        System.out.println(aL.equals(aC));
    }
}
