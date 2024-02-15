
public class DLLNode {
	private Object data;
	private DLLNode prev;
	private DLLNode next;
	
	public DLLNode (Object dataToAdd)
	{
		data = dataToAdd;
		prev = null;
		next = null;
	}
	
	public Object getData() {return data;}
	public void setData(Object data) {this.data= data;}
	
	public DLLNode getPrev() {return prev;}
	public void setPrev(DLLNode prev) {this.prev = prev;}
	
	public DLLNode getNext() {return next;}
	public void setNext(DLLNode next) {this.next = next;}
}
