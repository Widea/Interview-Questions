
public class listAddition{

node head;

class node{
	node next;
	int value;

	public node()
	{
		value = 0;
		next = null;
	}
	public node(int inputValue)
	{
		value = inputValue;
		next = null;
	}
}

public listAddition()
{
	head = new node();
}

public listAddition(int inputValue)
{
	head = new node(inputValue);
}

public void addToList(int nodeValue)
{
	node temp = new node(nodeValue);
	if(head == null)
	{
		head = temp;
		return;
	}
	node ptr = head;

	while(ptr.next != null)
	{
		ptr = ptr.next;
	}

	ptr.next = temp;
}

public static void printSum(node listHead)
{	String print = "";
	
	if(listHead == null) 
	{
		return;
	}
	
	node temp = listHead.next;  
	
	while(temp.next != null)
	{
		print += temp.value;
		temp = temp.next;
	}
	
	print += temp.value;
	System.out.println(new StringBuilder(print).reverse());
}

public static node addLists(node list1Head, node list2Head)
{
    int borrow = 0;
    listAddition listSum = new listAddition();
    node l1 = list1Head, l2 = list2Head;
    while(l1 != null || l2 != null)
    {
        int sum = 0;      
        if(l1!= null)
        {
            sum += l1.value;
            l1 = l1.next;
        }
        if (l2 != null) 
        {
        	sum += l2.value;
        	l2 = l2.next;
        }
        
        sum += borrow;
        
        if (sum < 10)
        {
            borrow = 0;
        }
        else
        {
        	sum -= 10;
          	borrow = 1;
        }
        
        listSum.addToList(sum);       
    }
    
    if (borrow == 1) 
    {
    	listSum.addToList(1);
    }
      
    return listSum.head;
}

 public void reverse() 
{
    if (head == null) 
    {
       return;
    }
    node current = head;
    node after = current.next;
    while (after != null) 
    {
       node tmp = after.next; 
       after.next = current;  
       current = after;      
       after = tmp;           
    }
    head.next = null;         
    head = current;          
}

public static void main (String[] args){

    listAddition list1 = new listAddition(1);
    listAddition list2 = new listAddition(2);
    list1.addToList(2);
    list1.addToList(3);
    list2.addToList(5);
    list1.reverse(); 
    list2.reverse();   
    printSum(addLists(list1.head,list2.head));
}
}
