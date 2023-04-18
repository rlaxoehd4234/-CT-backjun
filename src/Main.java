import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int k = 0; k <N; k++){
            long find = arr[k];
            int i = 0;
            int j = N-1;

            while(i < j) {
                if(arr[i] + arr[j] == find){
                    if(i != k && j != k){
                        result++;
                        break;
                    }else if(i == k){
                        i++;
                    }else if(j == k){
                        j--;
                    }
                }else if(arr[i] + arr[j] < find){
                    i++;
                }else {
                    j--;
                }
            }
        }
        System.out.println(result);

    }
}