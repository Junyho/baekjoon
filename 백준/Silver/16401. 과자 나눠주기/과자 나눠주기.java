import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long [] snack = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            snack[i] = Long.parseLong(st.nextToken());

        Arrays.sort(snack);

        long start = 0;
        long end = snack[N-1];
        long max = 0;
        while(start <= end)
        {
            long count = 0;
            long mid = (start+end) / 2;
            for(int i=0;i<N;i++)
            {
                if(snack[i]>=mid)
                {
                    if (mid == 0)
                        count += 1;
                    else
                        count+=snack[i]/mid;
                }
                    
            }


            if(count>=M) {
                max = Math.max(mid,max);
                start = mid + 1;
            }
            else
                end = mid - 1;

        }
        System.out.println(max);




    }
}