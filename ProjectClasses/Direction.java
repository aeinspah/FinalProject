package ProjectClasses;

public enum Direction {

	NORTH ("North"), SOUTH ("South"), EAST ("East"), WEST ("West"), NORTHWEST ("Northwest"), 
	SOUTHWEST ("Southwest"), NORTHEAST ("Northeast"), SOUTHEAST ("Southeast");
	
	private String direction;
	
	Direction(String aDirection) {
		direction = aDirection;
	}
	
	public String toString() {
		return direction;
	}
	
}
