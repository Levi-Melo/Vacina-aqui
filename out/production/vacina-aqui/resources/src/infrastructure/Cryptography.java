package infrastructure;
import java.util.Base64;

public class Cryptography {
    public static String encode (String string){
        return Base64.getEncoder().encodeToString(string.getBytes());
    }
    public static String decode (String string) {
        return  new String(Base64.getDecoder().decode(string));
    }
}
