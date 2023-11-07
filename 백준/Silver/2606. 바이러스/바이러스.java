

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static boolean[] visited;
    static int count = 0;
    static ArrayList<Integer>[] graph;
    public static void putEdge(ArrayList<Integer>[] graph, int x, int y) {

        graph[x].add(y);
        graph[y].add(x);

    }
    static void dfs(int index){
        visited[index] = true;
        for(int node : graph[index]){

            if(!visited[node]){
                dfs(node);
                count++;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        int num_edge = Integer.parseInt(br.readLine());
        for (int i = 0;i<num_edge;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putEdge(graph,x,y);
        }

        dfs(1);
        System.out.println(count);



    }

}