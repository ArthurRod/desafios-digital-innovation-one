import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next;

        while((next = br.readLine()) != null) {
            boolean repeat = false;

            for(int i=0; i <= next.length() - 1; i++) {
                if(next.substring(0, i).endsWith(next.substring(i))){
                    System.out.println(next.substring(0, i));
                    repeat = true;
                }
            }
            if(!repeat)
                System.out.println(next);
        }
    }
}