import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_11724 {
        static boolean[] visited;
        static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i<=N; i++){
            A[i] = new  ArrayList<Integer>();
        }

        for(int i = 1 ; i<= E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            A[x].add(y);
            A[y].add(x);
        }
        int count = 0;
        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i:A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
