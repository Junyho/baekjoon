import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class node{
        int u;
        int v;
        int weight;
        node(int u,int v,int weight)
        {
            this.u = u;
            this.v = v;
            this.weight = weight;

        }
    }
    static node[] edge_list;

    static int V,E;
    static int[] component;

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       V = Integer.parseInt(st.nextToken());
       E = Integer.parseInt(st.nextToken());


       component = new int[V+1];
       for(int i=0;i<V+1;i++)
           component[i]=i;

       edge_list = new node[E];

       for(int i=0;i<E;i++)
       {
           st = new StringTokenizer(br.readLine());
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());
           edge_list[i] = new node(u,v,weight);
       }

       Arrays.sort(edge_list, Comparator.comparingInt(node -> node.weight));

       int weight_sum = 0;
       for(int i=0;i<E;i++)
       {

           int u = edge_list[i].u;
           int v = edge_list[i].v;
           int weight = edge_list[i].weight;

           if (component[u]==component[v])
               continue;
           else{
               int value = component[v];
               weight_sum += weight;
               for(int j=1;j<V+1;j++)
               {
                   if(component[j]==value)
                   {
                       component[j] = component[u];
                   }
               }
           }

           int IsEqual = 1;
           int compare = component[1];

           for(int j=1;j<V+1;j++)
           {
               if(component[j]!=compare)
               {
                   IsEqual = 0;
                   break;
               }
           }
           if(IsEqual==1)
               break;
       }
       System.out.println(weight_sum);






    }

}