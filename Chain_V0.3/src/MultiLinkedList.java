
public class MultiLinkedList {

	private MultiNode head;
	public void addLayer(Object dataToAdd) {
		MultiNode temp;
		if (head == null) {
			temp = new MultiNode(dataToAdd); 
			head = temp;
		}
		else {		     
			temp = head;
			while (temp.getDown() != null)
				temp = temp.getDown();
			MultiNode newnode = new MultiNode(dataToAdd);
			temp.setDown(newnode);
		}
	}
	
	public void addItem(Object Category, Object Item) {
		if (head == null)    
			System.out.println("Add a Category before Item");
		else {
			MultiNode temp = head;
			while (temp != null)
			{	    	 
				if (Category.equals(temp.getLayer())) {
					MultiNode2 temp2 = temp.getRight(); 
					if (temp2 == null) {
						temp2 = new MultiNode2(Item); 
						temp.setRight(temp2);
					}
					else {				 
						while (temp2.getNext() != null)
							temp2 = temp2.getNext();
						MultiNode2 newnode = new MultiNode2(Item);
						temp2.setNext(newnode);
					}			          
				}
				temp = temp.getDown();
			}
		}
	}
	
	public void display()
	{	
		int a=6;
		if (head == null) {   
			
		/*	System.out.println("linked list is empty");*/
			}
		else {
			MultiNode temp = head;
			while (temp != null)
			{
				
				Chain.cn.getTextWindow().setCursorPosition(40,a);
				MultiNode2 temp2 = temp.getRight();
				while (temp2 != null)
				{
					System.out.print(temp2.getData());
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				a++;
			}
		}
	}
}
