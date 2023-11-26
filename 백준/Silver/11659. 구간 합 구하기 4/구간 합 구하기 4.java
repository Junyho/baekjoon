import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] numbers = new int[N];
        int [] psum = new int[N+1];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
            psum[i+1]=psum[i]+numbers[i];
        }

        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(psum[end]-psum[start-1]);
        }






    }



}