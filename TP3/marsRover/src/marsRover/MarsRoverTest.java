package marsRover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class MarsRoverTest {

	@Test public void test01RoverStartsAtGivenLocation() {
		assertEquals( new Pointer(0,0), new MarsRover( new Pointer(0, 0), new DirectionNorth() ).location() );
	}
	@Test public void test02RoverStartsAtGivenDirection() {
		assertEquals( new DirectionNorth(), new MarsRover( new Pointer(0,0), new DirectionNorth()).direction() );
	}
	
	@Test public void test03RoverRemainsStillAfterEmptyCommand() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("");
		assertEquals( new Pointer(0,0) , rover.location());	
	}
	
	@Test public void test04RoverMoveForward() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("f");
		assertEquals( new Pointer(0,1) , rover.location());		
	}
	
	@Test public void test05RoverMoveBackwards() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("b");
		assertEquals( new Pointer(0,-1) , rover.location());
	}

	@Test public void test06RoverMoveLeft() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("l");
		assertEquals( new DirectionWest() , rover.direction());
	}
	
	@Test public void test07RoverMoveRight() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("r");
		assertEquals( new DirectionEast() , rover.direction());
	}
	
	@Test public void test08RoverMoveForwardAndBackwardsReturnsToFirstLocation() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("fb");
		assertEquals( new Pointer(0,0) , rover.location());
	}
	
	@Test public void test09RoverMoves() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		rover.move("ffbrffb");
		assertEquals( new Pointer(1, 1) , rover.location());
	}
	
	@Test public void test010RoverIsGivenInvalidCommand() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		assertEquals( Command.INVALID_COMMAND_ERROR , assertThrows( Exception.class, () -> rover.move("a")).getMessage());
	}
	
	@Test public void test011RoverMovesAndThenIsGivenInvalidCommand() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new DirectionNorth() );
		assertThrows( Exception.class, () -> rover.move("ffabb"));
		assertEquals( new Pointer(0,2), rover.location() );
	}
}