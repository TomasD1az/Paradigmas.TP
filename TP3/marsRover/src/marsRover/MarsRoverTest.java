package marsRover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MarsRoverTest {

	@Test public void test01RoverStartsAtGivenLocation() {
		assertEquals( pointIn00(), marsroverPoint00DirectionNorth().location() );
	}
	
	@Test public void test02RoverStartsAtGivenDirection() {
		assertEquals( new DirectionNorth(), marsroverPoint00DirectionNorth().direction() );
	}
	
	@Test public void test03RoverRemainsStillAfterEmptyCommand() {
		assertEquals( pointIn00() , marsroverPoint00DirectionNorth().move("").location());	
	}
	
	@Test public void test04RoverMoveForward() {
		assertEquals( new Pointer(0,1) , marsroverPoint00DirectionNorth().move("f").location());		
	}
	
	@Test public void test05RoverMoveBackwards() {
		assertEquals( new Pointer(0,-1) , marsroverPoint00DirectionNorth().move("b").location());
	}

	@Test public void test06RoverMoveLeft() {
		assertEquals( new DirectionWest() , marsroverPoint00DirectionNorth().move("l").direction());
	}
	
	@Test public void test07RoverMoveRight() {
		assertEquals( new DirectionEast() , marsroverPoint00DirectionNorth().move("r").direction());
	}
	
	@Test public void test08RoverMoveForwardAndBackwardsReturnsToFirstLocation() {
		assertEquals( pointIn00() , marsroverPoint00DirectionNorth().move("fb").location());
	}
	
	@Test public void test09RoverMovesWithACompounCommand() {
		assertEquals( new Pointer(1, 3) , marsroverPoint00DirectionNorth().move("fflbrffb").location());
	}
	
	@Test public void test10RoverIsGivenInvalidCommand() {
		throwsLike(Command.INVALID_COMMAND_ERROR, () -> marsroverPoint00DirectionNorth().move("a"));
	}
	
	@Test public void test11RoverGivenInvalidCommandRemainsAtLastPosition() {
		MarsRover rover = marsroverPoint00DirectionNorth();
		assertThrows( Exception.class, () -> rover.move("ffabb"));
		assertEquals( new Pointer(0,2), rover.location() );
	}
	
	private void throwsLike(String msg, Executable executable) {
		assertEquals( msg , assertThrows( Exception.class, executable).getMessage());
	}
	
	private MarsRover marsroverPoint00DirectionNorth() {
		return new MarsRover( pointIn00(), new DirectionNorth() );
	}
	
	private Pointer pointIn00() {
		return new Pointer(0,0);
	}
}