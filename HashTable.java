
public class HashTable 
{
	int [] hashtable;
	int index=0;
	int number=0;
	HashTable(int number)
	{
		hashtable=new int[number];
	}
	public boolean insert(int key)
	{
		boolean flag= false;
		index=key-100000;
		if(hashtable[index]==0)
		{
			hashtable[index]=key;
			flag=true;
			number++;
		}
		return flag;
	}
}