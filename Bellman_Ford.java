import java.util.Scanner;
class Edge { int u, v, w; Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; } }
public class Bellman_Ford { static void bellmanFord(Edge[] edges, int V, int E, int src) { int[] dist = new int[V];
    for (int i = 0; i < V; i++) { dist[i] = Integer.MAX_VALUE; }
    dist[src] = 0;
    for (int i = 1; i <= V - 1; i++) { for (int j = 0; j < E; j++) { int u = edges[j].u; int v = edges[j].v; int w = edges[j].w;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) { dist[v] = dist[u] + w; } } }
    for (int j = 0; j < E; j++) { int u = edges[j].u; int v = edges[j].v; int w = edges[j].w;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) { System.out.println("Negative weight cycle detected!"); return; } }
    System.out.println("Vertex\tDistance"); for (int i = 0; i < V; i++) { System.out.println(i + " \t" + dist[i]); } }
    public static void main(String[] args) { Scanner sc = new Scanner(System.in); int V, E;
        do { System.out.print("Enter number of vertices (<4): "); V = sc.nextInt();
        } while (V <= 0 || V >= 4); do { System.out.print("Enter number of edges (<4): "); E = sc.nextInt();
        } while (E <= 0 || E >= 4); Edge[] edges = new Edge[E]; System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) { int u = sc.nextInt(); int v = sc.nextInt(); int w = sc.nextInt();
            if (u >= V || v >= V || u < 0 || v < 0) { System.out.println("Invalid vertex! Re-enter edge:"); i--; continue; }
            edges[i] = new Edge(u, v, w);
        }
        int src; do {
            System.out.print("Enter source vertex: ");
            src = sc.nextInt();
        } while (src < 0 || src >= V);
        bellmanFord(edges, V, E, src);
        sc.close();
    }
}