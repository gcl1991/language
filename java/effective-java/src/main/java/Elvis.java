import java.util.Arrays;
import java.util.EnumSet;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    private Elvis() {
    }

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
