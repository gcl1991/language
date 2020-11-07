package learn_java.string;

public class Unicode {
    public static void main(String[] args){
        System.out.println("A");
        System.out.println('A');
        char c = '\u03C0';
        String c2 = "\u03c0";
        System.out.println(c);
        System.out.println(c2);// \u000a
        System.out.println("test");
        String greeting="hello\ud835\udd46";
        System.out.println(greeting.length());
        System.out.println(greeting.codePointCount(0,greeting.length()));
        System.out.println(greeting.charAt(5));
        System.out.println(greeting.charAt(6));
        System.out.println(greeting.offsetByCodePoints(0,4));
        System.out.println(greeting.codePointAt(6));
        String c3 = "\uD835\uDD46";
        String  c4="\uD835\uDD46";
        System.out.println(c3);
        System.out.println("\uD835+\uDD46");
        System.out.println(0xD835+0xDD46);
        System.out.println(0x1D546);
        System.out.println(0xDD46);
        System.out.println(c4.charAt(1));
        System.out.println(c4.codePointAt(1));
        System.out.println("adsad"+1);
    }
}
