package marsRover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class marsRoverTest {

	@Test public void test01() {
		assertEquals( new Pointer(0,0), new MarsRover( new Pointer(0, 0), new North() ).location() );
	}
	@Test public void test02() {
		assertEquals( new North(), new MarsRover( new Pointer(0,0), new North()).direction() );
	}
	
	@Test public void test03() {
		MarsRover rover = new MarsRover( new Pointer(0,0) , new North() );
		rover.move("f");
		assertEquals( new Pointer(0,1) , rover.location());		
	}
}