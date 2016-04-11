
import java.io.Serializable;

public class Node implements Serializable
{	
	private long [] nodeLocation;
	private long [] keyLocation;
	private Node [] node;
	private People [] key ;
	private int number=0;
	private int t;
	private boolean isLeaf=true;
	private long location;
	public Node(int t) 
	{
		//this.location=0;
		this.t=t;
		key=new People[2*t-1];
		node= new Node[2*t];
		keyLocation= new long [2*t-1];
		nodeLocation= new long [2*t];
		
	}	

	public long[] getNodeLocation() {
		return nodeLocation;
	}
	public void setNodeLocation(long[] nodeLocation) {
		this.nodeLocation = nodeLocation;
	}
	public long[] getKeyLocation() {
		return keyLocation;
	}
	public void setKeyLocation(long[] keyLocation) {
		this.keyLocation = keyLocation;
	}
	public long getLocation() {
		return location;
	}
	public void setLocation(long location) {
		this.location = location;
	}




	public People[] getKey() {
		return key;
	}

	public void setKey(People[] key) {
		this.key = key;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public Node[] getNode() {
		return node;
	}
	public void setNode(Node[] node) {
		this.node = node;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
