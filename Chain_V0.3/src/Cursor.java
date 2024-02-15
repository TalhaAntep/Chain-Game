
public class Cursor {
	private int positionX;
	private int positionY;
	
	public Cursor(int posX, int posY) {
		positionX = posX;
		positionY = posY;
	}
	
	public int getX() 
	{
		return positionX;
	}
	
	public int getY() 
	{
		return positionY;
	}
	
	public void setX(int input) 
	{
		positionX = input;
	}
	
	public void setY(int input) 
	{
		positionY = input;
	}
}
