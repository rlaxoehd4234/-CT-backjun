import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_7576 {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<back1926.Pair> qu;
    static int[][] arr;
    static int N;
    static int S;
    static int BFS(){
        while(!qu.isEmpty()){
            back1926.Pair p = qu.remove();
            int x = p.x;
            int y = p.y;
            for(int j = 0; j< 4; j++){
                int n_x = x + dx[j];
                int n_y = y + dy[j];
                if(n_x >= 0 && n_x < S && n_y >= 0 && n_y < N ) {
                    if(arr[n_x][n_y] == 0){
                        qu.add(new back1926.Pair(n_x,n_y));
                        arr[n_x][n_y] = arr[x][y] +1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0 ; i<S; i++){
            for(int k = 0; k < N; k++){
                if(arr[i][k] == 0) {return -1;}
                result = Math.max(result, arr[i][k]);
            }
        }

        if(result==1) return 0;
        else
            return result - 1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        qu = new LinkedList<back1926.Pair>();
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[S][N];
        for(int i = 0; i < S; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 1){
                    qu.add(new back1926.Pair(i,k));
                }
            }
        }
        System.out.println(BFS());
    }
}
