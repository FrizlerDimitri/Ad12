
public class Edge {
	
	public String name;
	
	public int cost;
	public GraphNode start;
	public GraphNode end;
	
	
	public Edge(GraphNode start,GraphNode end, int cost , String name)
	{
		this.start=start;
		this.end=end;
		this.cost=cost;
		this.name=name;
		
	}
	
	
	
	@Override
	public String toString() {
		
		String s=name +" : "+start.name+" -> " +cost+" -> "+end.name;
		return s;
		
	}
	
	
}
