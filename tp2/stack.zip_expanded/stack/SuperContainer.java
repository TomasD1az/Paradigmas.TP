package stack;

import java.util.ArrayList;

public abstract class SuperContainer {
	
	static public SuperContainer containerWith( ArrayList<Object> array) {
		SuperContainer returnContainer = new EmptyContainer();
		for (int i = 0; i < array.size(); i++)
			returnContainer = returnContainer.push( array.get(i) );
		return returnContainer;
		
	}

	public abstract boolean isEmpty();

	public abstract SuperContainer push(Object object);

	public abstract SuperContainer pop();

	public abstract Object top();

	public abstract int size();

}
