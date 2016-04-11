
public class DisplayHashTable 
{
	long [] hashtable;
	long index=0;
	int number=0;
	public DisplayHashTable(int number) {
		hashtable=new long[number];
	}
	public boolean insert(long key)
	{
		boolean flag= false;
		index=key;
		if(hashtable[(int) index]==0)
		{
			hashtable[(int) index]=key;
			flag=true;
			number++;
		}
		return flag;
	}
}
