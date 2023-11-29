import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long[N][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i=1;i<N;i++){
            dp[i][0] += dp[i-1][1];
            dp[i][1] += dp[i-1][0] + dp[i-1][1];
        }
        System.out.println(dp[N-1][0]+dp[N-1][1]);






    }

}