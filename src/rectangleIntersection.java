public class rectangleIntersection {

    public static void main(String[] args) {
        System.out.println(check());
    }

    private static boolean check() {
        int[] rec1={11,12,13,13};
        int[] rec2={17,1,17,19};
        int x1=rec1[0];
        int y1=rec1[1];
        int x2=rec1[2];
        int y2=rec1[2];

        int x3=rec2[0];
        int y3=rec2[1];
        int x4=rec2[2];
        int y4=rec2[3];

        if(x1<x3 && x3<x2) return true;
        if(x1<x4 && x4<x2) return true;
        if(x3<x1 && x1<x4) return true;
        if(x3<x2 && x2<x4) return true;

        if(y1<y3 && y3<y2) return true;
        if(y1<y4 && y4<y2) return true;
        if(y3<y1 && y1<y4) return true;
        if(y3<y2 && y2<y4) return true;

        return false;
    }
}
