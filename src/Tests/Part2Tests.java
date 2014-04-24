package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ProjectClasses.DialogBox;
import ProjectClasses.Dog;
import ProjectClasses.Helicopter;
import ProjectClasses.Hiker;
import ProjectClasses.Main;
import ProjectClasses.Node;

public class Part2Tests {
	
	private Hiker hiker;
	private Helicopter helicopter;
	private Dog dog;
	private ArrayList<Node> visitedLocs;

	@Before
	public void setUp() {
		Main main = new Main();
		hiker = new Hiker();
		helicopter = new Helicopter();
		dog = new Dog();
	}

	@Test
	public void testInitialSetup() { //checks to make sure there are not locations added before program starts
		visitedLocs = hiker.getVisitedLocations();
		int expected = 0;
		int actual = visitedLocs.size();
		Assert.assertEquals(expected, actual);
		
		visitedLocs = helicopter.getVisitedLocations();
		expected = 0;
		actual = visitedLocs.size();
		Assert.assertEquals(expected, actual);
		
		visitedLocs = dog.getVisitedLocations();
		expected = 0;
		actual = visitedLocs.size();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void testPredictMovement() { // checks predictMovement() as well as updateLocation()
		// prediction after one movement: for hiker
		hiker.updateLocation(new Node(0, 0)); //initial location for test purposes
		hiker.updateLocation(hiker.predictMovement());
		Node expected = new Node(10, 0);
		Node actual = hiker.getLocation();
		Assert.assertTrue(expected.equals(actual));
		// prediction after two movements: for hiker
		hiker.updateLocation(hiker.predictMovement());
		expected = new Node(20, 0);
		actual = hiker.getLocation();
		Assert.assertTrue(expected.equals(actual));
		
		//prediction after one movement: for helicopter
		helicopter.updateLocation(new Node(2, 1)); //initial location for test purposes
		helicopter.updateLocation(helicopter.predictMovement());
		expected = new Node(12, 1);
		actual = helicopter.getLocation();
		Assert.assertTrue(expected.equals(actual));
		// prediction after two movements: for helicopter
		helicopter.updateLocation(helicopter.predictMovement());
		expected = new Node(22, 1);
		actual = helicopter.getLocation();
		Assert.assertTrue(expected.equals(actual));
		
		//prediction after one movement: for dog
		dog.updateLocation(new Node(4, 3)); //initial location for test purposes
		dog.updateLocation(dog.predictMovement());
		expected = new Node(14, 3);
		actual = dog.getLocation();
		Assert.assertTrue(expected.equals(actual));
		// prediction after two movements: for dog
		dog.updateLocation(dog.predictMovement());
		expected = new Node(24, 3);
		actual = dog.getLocation();
		Assert.assertTrue(expected.equals(actual));
		
	}

}
