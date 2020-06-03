import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderLogs {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for(String str:logs) {
            String[] secondChar=str.split(" ");
            if(secondChar[1].matches("-?\\d+(\\.\\d+)?")) {
                digitLogs.add(str)   ;
            } else {
                letterLogs.add(str);
            }
        }
        letterLogs.sort((a, b) -> {
            String[] strA=a.split(" ", 2);
            String[] strB=b.split(" ", 2);
            return strA[1].equals(strB[1]) ? a.compareTo(b): strA[1].compareTo(strB[1]);
        });
        letterLogs.addAll(digitLogs);
        System.out.println(letterLogs);
    }
}
