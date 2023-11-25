import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++)
        {
            q.add(i+1);
        }
        while(q.size()>1)
        {
            q.remove();
            if(q.size()==1)
                break;
            q.add(q.remove());

        }
        System.out.println(q.peek());



    }



}