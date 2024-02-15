
public class DoubleLinkedList {
	private DLLNode head;
	private DLLNode tail;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(Object o)
	{
		DLLNode newNode;
		
		if(head == null) {
			newNode = new DLLNode(o);
			head = newNode;
			tail = newNode;
		}
		else {
			newNode = new DLLNode(o);
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	public int size() {
		int count = 0;
		if(head == null)
		{
			System.out.println("LinkedList is empty.");
		}
		else {
			DLLNode temp = head;
			while(temp != null)
			{
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}
}
