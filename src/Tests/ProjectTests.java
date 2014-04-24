package Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ProjectClasses.Main;
import ProjectClasses.Hiker;
import ProjectClasses.Helicopter;
import ProjectClasses.Dog;
import ProjectClasses.Node;

public class ProjectTests {
	
	private Hiker hiker;
	private Helicopter helicopter;
	private Dog dog;

	@Before
	public void setUp() {
		Main main = new Main();
		hiker = new Hiker();
		helicopter = new Helicopter();
		dog = new Dog();
	}
	
	@Test
	public void testPredictMovement() {
	//	hiker.predictMovement();
		Node expected = new Node(0, 0); //expected location after movement
		Node actual = hiker.getLocation();
		Assert.assertEquals(expected, actual);
	//	helicopter.predictMovement();
		expected = new Node(0, 0);
		actual = helicopter.getLocation();
		Assert.assertEquals(expected, actual);
		expected = new Node(0, 0); 
		actual = dog.getLocation();
		Assert.assertEquals(expected, actual);
	}

}
