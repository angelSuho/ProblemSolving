import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        List<String> sizes = Arrays.stream(bf.readLine().split(" ")).collect(Collectors.toList());

        for (int i = 0; i < Integer.parseInt(sizes.get(0)); i++) {
            String pokemon = bf.readLine();
            map.put(String.valueOf(i + 1), pokemon);
            map.put(pokemon, String.valueOf(i + 1));

        }

        for (int i = 0; i < Integer.parseInt(sizes.get(1)); i++) {
            System.out.println(map.get(bf.readLine()));
        }
    }
}
