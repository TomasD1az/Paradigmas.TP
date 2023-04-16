package stack;

import java.util.ArrayList;

public class ContainerWithItems extends SuperContainer {
	private ArrayList<Object>  array;
	
	public ContainerWithItems( Object object) {
		 array = new ArrayList<Object>();
		 array.add( object );
	}
	
	public boolean isEmpty() {
		return false;
	}

	public SuperContainer push(Object object) {
		array.add( object );
		return this;
	}
 
	public SuperContainer pop() {
		array.remove( size() - 1 );
		return containerWith( array );
	}

	public Object top() {
		return array.get( size() - 1 );
	}

	public int size() {
		return array.size();
	}

}
