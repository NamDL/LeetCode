import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProducts {

    public static void main(String[] args) {
        String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord="mouse";
        List<List<String>> solution = new ArrayList<>();
        List<String> copy = new ArrayList<>(Arrays.asList(products));
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> sol = new ArrayList<>();
            for (String s : copy) {
                if (i < s.length() && searchWord.charAt(i) == s.charAt(i)) {
                    sol.add(s);
                }
            }
            copy= new ArrayList<>(sol);
            if (sol.size() > 3) {
                Collections.sort(sol);
                while (sol.size() > 3) {
                    Collections.sort(sol);
                    sol.remove(sol.size() - 1);
                }
            }
            solution.add(sol);
        }
        System.out.println(solution);
    }
}

