import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public final static int MAX = 32;
    public static final int MIN = 6;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;

        while ((password = br.readLine()) != null) {
            boolean correctSize = password.length() >= MIN && password.length() <= MAX;
            boolean pontuation = !password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$");
            boolean number = false;
            boolean upperCase = false;
            boolean lowerCase = false;

            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    number = true;
                } else if (Character.isUpperCase(password.charAt(i))) {
                    upperCase = true;
                } else if (Character.isLowerCase(password.charAt(i))) {
                    lowerCase = true;
                }
            }

            if (correctSize && !pontuation && number && upperCase && lowerCase) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
}
