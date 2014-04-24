package ProjectClasses;

public class Node {

	public int x;
	public int y;
	
	public Node(int newX, int newY) {
		x = newX;
		y = newY;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
	public Boolean isValid() {
		return x >= 0 && x <= 600 && y >= 0 && y <= 600;
	}
}
