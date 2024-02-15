
public class SingleLinkedList {
	Node head;
	public void add(Object dataToAdd) {
		if(head == null)
		{
			Node newNode = new Node(dataToAdd);
			head = newNode;
		}
		else {
			Node temp = head;
			while(temp.getLink() != null)
			{
				temp = temp.getLink();
			}
			Node newNode = new Node(dataToAdd);
			temp.setLink(newNode);
		}
	}
	
	public Object getDataFromIndex(int index) {
		int counter = 0;
		Node temp = head;
		
		if(head == null)
		{
			System.out.println("Linked List is empty.");
		}
		else {
			while(counter != index)
			{
				temp = temp.getLink();
				
				counter++;
			}
		}
		
		return temp.getData();
	}
	
	
	public void delete(Object dataToDelete) {
		if(head == null)
		{
			System.out.println("Linked List is empty.");
		}
		else {
			while( head.getData() == dataToDelete)
			{
				head = head.getLink();
			}
			
			Node temp = head;
			Node previous = null;
			while(temp !=null)
			{
				if(temp.getData() == dataToDelete) {
					previous.setLink(temp.getLink());
					temp = previous;
				}
				previous = temp;
				temp = temp.getLink();
			}
		}
	}
	
	public void print() {
		if(head == null)
		{
			System.out.println("Linked List is empty");
		}
		else {
			Node temp = head;
			
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getLink();
			}
		}
	}
	
	public boolean search (Object item)
	{
		boolean flag = false;
		if(head == null)
		{
			System.out.println("Linked List is empty");
		}
		else {
			Node temp = head;
			while(temp != null)
			{
				if(item == temp.getData()) flag = true;
				temp = temp.getLink();
			}
		}
		return flag;
	}
	
	public int size() {
		int count = 0;
		if(head == null)
		{
		}
		else {
			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.getLink();
			}
		}
		return count;
	}
	
	public boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}
}
