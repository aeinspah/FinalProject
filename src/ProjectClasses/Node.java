package ProjectClasses;

public class Node {

	public int x;
	public int y;
	
	public Node(int newX, int newY) {
		x = newX;
		y = newY;
	}

	// for tests
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
	public boolean equals(Node node) {
		return (x == node.x && y == node.y);
	}
	
	public Boolean isValid() {
		return x >= 0 && x <= 600 && y >= 0 && y <= 600;
	}
}
