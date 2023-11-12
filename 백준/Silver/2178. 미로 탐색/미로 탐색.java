import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class location{
        int i;
        int j;
        int count;



        location(int i ,int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
        public int getCount() {
            return count;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
    static Queue<location> q = new LinkedList<>();


    static int [][] maze;
    static boolean [][] visited;
    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<M;j++){

                maze[i][j] = str.charAt(j)-'0';
            }
        }

        visited[0][0]=true;
        q.add(new location(0,0,0));
        bfs();



    }
    static void bfs (){

        while(!q.isEmpty())
        {
            location current = q.remove();
            int i = current.getI();
            int j = current.getJ();
            int moving_count = current.getCount()+1;


            if((i+1)<N && maze[i+1][j]==1 && !visited[i+1][j])
            {
                visited[i+1][j] = true;
                q.add(new location(i+1, j,moving_count));
            }
            if((j+1)<M && maze[i][j+1]==1 && !visited[i][j+1])
            {
                visited[i][j+1] = true;
                q.add(new location(i,j+1,moving_count));
            }
            if((i-1)>=0 && maze[i-1][j]==1 && !visited[i-1][j])
            {
                visited[i-1][j] = true;
                q.add(new location(i-1,j,moving_count));
            }
            if((j-1)>=0 && maze[i][j-1]==1 && !visited[i][j-1])
            {
                visited[i][j-1] = true;
                q.add(new location(i,j-1,moving_count));
            }

            if(i==N-1 && j==M-1)
            {
                System.out.println(moving_count);
                break;
            }


        }


    }


}