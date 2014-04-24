package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

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

}
