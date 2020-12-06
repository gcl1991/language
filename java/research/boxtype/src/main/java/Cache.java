public class Cache {
    public static void main(String[] args) {
        // -128-127将被缓存
        Byte aB = 127;
        Byte bB = 127;
        Short aS = 127;
        Short bS = 127;
        Short cS = 128;
        Short dS = 128;
        Integer aI = 127;
        Integer bI = 127;
        Integer cI = 128;
        Integer dI = 128;
        Long aL = 127L;
        Long bL = 127L;
        Long cL = 128L;
        Long dL = 128L;
        // 0-127被缓存
        Character aC = 127;
        Character bC = 127;
        Character cC = 128;
        Character dC = 128;
        // 相等
        System.out.println(aI == bI);
        System.out.println(aS == bS);
        System.out.println(aB == bB);
        System.out.println(aL == bL);
        System.out.println(aC == bC);
        System.out.println("===========");
        // 不相符
        System.out.println(cI == dI);
        System.out.println(cS == dS);
        System.out.println(cL == dL);
        System.out.println(cC == dC);
    }
}
