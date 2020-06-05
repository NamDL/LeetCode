import java.util.*;

public class NeighboringHouses {

    public static void main(String[] args) {
        int[] states={1,1,1,0,1,1,1,1};
        int days=2;
        int rep=0;
        boolean flag=false;
        Set<String> set = new HashSet<>();
        for(int i=0;i<days;i++) {
            int[] newDay = getPattern(states);
            if(set.contains(Arrays.toString(newDay))) {
                flag=true;
                break;
            }
            rep++;
            set.add(Arrays.toString(newDay));
            states=newDay;
        }
        if(flag) {
            days = days%rep;
            for(int i=0;i<days;i++) {
                states=getPattern(states);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i: states) {
            list.add(i);
        }
        System.out.println(list);
    }

    private static int[] getPattern(int[] states) {
        int[] result = new int[states.length];
        for(int i=1, j=1;i<states.length-1 &&j<result.length-1;i++,j++) {
            if(states[i-1]==states[i+1]) {
                result[j]=0;
            }else {
                result[j]=1;
            }
        }
        if(states[1]==1) {
            result[0]=1;
        }
        if(states[states.length-2]==1) {
            result[states.length-1]=1;
        }
        return result;
    }
}
