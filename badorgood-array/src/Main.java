import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rowsRead = Integer.valueOf(br.readLine());

        while (rowsRead != 0) {
            List<String> initial = new ArrayList<>();
            List<String> bad = new ArrayList<>();

            for (int i = 0; i < rowsRead; i++)
                initial.add(br.readLine());

            for (int i = 0; i < initial.size() - 1; i++) {
                for (int j = i + 1; j < initial.size(); j++) {
                    if (initial.get(i).startsWith(initial.get(j).substring(0, 2))) {
                        bad = initial;
                    }
                }
            }
            if (bad.size() > 0) {
                System.out.println("Conjunto Ruim! " + bad);
            } else {
                System.out.println("Conjunto Bom! " + initial);
            }
            rowsRead = Integer.valueOf(br.readLine());
        }
    }
}

