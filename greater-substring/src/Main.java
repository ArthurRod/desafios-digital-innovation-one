import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String stringOne, stringTwo, min, max;

        while ((stringOne = br.readLine()) != null) {
            stringTwo = br.readLine();

            if ( stringOne.length() > stringTwo.length() ) {
                max = stringOne;
                min = stringTwo;
            } else {
                max = stringTwo;
                min = stringOne;
            }

            int minLength = min.length();
            int maxStr = minLength;
            boolean x = true;

            while (maxStr > 0 && x) {
                int y = minLength - maxStr;
                for (int i = 0; i <= y; i++) {
                    if (max.contains(min.substring(i, i + maxStr))) {
                        x = false;
                        maxStr ++;
                        break;
                    }
                }
                maxStr --;
            }
            System.out.println(maxStr);
        }
        pw.close();
    }
}
