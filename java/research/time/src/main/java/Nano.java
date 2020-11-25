import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import io.jenetics.util.NanoClock;

public class Nano {
    // 此formatter应当作为成员变量，以避免重复创建,必须使用formatter,使用LocalDateTime.toString()当纳秒最后三位为0时，纳秒字符串长度将会被缩减为6个
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss:n");
    public static void main(String[] args) {
        System.out.println(System.nanoTime()); // 只能计算纳秒差值，其数值不是真实世界的纳秒值
        System.out.println(LocalDateTime.now().getNano()); // 后6位都为0，仅精确到ms
        System.out.println(Instant.now().getNano()); // 后6位都为0，仅精确到ms
        System.out.println(getNowDateTimeNano()); // 精确到nano
    }

    public static String getNowDateTimeNano(){
        LocalDateTime date = LocalDateTime.now(NanoClock.systemDefaultZone()); // 精确nano
        return date.format(formatter);
    }
}
