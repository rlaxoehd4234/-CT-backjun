import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i ++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);
        for(int i = 1; i< N; i++){

            while(!myStack.empty() && A[myStack.peek()] < A[i]){
                result[myStack.pop()] = A[i];
            }
            myStack.push(i);
            }

        while(!myStack.empty()){
                result[myStack.pop()] = -1;
            }

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i< N; i++){
            bf.write(result[i] + " ");
        }
        bf.flush();
    }
}
