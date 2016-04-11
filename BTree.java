import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class BTree {
	int t;// t reference number
	Node root;
	RandomAccessFile rafNode= new RandomAccessFile("node.txt","rws");// for save and read node.txt
	RandomAccessFile rafPeople= new RandomAccessFile("people.txt","rws");// for save and read people.txt
	int counter=0;// for control display
	DisplayHashTable hashtable = new DisplayHashTable(300000);
	public BTree(int t) throws IOException 
	{ 
		this.t=t;	
	}
	public void createBTree(BTree T) throws IOException
	{
		/*
			Node x= new Node(t);// for first add
			x.setLocation(rafNode.length());
			T.setRoot(x);
			writeDisk(x,x.getLocation());//*****
			//Disk Write
			*/
			
		
			Node x = readDisk(0);// for add in file
			x.setLocation(0);
			T.setRoot(x);
		
	}
	public void bTreeInsert(BTree T, People element) throws IOException// for insertion people
	{
		Node tempr =T.getRoot();
		element.setLocation(rafPeople.length());
		writePeople(element);//******
		if(tempr.getNumber()==2*t-1)// control split
		{
			Node s = new Node(t);
			T.setRoot(s);
			s.setLeaf(false);
			s.setNumber(0);
			s.getNode()[0]=tempr;
			bTreeSplitChild(s,0);// split node
			bTreeInsertNonfull(s, element);	
		}
		else
		{
			bTreeInsertNonfull(tempr, element);
		}
		writeDisk(root, root.getLocation());
	}
	public void bTreeInsertNonfull(Node x, People element) throws IOException// insert nonfull node
	{
		int i = x.getNumber()-1;
		if(x.isLeaf())
		{
			while(i>= 0 && (int)element.getIdentityNumbers() < (int)x.getKey()[i].getIdentityNumbers())
			{
				x.getKey()[i+1]=x.getKey()[i];//
				i=i-1;
			}
			x.getKey()[i+1]=element;
			x.setNumber(x.getNumber()+1);
			for (int j = 0; j <x.getKey().length; j++) //*******
			{
				if(x.getKey()[j]!=null)
				x.getKeyLocation()[j]=x.getKey()[j].getLocation();
			}
			for (int j = 0; j <x.getNode().length; j++) //*******
			{
				if(x.getNode()[j]!=null)
				x.getNodeLocation()[j]=x.getNode()[j].getLocation();
			}
			writeDisk(x,x.getLocation());
			//DiskWrite X
		}
		else
		{
			if(x.getKey()[i]!=null)
			{
				while(i>= 0 && (int)element.getIdentityNumbers() < (int)x.getKey()[i].getIdentityNumbers())
				{
					i=i-1;
				}
			}
			i=i+1;
			if(x.getNode()[i].getNumber()==2*t-1)
			{
				bTreeSplitChild(x,i);///////////
				if((int)element.getIdentityNumbers()>(int)x.getKey()[i].getIdentityNumbers())
				{
					i=i+1;
				}
				//writeDisk(x, x.getLocation());// Update
			}
				bTreeInsertNonfull(x.getNode()[i], element);
		}
	}
	public void bTreeSplitChild(Node x, int i) throws IOException// split for full node
	{
		Node z = new Node(t);//left
		Node y = x.getNode()[i];// right
		z.setLeaf(y.isLeaf());
		z.setNumber(t-1);
		for (int j = 0; j < t-1; j++) {//tamam
			z.getKey()[j]=y.getKey()[j+t];
		}
		if(y.isLeaf()!=true)
		{
			for (int j = 0; j < t; j++) 
			{
				z.getNode()[j]=y.getNode()[j+t];
				y.getNode()[j+t]=null;//add
			}
		}
		y.setNumber(t-1);
		for (int j = x.getNumber(); j >= i+1; j--)// x.getnumber+1 var
		{
			x.getNode()[j+1]=x.getNode()[j];
		}
		x.getNode()[i+1]=z;//tamam
		for (int j = x.getNumber()-1; j >=i; j--) /// tamam
		{
			x.getKey()[j+1]=x.getKey()[j];
		}
		x.getKey()[i]=y.getKey()[t-1];// tamam 
		x.setNumber(x.getNumber()+1);
		
		for (int j = t-1; j <x.getNode()[i].getKey().length; j++)//midpoint delete mine 
		{
			x.getNode()[i].getKey()[j]=null;
			x.getNode()[i].getKeyLocation()[j]=0;//not problem
		}
		
		y.setLocation(rafNode.length());//*****
		for (int j = 0; j <y.getKey().length; j++) //*******
		{
			if(y.getKey()[j]!=null)
			y.getKeyLocation()[j]=y.getKey()[j].getLocation();
		}
		for (int j = 0; j <y.getNode().length; j++) //*******
		{
			if(y.getNode()[j]!=null)
			y.getNodeLocation()[j]=y.getNode()[j].getLocation();
		}
		writeDisk(y,y.getLocation());
		
		z.setLocation(rafNode.length());//*****
		for (int j = 0; j <z.getKey().length; j++) //*******
		{
			if(z.getKey()[j]!=null)
			z.getKeyLocation()[j]=z.getKey()[j].getLocation();
		}
		for (int j = 0; j <y.getNode().length; j++) //*******
		{
			if(z.getNode()[j]!=null)
			z.getNodeLocation()[j]=z.getNode()[j].getLocation();
			
		}
		writeDisk(z,z.getLocation());
		for (int j = 0; j <x.getKey().length; j++) //*******
		{
			if(x.getKey()[j]!=null)
			x.getKeyLocation()[j]=x.getKey()[j].getLocation();
		}
		for (int j = 0; j <x.getNode().length; j++) //*******
		{
			if(x.getNode()[j]!=null)
			x.getNodeLocation()[j]=x.getNode()[j].getLocation();
		}
		for (int j = 0; j < x.getKeyLocation().length; j++)
		{// ekrana yazdýrma
			if(x.getKey()[j]!=null)
			{
				x.getKeyLocation()[j]=x.getKey()[j].getLocation();
				//System.out.print(x.getKeyLocation()[j]+" ");
			}
		}
		//System.out.println();
		
		writeDisk(x,x.getLocation());
		
		//Disk Write Y
		//Disk Write Z
		//Disk Write Parent
	}
	public Node bTreeSearch(Node x ,People k) throws IOException
	{
		int i=0;
		while(x.getKey()[i]!=null && i<x.getNumber() && (int)k.getIdentityNumbers()>(int)x.getKey()[i].getIdentityNumbers())// control way
		{
			i=i+1;
		}
		if(x.getKey()[i]!=null && i<x.getNumber() && (int)k.getIdentityNumbers()==(int)x.getKey()[i].getIdentityNumbers())// return finding node
		{
			return (x);
		}
		else if(x.isLeaf())// not find this node
		{
			return null;
		}
		else// contuine search
		{
			Node node = readDisk(x.getNodeLocation()[i]);
			return bTreeSearch(node,k);			
			// read Disk
			//return bTreeSearch(x.getNode()[i], k);
		}
	}
	
	public void inOrderTravel(Node node,int n)// for display elements
	{
		
		if ( node != null && counter<n)
		    {
				int i;
		        for (i = 0 ; i < node.getNode().length ; i++ )
		        {
		        	
		            inOrderTravel(node.getNode()[i],n);
		            if( i<node.getKey().length && node.getKey()[i]!=null && hashtable.insert(node.getKey()[i].getIdentityNumbers())&& counter<n)
		            {
		            	System.out.println(node.getKey()[i].getIdentityNumbers()+" "+node.getKey()[i].getName()+" "+node.getKey()[i].getAddress());
		            	counter++;
		            }
		        }
		        if(i<node.getNode().length)
		        inOrderTravel(node.getNode()[i],n) ;
		    }
	}
	public void upDatePeople(People newpeople) throws IOException// for update information
	{
		
		Node tempnode = bTreeSearch(root,newpeople);
		if(tempnode !=null)
		{
			for (int i = 0; i <tempnode.getKey().length; i++) 
			{
				if(tempnode.getKey()[i]!=null && tempnode.getKey()[i].getIdentityNumbers() == newpeople.getIdentityNumbers())
				{
					newpeople.setLocation(tempnode.getKey()[i].getLocation());
					writePeople(newpeople);
					System.out.println("Location "+newpeople.getLocation()+" "+newpeople.getIdentityNumbers()+" "+newpeople.getName()+" "+newpeople.getAddress());
				}
			}
		}
		else
		{
			System.out.println("Identity number is false !");
		}
		
	}
	public int getNumber() {
		return t;
	}

	public void setNumber(int t) {
		this.t = t;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	public Node readDisk(long l) throws IOException// for read node
	{
		rafNode.seek(l);
		String x = rafNode.readUTF();
		String [] word = x.split("X");// split keys and nodes
		String [] word1 = word[0].trim().split(";");// split keys
		String [] word2 = word[1].trim().split(";");// split nodes
		Node node = new Node(t);
		int counter=0;
		for (int i = 0; i < word1.length; i++) 
		{
			if(!word1[i].equalsIgnoreCase("0"))
			{
				node.getKey()[counter]=readPeople(Integer.valueOf(word1[i].trim()));
				node.getKeyLocation()[counter]=Integer.valueOf(word1[i]);
				node.setNumber(node.getNumber()+1);
				counter++;
			}
		}
		counter=0;
		for (int i = 0; i < word2.length; i++) 
		{
			if(!word2[i].equalsIgnoreCase("0"))
			{
				node.getNodeLocation()[counter]=Long.valueOf(word2[i].trim());
				node.getNode()[counter]=readDisk(node.getNodeLocation()[counter]);
				counter++;
			}
		}
		if(node.getNodeLocation()[0]!=0)
		{
			node.setLeaf(false);
		}
		node.setLocation(l);
		return node;
	}
	public People readPeople(int peoplelocation) throws IOException
	{
		rafPeople.seek(peoplelocation);
		String x = rafPeople.readUTF();
		String [] word = x.split(";");// split person information
		People people = new People(word[1],word[2],Integer.valueOf(word[0]));
		people.setLocation(peoplelocation);// important
		return people;
	}
	public void writeDisk(Node node, long l) throws IOException
	{
		String x ="";
		if(node.getKeyLocation()!=null)
		{
			for (int i = 0; i < node.getKeyLocation().length; i++)
			{
				x=x+node.getKeyLocation()[i]+";";
			}
			x=x+"X";// for division keys and nodes
			for (int i = 0; i < node.getNodeLocation().length; i++)
			{
				x=x+node.getNodeLocation()[i]+";";
			}
			for (int i = x.length(); i <700; i++) 
			{
				x=x+" ";
			}
			rafNode.seek(l);
			rafNode.writeUTF(x);
		}
	}
	public void writePeople(People people) throws IOException
	{
		String x=people.getIdentityNumbers()+";"+people.getName()+";"+people.getAddress(); 
		rafPeople.seek(people.getLocation());
		rafPeople.writeUTF(x);
	}
	
}
