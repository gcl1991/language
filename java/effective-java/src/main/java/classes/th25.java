package classes;

// 源文件仅限有单个顶层类
// 1 一个源文件只能有一个顶层类，以防止同一个包内存在重名类
// 2 将多个顶层类放到一个源文件中,请考虑使用静态成员类
public class th25 {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}
