import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);


        long start = 0;
        long end = trees[N-1];


        long max = 0;
        while(start <= end)
        {
            long mid = (start+end)/2;
            long sum=0;
            for(int i=0;i<N;i++)
            {
                if(trees[i]>mid)
                    sum+=(trees[i]-mid);
            }
            if(sum>M)
            {
                max = mid;
                start = mid + 1;
            }
            else if(sum<M)
                end = mid - 1;
            else
            {
                max = mid;
                break;
            }
        }

        System.out.println(max);



    }


}