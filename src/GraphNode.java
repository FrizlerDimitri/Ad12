import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	
	
	public String name;
	
	public int dist;
	public List <Edge> edges;
	public GraphNode pred;
	
	
	public GraphNode(String name) {
		
		this.name=name;
		this.dist=Integer.MAX_VALUE;
		this.edges=new ArrayList<Edge>();
		this.pred=null;
		
	}
	
	public void addEdge(Edge edge)
	{
		
		this.edges.add(edge);
		
	}
	
	@Override
	public String toString() {
	
		String  s="";
				s+="Name: "+name;
				s+=" Value : "+dist;
				
		for(int i=0; i<edges.size(); i++)
		{
			s+= " "+edges.get(i).name;
		}
		
		
		return s;
		
	}
	
	
	
	
	
}
