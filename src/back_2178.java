import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int count = 0;
        Queue<back1926.Pair> qu = new LinkedList<>();
        int [][]arr = new int[N][S];
        int[][] dist = new int[N][S];

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j< S; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                dist[i][j] = -1;
            }
        }

        for(int i = 0; i < N; i++){
            for(int k = 0; k< S; k++){

                qu.offer(new back1926.Pair(i,k));
                dist[0][0] = 0;

                while(!qu.isEmpty()) {
                    back1926.Pair p = qu.poll();


                    for (int j = 0; j < 4; j++) {
                        int n_x = p.x + dx[j];
                        int n_y = p.y + dy[j];
                        if (n_x <0 || n_x >= N|| n_y < 0|| n_y >=S){
                            continue;
                        }

                        if(arr[n_x][n_y]== 0 || dist[n_x][n_y]!= -1){
                            continue;
                        }

                        qu.offer(new back1926.Pair(n_x,n_y));

                        dist[n_x][n_y]= dist[p.x][p.y]+1;

                    }
                }

            }
        }
        System.out.println(dist[N-1][S-1] + 1);

    }
}
