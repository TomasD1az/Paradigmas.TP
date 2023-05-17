package marsRover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MarsRoverTest {

	@Test public void test01() {
		assertEquals( new Pointer(0,0), new MarsRover( new Pointer(0, 0), new DirectionNorth() ).location() );
	}
	@Test public void test02() {
		assertEquals( new DirectionNorth(), new MarsRover( new Pointer(0,0), new DirectionNorth()).direction() );
	}
	
	@Test public void test03() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("f");
		assertEquals( new Pointer(0,1) , rover.location());		
	}
	
	@Test public void test04() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("b");
		assertEquals( new Pointer(0,-1) , rover.location());
	}
	
	@Test public void test05() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("fb");
		assertEquals( new Pointer(0,0) , rover.location());
	}
	
	@Test public void test06() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("l");
		assertEquals( new DirectionWest() , rover.direction());
	}
	
	@Test public void test07() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("r");
		assertEquals( new DirectionEast() , rover.direction());
	}
	
	@Test public void test08() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("ffbrffb");
		assertEquals( new Pointer(1, 1) , rover.location());
	}
	
	@Test public void test09() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		assertEquals( "No command found with given character" , assertThrows( Exception.class, () -> rover.move("a")).getMessage());
	}
}