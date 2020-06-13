import java.util.ArrayList;
import java.util.List;

public class TestVal {

    public static void main(String[] args) {
        String a = "ab3";
        String b ="ac2";
        List<String> str = new ArrayList<>();
        str.add(a);
        str.add(b);
        str.sort(String::compareTo);
        System.out.println(str);
    }
}

