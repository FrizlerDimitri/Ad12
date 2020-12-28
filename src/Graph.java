import java.util.ArrayList;
import java.util.List;


public class Graph {
	
	
	public List <GraphNode> allNodes;
	public List <Edge> allEdges;
	
	
	public Graph(int [][] Adj ) {
		
		int n=Adj[0].length;
		allNodes= new ArrayList<GraphNode>();
		allEdges= new ArrayList<Edge>();
		
		
		String NodeName="V";
		String EdgeName="E";
		
		for(int i=0; i<n; i++)
		{
			GraphNode node= new GraphNode(NodeName+i);
			allNodes.add(node);
			
		}
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(Adj[i][j] != 0)
				{
					
					Edge e=new Edge(allNodes.get(i), allNodes.get(j), Adj[i][j], EdgeName+allEdges.size());
					allNodes.get(i).addEdge(e);
					allEdges.add(e);
					
				}
				
				
			}
				
		}
		
	}
	
	
	
	public void Dijkstra(int NodeIndex)
	{
		for(int i=0; i< allNodes.size(); i++)
		{
			allNodes.get(i).dist=Integer.MAX_VALUE;
			allNodes.get(i).pred=null;
		}
		
		GraphNode curr=allNodes.get(NodeIndex);
		curr.dist=0;
		
		PrioQ H= new PrioQ();
		
		for(int i=0; i < allNodes.size(); i++ )
		{
			H.Insert(allNodes.get(i), allNodes.get(i).dist);
		}
		
		
		while(!H.isEmpty())
		{
			
			GraphNode u=(GraphNode)H.ExtractMin();
			for(int i=0; i<u.edges.size(); i++)
			{
				GraphNode v=u.edges.get(i).end;
				int w=u.edges.get(i).cost;

				
				if(v.dist>u.dist+w)
				{
					v.dist=u.dist+w;
					v.pred=u;
					
					H.DecreaseKey(v, v.dist);
				}
				
			}
						
		}
		
		System.out.println("Pred Tabel:");
		printPred();
		
	}
	

	public void BellmanFord(int NodeIndex)
	{
		
		for(int i=0; i< allNodes.size(); i++)
		{
			allNodes.get(i).dist=Integer.MAX_VALUE;
			allNodes.get(i).pred=null;
		}
		
		GraphNode curr=allNodes.get(NodeIndex);
		curr.dist=0;
		
		for(int i=0; i<allNodes.size()-1; i++)
		{
			
			for(int j=0; j<allEdges.size(); j++)
			{
				GraphNode u=allEdges.get(j).start;
				GraphNode v=allEdges.get(j).end;
				int w=allEdges.get(j).cost;
				if(v.dist>u.dist+w && u.dist!=Integer.MAX_VALUE)
				{
					v.dist=u.dist+w;
					v.pred=u;
				}
				
			}
			
		}
		
		for(int j=0; j<allEdges.size(); j++)
		{
			GraphNode u=allEdges.get(j).start;
			GraphNode v=allEdges.get(j).end;
			int w=allEdges.get(j).cost;
			if(v.dist>u.dist+w)
			{
				
				System.out.println("Negativer Zyklus");
				return;
				
			}
			
		}
		
		System.out.println("Pred Tabel:");
		printPred();
				
	}
	
	
	
	public void printPred()
	{
		String s="";
		for(int i=0; i< allNodes.size(); i++)
		{
			if(allNodes.get(i).pred != null)
			{
				s+="|"+"V"+i+" Pred: "+allNodes.get(i).pred.name+"|";
			}else {
				s+="|"+"V"+i+" Pred: null "+"|";
			}
			if(i!= allNodes.size()-1)
			{
				s+=" ";
			}
			
			
		}
		System.out.println(s);
		
	}
}
