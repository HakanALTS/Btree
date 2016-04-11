import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
public class TestBTree {
 
	public static void main(String[] args) throws IOException 
	{
		Random rnd = new Random();
		RandomAccessFile rafNode= new RandomAccessFile("node.txt","rws");
		RandomAccessFile rafPeople= new RandomAccessFile("people.txt","rws");
		/*HashTable hashtable = new HashTable(200000);
		BTree btree = new BTree(5);
		btree.createBTree(btree);
		People first = new People("Hakan ALTAS","Izmir",100000);
		btree.bTreeInsert(btree, first);
		while (hashtable.number<49999) 
		{
			int identity = rnd.nextInt(100000)+200000;
			if(hashtable.insert(identity))
			{
				People people = new People("Hakan ALTAS","Izmir",identity);
				btree.bTreeInsert(btree, people);
			}
		}*/
		
		BTree btree = new BTree(5);
		btree.createBTree(btree);
		//searchPeople(btree,200200);
		//insertPeople(btree,"Hakan ALTAS","Nrldr",200200);
		//searchPeople(btree,200005);
		//upDatePeople(btree,200200,"Hakan ALTAS","Konak");
		disPlay(btree,5);
		
	}
	
		public static void searchPeople(BTree btree , int identity) throws IOException// for make search
		{
			People people = new People("Hakan ALTAS","Izmir",identity);
			if(btree.bTreeSearch(btree.root,people)!=null)
			{
				System.out.println("Tree has got the identity");
			}
			else
			{
				System.out.println("Tree hasn't got the identity");
			}	
		}
		public static void insertPeople(BTree btree,String name, String address, int identity) throws IOException// for make insertion
		{
			People people = new People(name,address,identity);
			btree.bTreeInsert(btree, people);
			System.out.println("Insertion Succsefull ===> Node location: "+btree.bTreeSearch(btree.root,people).getLocation());
		}
		
		public static void upDatePeople(BTree btree, int identity, String name, String address) throws IOException// for make update in btree
		{
			People people = new People(name, address, identity);
			btree.upDatePeople(people);
		}
		
		public static void disPlay(BTree btree, int n)
		{
			btree.inOrderTravel(btree.root,n);
		}
}
