package Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ProjectClasses.Main;
import ProjectClasses.Hiker;
import ProjectClasses.Helicopter;
import ProjectClasses.Dog;

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
		hiker.predictMovement();
		int expected = 5; //expected location after movement
		int actual = hiker.getLocation();
		Assert.assertEquals(expected, actual);
		helicopter.predictMovement();
		expected = 5;
		actual = helicopter.getLocation();
		Assert.assertEquals(expected, actual);
		expected = 5; 
		actual = dog.getLocation();
		Assert.assertEquals(expected, actual);
	}

}
