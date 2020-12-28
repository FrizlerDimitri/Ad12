import java.util.ArrayList;
import java.util.List;

public class PrioQ {

	private List <PrioQNode> queue;
	
	private void MinHeapify(int root, int left, int right) {
		
		int smallest;
		
		if(right < queue.size() && queue.get(left).key > queue.get(right).key)
		{
			smallest=right;
			
		}else smallest=left;
		
		if(queue.get(root).key > queue.get(smallest).key)
		{
			Object tempData=queue.get(smallest).data;
			int tempkey=queue.get(smallest).key;
			
			queue.get(smallest).data=queue.get(root).data;
			queue.get(smallest).key=queue.get(root).key;
			
			queue.get(root).data=tempData;
			queue.get(root).key=tempkey;
			
		}
		
	}
		
	private void HeapifyUp(int root, int left, int right)
	{
		if(queue.size()==1)
		{
			return;
		}
		
		while(true)
		{
			MinHeapify(root,left,right);
			
			if(root==0) break;
			
			root =(root-1)/2;
			left=root*2+1;
			right= root*2+2;
			
		}
		
	}
	
	private void HeaifyDown(int root, int left , int right)
	{
		
		if(queue.size() <=1)
		{
			return;
		}
		
		int smallest;
		
		if(right < queue.size() && queue.get(left).key > queue.get(right).key)
		{
			smallest=right;
			
		}else smallest=left;
		
			if(queue.get(root).key > queue.get(smallest).key)
				{
					
					MinHeapify(root, left, right);
					
					root=smallest;
					left=root*2+1;
					right= root*2+2;
					
					if(left < queue.size()-1)
					{
						HeaifyDown(root, left, right);
					}
					
					
				}
		
		
	}
	
	// Laufzeit=O(log(n))
	public void Insert(Object e, int key) {
		
		PrioQNode newNode=new PrioQNode(e,key);
		
		if(queue==null)
		{
			this.queue= new ArrayList<PrioQNode>();
			queue.add(newNode);
			return;
		}
				
		queue.add(newNode);
		
		int lastIndex=queue.size()-1;
		
		int rootIndex=(lastIndex-1)/2;
		int left=rootIndex*2+1;
		int right= rootIndex*2+2;
		
		HeapifyUp(rootIndex, left, right);
		
	}

	// Laufzeit=O(1)
	public Object GetMin() {
		
		if(queue==null)
		{
			return null;
		}
		return queue.get(0).data;
	}
	 
	//Laufzeit=O(log(n))
	public Object ExtractMin() {
		
		if(queue==null)
		{
			return null;
		}
		
		Object retdata=queue.get(0).data;
		
		
		int last=queue.size()-1;
		
		Object tempdata=queue.get(last).data;
		int tempkey=queue.get(last).key;
		
		queue.get(0).data=tempdata;
		queue.get(0).key=tempkey;	
		queue.remove(last);
		
		int root=0;
		int left=root*2+1;
		int right=root*2+2;
			
		HeaifyDown(root, left, right);
		
		if (queue.size()==0) queue=null;
		return retdata;

	}
	
	//Laufzeit=O(log(n))
	public void DecreaseKey(Object e, int pos, int newKeyValue) {
		
		if(queue.get(pos).data==e)
		{
			
			if(newKeyValue>queue.get(pos).key)
			{
				System.out.println("New Key value should be smaller!");
				
				return;
			}
			
			queue.get(pos).key=newKeyValue;
			
			int lastIndex=pos;
			int rootIndex=(lastIndex-1)/2;
			int left=rootIndex*2+1;
			int right=rootIndex*2+2;
			
			HeapifyUp(rootIndex, left, right);
				
		} else {
			
			System.out.println("The Objects are not the same!");
		}
		
	}

	
	public void DecreaseKey(Object e, int newKeyValue)
	{
		
		int pos=getPos(e);
		
		DecreaseKey(e, pos, newKeyValue);
		
	}
	
	
	
	
	public void printCurrentQueue() {
		
		if(queue==null)
		{
			return;
		}
		
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.get(i).data.toString() + " key: " + queue.get(i).key);
		}

	}

	
	public boolean isEmpty()
	{
		return (queue==null)?true:false;
	}
	
	
	public int getPos(Object e)
	{
		for(int i=0; i<queue.size(); i++)
		{
			if(e==queue.get(i).data)
			{
				return i;
			}
		}
		return -1;
		
	}
	
	
	
	
	
	
}
