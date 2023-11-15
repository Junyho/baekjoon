import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int N,M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static class node
    {
        int vertex;
        int distance;
        node(int vertex , int distance)
        {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static Queue<node>q = new LinkedList<>();



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        for(int i=0;i<N+1;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        bfs(1);





    }

    static void bfs(int start)
    {

        q.add(new node(start,0));
        visited[start] = true;
        int [] answer = new int []{N+1,0,0};

        while(!q.isEmpty()) {
            node current = q.remove();

            int current_vertex = current.vertex;
            int current_distance = current.distance;

            if (answer[1] < current_distance) {
                answer[0] = current_vertex;
                answer[1] = current_distance;
                answer[2] = 1;
            } else if (answer[1] == current_distance) {
                answer[2]++;

                if (answer[0] > current_vertex)
                    answer[0] = current_vertex;
            }

            for (int next : graph.get(current_vertex)) {
                if (visited[next])
                    continue;

                q.add(new node(next, current_distance + 1));
                visited[next] = true;

            }

        }
        for(int i : answer)
        {
            System.out.print(i+" ");
        }


    }


}