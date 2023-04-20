import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back1926 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y =y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][S];
        boolean[][] visited = new boolean[N][S];
        Queue<Pair> qu = new LinkedList<>();
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < S; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int k = 0; k<S; k++){
                if(arr[i][k] == 0 || visited[i][k]) continue;;

                count++;
                qu.offer(new Pair(i,k));
                visited[i][k] = true;
                area = 0;
                while(!qu.isEmpty()){
                    Pair p = qu.poll();
                    area++;
                    for(int j = 0; j<4; j++){
                        int n_x = p.x + dx[j];
                        int n_y = p.y + dy[j];
                        if(n_x < 0 || n_x >= N || n_y <0 || n_y >= S ){
                            continue;
                        }
                        if(arr[n_x][n_y] == 1 && !visited[n_x][n_y]){
                            qu.offer(new Pair(n_x,n_y));
                            visited[n_x][n_y] = true;
                        }
                    }
                }
                if(area > max) max = area;

            }
        }
        System.out.println(count);
        System.out.println(max);





    }
}
