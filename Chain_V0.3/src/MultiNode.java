
public class MultiNode {

	private Object layer; // her bir chain layer
	private MultiNode down;
	private MultiNode2 right;
	
	public MultiNode(Object dataToAdd) {
		layer=dataToAdd;
		down=null;
		right=null;
	}


	public Object getLayer() {
		return layer;
	}

	public void setLayer(Object layer) {
		this.layer = layer;
	}

	public MultiNode getDown() {
		return down;
	}

	public void setDown(MultiNode down) {
		this.down = down;
	}

	public MultiNode2 getRight() {
		return right;
	}

	public void setRight(MultiNode2 right) {
		this.right = right;
	}
}
