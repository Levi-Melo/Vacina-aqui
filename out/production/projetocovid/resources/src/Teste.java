import domains.Password;

import java.io.IOException;


public class Teste {
    public static void main(String[] args) throws IOException {
    Password p = new Password();
    System.out.println(p.createPassword());
    }
}