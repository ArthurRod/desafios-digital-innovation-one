import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> alfabeto = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
        Scanner sc = new Scanner(System.in, "ISO-8859-1");

        while (true) {
            String frase = sc.nextLine()
                    .trim()
                    .toLowerCase()
                    .replaceAll("\n", " ")
                    .replaceAll("\t", " ");
            if (frase.equals(".")) break;
            if (frase.length() <= 0) continue;

            List<String> vetorPalavras = new ArrayList(Arrays.asList(frase.split(" ")));
            Map<String, String> dicionario = new HashMap<String, String>();

            alfabeto.stream().forEach(letra -> {
                dicionario.put(letra, "");
            });

            Map<String, Map<String, Integer>> palavraRepetida = new HashMap<String, Map<String, Integer>>();

            alfabeto.stream().forEach(letra -> {
                palavraRepetida.put(letra, new HashMap<String, Integer>());
            });

            vetorPalavras.stream().forEach(palavra -> {
                palavraRepetida.get(palavra.substring(0, 1)).put(palavra, 0);
            });

            vetorPalavras.stream().forEach(palavra -> {
                int qt = palavraRepetida.get(palavra.substring(0, 1)).get(palavra);
                qt++;
                palavraRepetida.get(palavra.substring(0, 1)).put(palavra, qt);
            });


            alfabeto.stream().forEach(letra -> {
                Map<String, Integer> map = palavraRepetida.get(letra);
                List<String> keys = new ArrayList<String>(map.keySet());

                int charPorLetra = 0;

                for (String chave : keys) {
                    charPorLetra += map.get(chave) * chave.length();
                }
                int charsMelhorCenario;
                int charsMelhorCenarioAux = 10000;

                for (String key : keys) {
                    charsMelhorCenario = (charPorLetra - (map.get(key) * key.length())) + (map.get(key) * 2);
                    if ((charsMelhorCenarioAux > charsMelhorCenario) && key.length() > 2) {
                        charsMelhorCenarioAux = charsMelhorCenario;
                        dicionario.put(letra, key);
                    }
                }
            });

            String fraseAbreviada = vetorPalavras
                    .stream()
                    .map(word -> {
                        String primeiraLetra = word.substring(0, 1);
                        return dicionario.get(primeiraLetra).equals(word) ? primeiraLetra + "." : word;
                    }).collect(Collectors.joining(" "));

            System.out.println(fraseAbreviada);

            int qtdAbreviacoes = 0;

            for (String letra : alfabeto) {
                if (!dicionario.get(letra).equals("")) {
                    qtdAbreviacoes++;
                }
            }

            System.out.println(qtdAbreviacoes);

            alfabeto.stream().forEach(letra -> {
                if (!dicionario.get(letra).equals("")) {
                    System.out.println(letra + ". = " + dicionario.get(letra));
                }
            });
        }
    }
}