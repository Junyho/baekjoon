import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        dp = new int[N+1][3];

        for(int i=1;i<N+1;i++)
            stairs[i] = Integer.parseInt(br.readLine());

        for(int i=0;i<3;i++)
            dp[0][i]=0;

        for(int i=1;i<N+1;i++)
        {
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = dp[i-1][0]+ stairs[i];
            dp[i][2] = dp[i-1][1]+ stairs[i];
        }
        System.out.println(Math.max(dp[N][1],dp[N][2]));




    }



}