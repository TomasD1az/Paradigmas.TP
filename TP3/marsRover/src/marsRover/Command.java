package marsRover;

import java.util.HashMap;
import java.util.function.Consumer;

public class Command {
	private String command;
	
	public Command( String aCommand) {
		command = aCommand;
	}
	
	public void apply( MarsRover marsrover) {
		for (int i = 0; i < command.length(); i++) {
			hashMap().getOrDefault(command.charAt(i), (obj) -> obj.stayPut()).accept( marsrover );
		}
	}
	
	public HashMap<Character, Consumer<MarsRover>> hashMap() {
		HashMap<Character, Consumer<MarsRover>> movementsMap = new HashMap<>();
		movementsMap.put("f".charAt(0), (obj) -> obj.moveForward() );
		movementsMap.put("b".charAt(0), (obj) -> obj.moveBackward() );
		movementsMap.put("l".charAt(0), (obj) -> obj.rotateLeft() );
		movementsMap.put("r".charAt(0), (obj) -> obj.rotateRight() );
		return movementsMap;
	}
}
