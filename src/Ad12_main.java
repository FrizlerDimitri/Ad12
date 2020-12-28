

public class Ad12_main {

	public static void main(String[] args) {
		
		
		int [][] Adj1= {
				
				{0,	12,	8,	2,	0},
				{0,	0,	0,  1,	0},
				{0,	0,	0,	0,	1},
				{3,	6,	5,	0,	2},
				{0,	1,	1,	0,	0},	
		};
		
		
		Graph G= new Graph(Adj1);
		
		G.Dijkstra(0);
		
		G.BellmanFord(0);
		
	}

}
