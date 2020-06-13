import java.util.Collections;

public class ZombieMatrix {

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
        int day=1;
        while(checkForChange(mat, day)) {
            day++;
        }
        System.out.println(day-1);
    }

    private static boolean checkForChange(int[][] mat, int day) {
        int row=mat.length;
        int col=mat[0].length;
        boolean change=false;
        for (int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(mat[i][j]==day) {
                    if(i>0 && mat[i-1][j]==0) {
                        mat[i-1][j]=day+1;
                        change=true;
                    }
                }
                if(j>0 && mat[i][j]==day) {
                    if(mat[i][j-1]==0) {
                        mat[i][j - 1] = day + 1;
                        change = true;
                    }
                }
                if(i<row-1 && mat[i][j]==day) {
                    if(mat[i+1][j]==0){
                        mat[i+1][j]=day+1;
                        change=true;
                    }
                }
                if(j<col-1 && mat[i][j]==day) {
                    if(mat[i][j+1]==0){
                        mat[i][j+1]=day+1;
                        change=true;
                    }
                }
            }
        }
        return change;
    }
}
