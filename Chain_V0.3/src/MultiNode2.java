
public class MultiNode2 {

	private Object data;
	private MultiNode2 next;
	
	public MultiNode2(Object dataToAdd) {
		data=dataToAdd;
		next=null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MultiNode2 getNext() {
		return next;
	}

	public void setNext(MultiNode2 next) {
		this.next = next;
	}
}
